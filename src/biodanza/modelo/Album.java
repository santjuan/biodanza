package biodanza.modelo;

import java.io.Serializable;
import java.util.Vector;

public class Album implements Serializable, Comparable<Album>
{
    private static final long serialVersionUID = -3465304888537025963L;

    public final String nombre;
    public final Coleccion padre;
    public final Vector<Cancion> canciones = new Vector<Cancion>();

    public Album(String n, Coleccion c)
    {
        nombre = n;
        padre = c;
    }

    @Override
    public String toString()
    {
        String nom = nombre;
        while(nom.length() < 50)
            nom += " ";
        return nom.substring(0, 50);
    }

    public int compareTo(Album o)
    {
        return nombre.compareTo(o.nombre);
    }
}
