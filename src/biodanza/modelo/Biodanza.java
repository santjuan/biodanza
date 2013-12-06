package biodanza.modelo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

public class Biodanza
{
    public static volatile Vector<Paquete> paquetes = new Vector<Paquete>();
    public static final Vector<Cancion> todasCanciones = new Vector<Cancion>();
    public static volatile Vector<Coleccion> colecciones = new Vector<Coleccion>();
    public static volatile Hashtable<String, Cancion> canciones = new Hashtable<String, Cancion>();
    public static volatile Vector<Ejercicio> plantillas = new Vector<Ejercicio>();
    private static final Hashtable<String, Cancion[]> cancionesEtiquetas = new Hashtable<String, Cancion[]>();

    public static synchronized Paquete darPaquete(int index)
    {
        return paquetes.get(index);
    }

    public static synchronized void agregarPaquete(Paquete p)
    {
        paquetes.add(p);
    }

    public static synchronized int darTamano()
    {
        return paquetes.size();
    }

    public static synchronized int darIndex(Object o)
    {
        return paquetes.indexOf(o);
    }

    public static synchronized Object[] darPaquetes()
    {
        return paquetes.toArray();
    }

    public static synchronized void eliminarPaquete(Paquete o)
    {
        paquetes.remove(o);
    }

    public static synchronized Coleccion darColeccionCancion(Cancion c)
    {
        for(Coleccion co : colecciones)
            for(Album a : co.albums)
                for(Cancion ca : a.canciones)
                    if(ca == c)
                        return co;
        return null;
    }

    public static synchronized Album darAlbumCancion(Cancion c)
    {
        for(Coleccion co : colecciones)
            for(Album a : co.albums)
                for(Cancion ca : a.canciones)
                    if(ca == c)
                        return a;
        return null;
    }

    public static synchronized void eliminarClase(Object o)
    {
        ClaseBiodanza c = (ClaseBiodanza) o;
        c.paquete.eliminarClase(c);
    }

    public static synchronized Cancion[] darCancionesEtiqueta(String etiqueta)
    {
        if(!cancionesEtiquetas.containsKey(etiqueta))
        {
            Vector<Cancion> todas = new Vector<Cancion>();
            for(Coleccion co : colecciones)
                for(Album a : co.albums)
                    for(Cancion ca : a.canciones)
                        for(String s : ca.getEtiquetas())
                            if(s.trim().equals(etiqueta))
                            {
                                todas.add(ca);
                                break;
                            }
            cancionesEtiquetas.put(etiqueta, todas.toArray(new Cancion[0]));
        }
        return cancionesEtiquetas.get(etiqueta);
    }

    private static Set<String> etiquetas;
    private static volatile String[] todasEtiquetas;

    public static String[] darEtiquetas()
    {
        if(etiquetas == null)
        {
            etiquetas = Collections.synchronizedSet(new TreeSet<String>());
            for(Coleccion co : colecciones)
                for(Album a : co.albums)
                    for(Cancion ca : a.canciones)
                        etiquetas.addAll(Arrays.asList(ca.getEtiquetas()));
            for(Ejercicio e : plantillas)
                if(!e.getEtiqueta().trim().isEmpty())
                    etiquetas.add(e.getEtiqueta());
        }
        if(todasEtiquetas == null)
        {
            todasEtiquetas = etiquetas.toArray(new String[0]);
            Arrays.sort(todasEtiquetas);
        }
        return todasEtiquetas;
    }

    public static void agregarEtiqueta(String nuevaEtiqueta)
    {
        etiquetas.add(nuevaEtiqueta);
        todasEtiquetas = null;
    }

    public static void recalcularEtiqueta(String etiqueta)
    {
        cancionesEtiquetas.remove(etiqueta);
        if(darCancionesEtiqueta(etiqueta).length == 0)
        {
            etiquetas.remove(etiqueta);
            todasEtiquetas = null;
        }
    }
}