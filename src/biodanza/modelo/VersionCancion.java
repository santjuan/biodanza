package biodanza.modelo;

public class VersionCancion extends CancionAlias
{
    private static final long serialVersionUID = 9173343996346452062L;

    public VersionCancion(String cancionPadre, String nombre, Album album)
    {
        super(cancionPadre, nombre, album);
    }
}