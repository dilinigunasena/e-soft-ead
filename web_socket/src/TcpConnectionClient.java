import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class TcpConnectionClient {
    public static void main(String[] args) {
        try {
            InetAddress acceptorHost = InetAddress.getByName(args[0]);
            int serverPortNumber = Integer.parseInt(args[1]);
            Socket clientSocket = new Socket(acceptorHost,serverPortNumber);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println(bufferedReader.readLine());
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
