package biodanza.modelo;

import java.io.File;
import java.io.Serializable;

public interface Cancion extends Comparable<Cancion>, Serializable
{
    public String getNombre();

    public File getFile();

    public Album getAlbum();

    public String[] getEtiquetas();

    public void setAlbum(Album a);

    public void agregarEtiqueta(String etiqueta);

    public void eliminarEtiqueta(String escogida);

    public String darLlaveHash();
}