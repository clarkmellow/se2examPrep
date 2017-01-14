import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Sascha on 02/01/2017.
 */
public class ClientServer {

    public static void main(String[] args) throws InterruptedException {
        new ClientServer().go(2000, 2001, "Message1");
        new ClientServer().go(2001, 2000, "Message2");
    }

    void go(final int serverport, final int clientport, final String message) throws InterruptedException {
        runClient(clientport);
        runServer(serverport, message);
    }

    private void runClient(int clientport) throws InterruptedException {
        Runnable clientThread = () -> {
            try {
                System.out.println("Client started");
                while (true) {
                    Socket clientSocket = new Socket("localhost", clientport);
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                        System.out.println("read");
                        System.out.println(reader.readLine());
                        System.out.println("read next");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        new Thread(clientThread).start();
    }

    private void runServer(int serverport, String message) {
        Runnable serverThread = () -> {
            try {
                System.out.println("Server started");
                ServerSocket serverSocket = new ServerSocket(serverport);
                while (true) {
                    System.out.println("Waiting for clients");
                    Socket client = serverSocket.accept();
                    System.out.println("Connected with " + client.getInetAddress() + " on port " + client.getPort() + " on local port " + client.getLocalPort());

                    try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))) {
                        System.out.println("write");
                        writer.write(message);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        new Thread(serverThread).start();
    }
}
