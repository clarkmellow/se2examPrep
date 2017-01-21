import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Copier extends Thread {

    private final InputStream i;
    private final OutputStream[] o;

    public Copier(InputStream i, OutputStream... o) {
        this.i = i;
        this.o = o;
    }

    @Override
    public void run() {
        try {
            int write = i.read();
            while (write != -1) {
                for (OutputStream out : o) {
                    out.write(write);
                    out.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
