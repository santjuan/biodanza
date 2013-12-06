package biodanza.modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Persistencia
{
    public static final String ruta = "persistencia/";
    private static volatile long cargadoActual = 0;

    public static void comprimir(File f, File carpeta)
    {
        byte[] buffer = new byte[1024];
        try
        {
            FileOutputStream fos = new FileOutputStream(new File(carpeta, f.getName() + ".zip"));
            ZipOutputStream zos = new ZipOutputStream(fos);
            ZipEntry ze = new ZipEntry(f.getName());
            zos.putNextEntry(ze);
            FileInputStream in = new FileInputStream(f);
            int len;
            while((len = in.read(buffer)) > 0)
                zos.write(buffer, 0, len);
            in.close();
            zos.closeEntry();
            zos.close();
        }
        catch(IOException ex)
        {
            throw(new RuntimeException(ex.getMessage()));
        }
    }

    private static void descomprimir(File file, File carpetaPersistencia)
    {
        byte[] buffer = new byte[1024];

        try
        {
            ZipInputStream zis = new ZipInputStream(new FileInputStream(file));
            ZipEntry ze = zis.getNextEntry();
            while(ze != null)
            {
                String fileName = ze.getName();
                File newFile = new File(carpetaPersistencia.getAbsolutePath(), fileName);
                new File(newFile.getParent()).mkdirs();
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while((len = zis.read(buffer)) > 0)
                    fos.write(buffer, 0, len);
                fos.close();
                ze = zis.getNextEntry();
            }
            zis.closeEntry();
            zis.close();
            System.out.println("Done");
        }
        catch(IOException ex)
        {
            throw(new RuntimeException(ex.getMessage()));
        }

    }

    @SuppressWarnings("unchecked")
    public static void cargarPersistencia(long time)
    {
        File carpetaPersistencia = new File(ruta);
        carpetaPersistencia.mkdirs();
        File ultimaPersistencia = null;
        if(time == 0)
        {
            File[] files = carpetaPersistencia.listFiles();
            if(files.length == 0)
                return;
            Arrays.sort(files, Collections.reverseOrder());
            if(files.length > 1000)
                for(int i = files.length - 1; i >= 1000; i--)
                    files[i].delete();
            ultimaPersistencia = files[0];
            for(int i = 2; i < files.length; i++)
                if(!files[i].getName().contains("zip"))
                {
                    comprimir(files[i], carpetaPersistencia);
                    files[i].delete();
                }
        }
        else
        {
            for(File f : carpetaPersistencia.listFiles())
                if(f.getName().contains("" + time))
                    if(f.getName().contains(".zip"))
                        descomprimir(f, carpetaPersistencia);
            for(File f : carpetaPersistencia.listFiles())
                if(f.getName().contains("" + time))
                    if(!f.getName().contains(".zip"))
                        ultimaPersistencia = f;
        }
        ObjectInputStream ois = null;
        try
        {
            ois = new ObjectInputStream(new FileInputStream(ultimaPersistencia));
            cargadoActual = Long.parseLong(ultimaPersistencia.getName().trim());
            Hashtable<String, Cancion> canciones = (Hashtable<String, Cancion>) ois.readObject();
            for(Map.Entry<String, Cancion> e : canciones.entrySet())
            {
                if(e.getValue() == null)
                    continue;
                String llave = e.getValue().darLlaveHash();
                if(Biodanza.canciones.containsKey(llave))
                {
                    Cancion otra = Biodanza.canciones.get(llave);
                    Cancion esta = e.getValue();
                    for(String et : esta.getEtiquetas())
                        otra.agregarEtiqueta(et);
                }
                else
                {
                    Biodanza.canciones.put(llave, e.getValue());
                }
            }
            Vector<Paquete> paquetes = (Vector<Paquete>) ois.readObject();
            for(Paquete p : paquetes)
                for(int i = 0; i < p.darTamano(); i++)
                {
                    ClaseBiodanza cb = p.darClase(i);
                    for(int j = 0; j < cb.darTamano(); j++)
                    {
                        Ejercicio ej = cb.darEjercicio(j);
                        Cancion c = ej.getCancion();
                        if(c != null)
                        {
                            String llave = c.darLlaveHash();
                            if(Biodanza.canciones.containsKey(llave))
                                c = Biodanza.canciones.get(llave);
                        }
                        ej.setCancion(c);
                    }
                }
            Biodanza.paquetes = paquetes;
            Biodanza.plantillas = (Vector<Ejercicio>) ois.readObject();
        }
        catch(Exception e)
        {
            throw(new RuntimeException(e.getMessage()));
        }
        finally
        {
            try
            {
                ois.close();
            }
            catch(Exception e)
            {
                throw(new RuntimeException(e.getMessage()));
            }
        }
    }

    public static void guardarPersistencia()
    {
        ObjectOutputStream oos = null;
        try
        {
            long currentTime = System.currentTimeMillis();
            if(currentTime < cargadoActual)
                currentTime = cargadoActual + 1;
            String archivo = ruta + currentTime;
            oos = new ObjectOutputStream(new FileOutputStream(new File(archivo)));
            oos.writeObject(Biodanza.canciones);
            oos.writeObject(Biodanza.paquetes);
            oos.writeObject(Biodanza.plantillas);
        }
        catch(Exception e)
        {
            throw(new RuntimeException(e.getMessage()));
        }
        finally
        {
            try
            {
                oos.close();
            }
            catch(Exception e)
            {
                throw(new RuntimeException(e.getMessage()));
            }
        }
    }
}