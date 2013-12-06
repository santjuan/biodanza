package biodanza.modelo;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Similitud
{

    public static LinkedList<Similitud> lista;
    public Cancion ppal; // Canción respecto a la cual se mide la similitud
    public TreeMap<Object, Integer> similares; // Canciones similares a ppal
    public TreeSet<String> palabras;
    public boolean exacto = true;

    public boolean adicionar(Cancion c, int threshold)
    {
        int rep = 0;
        StringTokenizer tok = new StringTokenizer(c.getNombre(), " ,.-&_");
        ArrayList<String> palabrasMatched = new ArrayList<String>();
        while(tok.hasMoreTokens())
        {
            if(exacto)
            {
                if(palabras.contains(Normalizer.normalize(tok.nextToken().toLowerCase(), Normalizer.Form.NFD)
                    .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")))
                    rep++;
            }
            else
            {
                String token = Normalizer.normalize(tok.nextToken().toLowerCase(), Normalizer.Form.NFD).replaceAll(
                    "\\p{InCombiningDiacriticalMarks}+", "");
                for(String st : palabras)
                    if(!palabrasMatched.contains(st) && token.toLowerCase().contains(st))
                    {
                        palabrasMatched.add(st);
                        rep++;
                        break;
                    }
            }

        }
        if(rep >= threshold)
        {
            similares.put(c, rep);
            return true;
        }
        return false;
    }

    public boolean adicionar(String s, int threshold)
    {
        int rep = 0;
        StringTokenizer tok = new StringTokenizer(s, " ,.-&_");
        ArrayList<String> palabrasMatched = new ArrayList<String>();
        while(tok.hasMoreTokens())
        {
            if(exacto)
            {
                if(palabras.contains(Normalizer.normalize(tok.nextToken().toLowerCase(), Normalizer.Form.NFD)
                    .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")))
                    rep++;
            }
            else
            {
                String token = Normalizer.normalize(tok.nextToken().toLowerCase(), Normalizer.Form.NFD).replaceAll(
                    "\\p{InCombiningDiacriticalMarks}+", "");
                for(String st : palabras)
                    if(!palabrasMatched.contains(st) && token.toLowerCase().contains(st))
                    {
                        palabrasMatched.add(st);
                        rep++;
                        break;
                    }
            }

        }
        if(rep >= threshold)
        {
            similares.put(s, rep);
            return true;
        }
        return false;
    }

    public Similitud(Cancion ppal)
    {
        this.ppal = ppal;
        this.palabras = new TreeSet<String>();
        this.similares = new TreeMap<Object, Integer>(new Comparator<Object>()
        {
            public int compare(Object o1, Object o2)
            {
                if((o1 instanceof String) && !(o2 instanceof String))
                    return -1;
                if(!(o1 instanceof String) && (o2 instanceof String))
                    return 1;
                return o1.toString().compareTo(o2.toString());
            }

        });
        StringTokenizer tok = new StringTokenizer(ppal.getNombre(), " ,.-&_");
        while(tok.hasMoreTokens())
        {
            String s = tok.nextToken().toLowerCase();
            s = Normalizer.normalize(s, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
            if(s.length() > 3)
                palabras.add(s);
        }
    }

    public Similitud(String ppal)
    {
        this(new CancionReal(ppal, ppal, null));
    }

    public static void construir(LinkedList<Cancion> listaCanciones, int threshold)
    {
        if(lista == null)
        {
            lista = new LinkedList<Similitud>();
            for(Cancion c : listaCanciones)
            {
                boolean adicionado = false;
                for(Similitud s : lista)
                {
                    adicionado = s.adicionar(c, threshold);
                    if(adicionado)
                        break;
                }
                if(!adicionado)
                    lista.add(new Similitud(c));
            }
        }
    }
}