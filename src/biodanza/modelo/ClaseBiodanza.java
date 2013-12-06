package biodanza.modelo;

import java.io.Serializable;
import java.util.Vector;

public class ClaseBiodanza implements Serializable, Cloneable
{
    private static final long serialVersionUID = -6250251282723243226L;

    private String nombre;
    private String descripcion;
    private Vector<Ejercicio> ejercicios = new Vector<Ejercicio>();
    public final Paquete paquete;

    public ClaseBiodanza(String n, Paquete p)
    {
        nombre = n;
        paquete = p;
    }

    public synchronized Ejercicio darEjercicio(int index)
    {
        if(index >= darTamano())
            return null;
        return ejercicios.get(index);
    }

    public synchronized void agregarEjercicio(Ejercicio e)
    {
        if(!ejercicios.contains(e))
            ejercicios.add(e);
    }

    public synchronized void eliminarEjercicio(Ejercicio actual)
    {
        ejercicios.remove(actual);
    }

    public void subirEjercicio(Ejercicio actual)
    {
        int indice = ejercicios.indexOf(actual);
        if(indice != -1)
        {
            ejercicios.remove(indice);
            indice--;
            if(indice == -1)
                indice = 0;
            ejercicios.add(indice, actual);
        }
    }

    public void bajarEjercicio(Ejercicio actual)
    {
        int indice = ejercicios.indexOf(actual);
        if(indice != -1)
        {
            ejercicios.remove(indice);
            indice++;
            if(indice > ejercicios.size())
                indice = ejercicios.size();
            ejercicios.add(indice, actual);
        }
    }

    public synchronized int darTamano()
    {
        return ejercicios.size();
    }

    public synchronized String darDescripcion()
    {
        return descripcion;
    }

    public synchronized void cambiarDescripcion(String nuevaDescripcion)
    {
        descripcion = nuevaDescripcion;
    }

    @Override
    public synchronized String toString()
    {
        return nombre;
    }

    @SuppressWarnings("unchecked")
    public Object clone(String nombre)
    {
        try
        {
            ClaseBiodanza copia = (ClaseBiodanza) super.clone();
            copia.nombre = nombre;
            copia.descripcion = descripcion;
            copia.ejercicios = (Vector<Ejercicio>) ejercicios.clone();
            for(int i = 0; i < ejercicios.size(); i++)
                copia.ejercicios.set(i, (Ejercicio) ejercicios.get(i).clone());
            return copia;
        }
        catch(CloneNotSupportedException e)
        {
            throw(new RuntimeException(e.getMessage()));
        }
    }
}