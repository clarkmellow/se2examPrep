import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.Thread.sleep;

/**
 * Testen mit folgendem Befehl: telnet localhost 57777
 * > Hallo <Enter drücken>
 * Ausgabe:
 * > HalloHalloHalloHalloHallo
 */
public class Kingslake {
    public static void main(String[] ignored) throws Exception {
        ServerSocket s = new ServerSocket(57777);

        try (Socket c = s.accept();
             BufferedReader r = new BufferedReader(new InputStreamReader(c.getInputStream()));
             BufferedWriter w = new BufferedWriter(new OutputStreamWriter(c.getOutputStream()))) {
            final String message = r.readLine();
            for (int i = message.length(); i > 0; i--) {
                w.write(message);
                w.flush();
                sleep(1_000);
            }
        }
    }
}
