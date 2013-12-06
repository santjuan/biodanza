package biodanza.modelo;

import java.io.File;

public class CancionAlias implements Cancion
{
    private static final long serialVersionUID = 9039300838152667333L;

    protected String cancionPadre;
    protected String nombre;
    protected transient Album album;

    public CancionAlias(String cancionPadre, String nombre, Album album)
    {
        this.cancionPadre = cancionPadre;
        this.nombre = nombre;
        this.album = album;
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
        return new File(cancionPadre);
    }

    @Override
    public Album getAlbum()
    {
        return album;
    }

    public String[] getEtiquetas()
    {
        if(Biodanza.canciones.contains(cancionPadre))
            return Biodanza.canciones.get(cancionPadre).getEtiquetas();
        else
            return new String[0];
    }

    public void setAlbum(Album a)
    {
        album = a;
    }

    public void agregarEtiqueta(String etiqueta)
    {
        if(Biodanza.canciones.contains(cancionPadre))
            Biodanza.canciones.get(cancionPadre).agregarEtiqueta(etiqueta);
    }

    public void eliminarEtiqueta(String escogida)
    {
        if(Biodanza.canciones.contains(cancionPadre))
            Biodanza.canciones.get(cancionPadre).eliminarEtiqueta(escogida);
    }

    @Override
    public String toString()
    {
        return getNombre();
    }

    @Override
    public String darLlaveHash()
    {
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