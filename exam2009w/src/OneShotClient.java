import java.io.*;
import java.net.Socket;

public class OneShotClient {
    public static void main(String[] args) throws IOException {
        //Verbindung zum Server öffnen
        Socket socket = new Socket(args[0], Integer.parseInt(args[1]));

        //String zum Server schicken
        Writer writer = new OutputStreamWriter(socket.getOutputStream());
        for (char chr : args[2].toCharArray())
            writer.write(chr);
        writer.flush();

        socket.shutdownOutput();

        // Antwort vom Server auslesen und ausgeben
        Reader reader = new InputStreamReader(socket.getInputStream());

        for (int c = reader.read(); c != -1; c = reader.read())
            System.out.println((char) c);
        socket.close();
        System.out.flush();
    }
}
