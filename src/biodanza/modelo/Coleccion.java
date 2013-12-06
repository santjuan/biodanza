package biodanza.modelo;

import java.io.Serializable;
import java.util.Vector;

public class Coleccion implements Serializable, Comparable<Coleccion>
{
    private static final long serialVersionUID = 2126852391448455610L;

    public final String nombre;
    public final Vector<Album> albums = new Vector<Album>();

    public Coleccion(String n)
    {
        nombre = n;
    }

    private static final StringBuilder sb = new StringBuilder(300);

    @Override
    public synchronized String toString()
    {
        synchronized(Coleccion.class.getClass())
        {
            sb.setLength(0);
            sb.append(nombre);
            while(sb.length() < 50)
                sb.append(" ");
            return sb.substring(0, 50);
        }
    }

    public int compareTo(Coleccion o)
    {
        return nombre.compareTo(o.nombre);
    }
}