import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends FirstImpl{
    public Server(){};

    public static void main(String[] args) {
        FirstImpl firstImpl = new FirstImpl();

        try {
            /**
             * In RMI, the client helper is known as ‘stub’ and server helper is known as ‘skeleton
             * */
            FirstRmi stub = (FirstRmi) UnicastRemoteObject.exportObject(firstImpl,0);

            /**
             * What is UnicastRemoteObject - Used for exporting a remote object with JRMP and obtaining a stub that communicates to the remote object.
             * Stubs are either generated at runtime using dynamic proxy objects, or they are generated statically at build time, typically using the rmic tool.
             * **/
            Registry registry = LocateRegistry.getRegistry();
            /**
             * What is Registry - Registry is a remote interface to a simple remote object registry that provides methods for storing and retrieving remote object references bound with arbitrary string names.
             * The bind, unbind, and rebind methods are used to alter the name bindings in the registry, and the lookup and list methods are used to query the current name bindings.
             * In its typical usage, a Registry enables RMI client bootstrapping: it provides a simple means for a client to obtain an initial reference to a remote object
             * **/

            /**
             * Binding the remote object "stub" with the name "myFirst"*/
            registry.bind("myFirst",stub);
            System.err.println("server error");
        } catch (Exception e) {
            System.err.println("Server Error : "+e.toString());
            e.printStackTrace();
        }
    }
}
