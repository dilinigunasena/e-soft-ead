import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpConnectionServer {

    public static void main(String[] args) {
        String message = args[0];
        int serverPort = Integer.parseInt(args[1]);
        try {
            ServerSocket connectionSocket = new ServerSocket(serverPort);
            Socket dataSocket = connectionSocket.accept();
            PrintStream socketOutput = new PrintStream(dataSocket.getOutputStream());
            socketOutput.println(message);
            System.out.println("------sent response to client------");
            socketOutput.flush();
            dataSocket.close();
            connectionSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
