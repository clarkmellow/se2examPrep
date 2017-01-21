import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Sascha on 04/01/2017.
 */
public class MultiServer {
    private static Integer nextPort = 2000;

    public static void main(String[] args) {
        for (final String arg : args)
            new Thread() {
                public void run() {
                    File f = new File(arg);
                    int p;
                    //p = nextPort++;   // Bestandteil von Teilaufgabe a)
                    synchronized (args) {
                        p = nextPort++;
                    } // Lösung von Teilaufgabe b)
                    try {
                        ServerSocket ss = new ServerSocket(p);
                        while (true) {
                            Socket s = ss.accept();
                            OutputStream o = s.getOutputStream();
                            InputStream i = new FileInputStream(f);
                            int b = i.read();
                            while (b >= 0) {
                                o.write(b);
                                b = i.read();
                            }
                            o.flush();
                            s.close();
                            i.close();
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }.start();
    }
}
