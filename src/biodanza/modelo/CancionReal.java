package biodanza.modelo;

import java.io.File;
import java.util.Vector;

public class CancionReal implements Cancion
{
    private static final long serialVersionUID = -2187066925682551069L;

    private final String nombre;
    private transient Album album;
    private Vector<VersionCancion> versiones = new Vector<VersionCancion>();
    private Vector<String> etiquetas = new Vector<String>();
    private transient String[] etiquetasA = null;

    public CancionReal(String nombre, String filePath, Album a)
    {
        this.nombre = nombre.substring(0, Math.min(100, nombre.length()));
        this.album = a;
        versiones.add(new VersionCancion(filePath, nombre, a));
    }

    @Override
    public int compareTo(Cancion o)
    {
        return nombre.compareTo(o.getNombre());
    }

    @Override
    public String getNombre()
    {
        return nombre;
    }

    @Override
    public File getFile()
    {
        return versiones.get(0).getFile();
    }

    @Override
    public Album getAlbum()
    {
        return album;
    }

    public void agregarEtiqueta(String e)
    {
        if(!etiquetas.contains(e))
        {
            etiquetas.add(e);
            etiquetasA = null;
        }
    }

    public String[] getEtiquetas()
    {
        if(etiquetasA == null)
            return etiquetasA = etiquetas.toArray(new String[0]);
        else
            return etiquetasA;
    }

    public void setAlbum(Album a)
    {
        album = a;
    }

    public void eliminarEtiqueta(String escogida)
    {
        etiquetas.remove(escogida);
        etiquetasA = null;
    }

    @Override
    public String toString()
    {
        return getNombre();
    }

    @Override
    public String darLlaveHash()
    {
        if(getFile() == null)
            return "";
        String path = getFile().getPath();
        int cuenta = 0;
        int indice = 0;
        for(int i = path.length() - 1; i >= 0; i--)
        {
            if(path.charAt(i) == '/' || path.charAt(i) == '\\')
                cuenta++;
            if(cuenta == 3)
            {
                indice = i;
                break;
            }
        }
        return path.substring(indice).replace("/", "\\");
    }
}