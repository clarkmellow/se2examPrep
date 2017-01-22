import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoService extends Thread {

    private final Socket socket;

    public EchoService(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("Connection with: " + socket.getInetAddress().getHostName() + " from port " + socket.getPort());
        System.out.println(socket.getChannel());
        try (Socket s = socket;
             InputStream reader = s.getInputStream();
             OutputStream writer = s.getOutputStream()) {
            while (true) {
                socket.setSoTimeout(3_600_000);        // timeout after one hour
                for (int i = reader.read(); i != -1; i = reader.read())
                    writer.write(i);
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Closed connection with: " + socket.getInetAddress().getHostName() + " from port " + socket.getPort());
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(7777);
        while (true)
            new EchoService(serverSocket.accept()).start();
    }
}
