package biodanza.modelo;

import java.io.Serializable;

public class Ejercicio implements Serializable, Cloneable
{
    private static final long serialVersionUID = -4663493401820566514L;

    private String nombre;
    private String objetivo;
    private String etiqueta;
    private Cancion cancion;

    public Ejercicio(String n, String ob)
    {
        nombre = n;
        objetivo = ob;
    }

    @Override
    public synchronized String toString()
    {
        return getNombre();
    }

    /**
     * @return the nombre
     */
    public synchronized String getNombre()
    {
        return nombre;
    }

    /**
     * @param nombre
     *            the nombre to set
     */
    public synchronized void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    /**
     * @return the objetivo
     */
    public synchronized String getObjetivo()
    {
        return objetivo;
    }

    /**
     * @param objetivo
     *            the objetivo to set
     */
    public synchronized void setObjetivo(String objetivo)
    {
        this.objetivo = objetivo;
    }

    /**
     * @return the cancion
     */
    public synchronized Cancion getCancion()
    {
        return cancion;
    }

    /**
     * @param cancion
     *            the cancion to set
     */
    public synchronized void setCancion(Cancion cancion)
    {
        this.cancion = cancion;
    }

    @Override
    public Object clone()
    {
        try
        {
            Ejercicio copia = (Ejercicio) super.clone();
            copia.nombre = nombre;
            copia.objetivo = objetivo;
            copia.etiqueta = etiqueta;
            copia.cancion = null;
            return copia;
        }
        catch(Exception e)
        {
            throw(new RuntimeException(e.getMessage()));
        }
    }

    /**
     * @return the etiqueta
     */
    public String getEtiqueta()
    {
        return etiqueta;
    }

    /**
     * @param etiqueta
     *            the etiqueta to set
     */
    public void setEtiqueta(String etiqueta)
    {
        this.etiqueta = etiqueta;
    }
}