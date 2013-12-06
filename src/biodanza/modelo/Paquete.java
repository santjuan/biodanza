package biodanza.modelo;

import java.io.Serializable;
import java.util.Vector;

public class Paquete implements Serializable
{
    private static final long serialVersionUID = 970057192529829045L;

    private String nombre;
    private Vector<ClaseBiodanza> clases = new Vector<ClaseBiodanza>();

    public Paquete(String n)
    {
        nombre = n;
    }

    public synchronized ClaseBiodanza darClase(int index)
    {
        return clases.get(index);
    }

    public synchronized void agregarClase(ClaseBiodanza clase)
    {
        clases.add(clase);
    }

    public synchronized int darTamano()
    {
        return clases.size();
    }

    public synchronized int darIndex(Object o)
    {
        return clases.indexOf(o);
    }

    @Override
    public synchronized String toString()
    {
        return nombre;
    }

    synchronized void eliminarClase(ClaseBiodanza c)
    {
        clases.remove(c);
    }
}