package biodanza.vista;

public interface DialogCaller
{
    public final static int OK = 0;
    public final static int CANCEL = 1;

    public void setAnswer(int button, Object answer);
}
