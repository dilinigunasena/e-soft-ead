import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client{
    public Client(){}

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(null);
            /** search the remote object with the name "myFirst"*/
            FirstRmi stub = (FirstRmi) registry.lookup("myFirst");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter x :");
            int x = scanner.nextInt();
            System.out.println("Enter y:");
            int y = scanner.nextInt();
            int answer = stub.doCal(x,y);
            System.out.println("Answer : "+ answer);
        } catch (Exception e) {
            System.err.println("Client Exception :"+ e.toString());
            e.printStackTrace();
        }
    }

}
