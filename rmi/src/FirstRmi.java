import java.rmi.Remote;

public interface FirstRmi extends Remote {
    public int doCal(int x , int y) throws Exception;
}
