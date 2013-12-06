package biodanza.modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import biodanza.vista.BiodanzaG;

public class Main
{
    static final String PATH_MUSICA = leerPath();

    static String leerPath()
    {
        try
        {
            boolean windows = System.getProperty("os.name").toLowerCase().indexOf("win") >= 0;
            @SuppressWarnings("resource")
            Scanner sc = new Scanner(new File(windows ? "pathWindows.txt" : "pathLinux.txt"));
            return sc.next();
        }
        catch(FileNotFoundException ex)
        {
            throw(new RuntimeException(ex.getMessage()));
        }
    }

    static Vector<Coleccion> darColecciones()
    {
        File inicial = new File(PATH_MUSICA);
        Vector<Coleccion> colecciones = new Vector<Coleccion>();
        for(File f : inicial.listFiles())
        {
            if(f.getName().contains("."))
                continue;
            Coleccion c = new Coleccion(f.getName());
            if(f.isDirectory())
                for(File f1 : f.listFiles())
                {
                    if(!f1.isDirectory())
                        continue;
                    Album a = new Album(f1.getName(), c);
                    if(f1.isDirectory())
                        for(File f2 : f1.listFiles())
                        {
                            if(!f2.getName().toLowerCase().endsWith(".mp3"))
                                continue;
                            Cancion ca = new CancionReal(f2.getName(), f2.getAbsolutePath(), a);
                            a.canciones.add(ca);
                        }
                    c.albums.add(a);
                }
            colecciones.add(c);
        }
        return colecciones;
    }

    public static final AtomicReference<Thread> hiloPersistencia = new AtomicReference<Thread>();
    public static final AtomicBoolean cargandoAntiguo = new AtomicBoolean(false);

    public static void firstLoad(long time)
    {
        Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler()
        {
            @Override
            public void uncaughtException(Thread t, Throwable e)
            {
                JOptionPane.showMessageDialog(null, "Error: " + e.toString());
            }
        });
        try
        {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch(Exception ex)
        {
            try
            {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
            }
            catch(Exception ex1)
            {
                throw(new RuntimeException(ex.getMessage() + " " + ex1.getMessage()));
            }
        }
        boolean newThread = false;
        if(hiloPersistencia.get() != null)
            hiloPersistencia.get().interrupt();
        else
        {
            try
            {
                Thread.sleep(10000);
            }
            catch(Exception e)
            {
            }
            hiloPersistencia.set(new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    while(true)
                    {
                        try
                        {
                            Thread.sleep(300000);
                        }
                        catch(Throwable t)
                        {
                            return;
                        }
                        if(Thread.currentThread().isInterrupted())
                            return;
                        Persistencia.guardarPersistencia();
                    }
                }
            }));
            newThread = true;
        }
        Biodanza.colecciones = darColecciones();
        for(Coleccion c : Biodanza.colecciones)
            for(Album a : c.albums)
                for(Cancion ca : a.canciones)
                    Biodanza.canciones.put(ca.darLlaveHash(), ca);
        Persistencia.cargarPersistencia(time);
        for(Coleccion c : Biodanza.colecciones)
            for(Album a : c.albums)
                for(Cancion ca : a.canciones)
                    Biodanza.todasCanciones.add(ca);
        if(newThread)
            hiloPersistencia.get().start();
        cargandoAntiguo.set(!newThread);
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                BiodanzaG dialog = new BiodanzaG(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter()
                {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e)
                    {
                        if(cargandoAntiguo.get())
                        {
                            if(JOptionPane.showConfirmDialog(null,
                                "Desea guardar los cambios obtenido de una version vieja?", "Guardar",
                                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                                Persistencia.guardarPersistencia();
                        }
                        else
                            Persistencia.guardarPersistencia();
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public static void main(String[] args)
    {
        firstLoad(0L);
    }
}