import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Sascha on 20/01/2017.
 */
public class UnwriteOutputStream {
    private final OutputStream outputStream;
    private int lastWrite;
    private boolean allowedToWrite;

    public UnwriteOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
        this.lastWrite = -1;
        this.allowedToWrite = false;
    }

    public int write(int b) {
        lastWrite = b;
        allowedToWrite = true;
        try {
            outputStream.write(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b;
    }

    public int unwrite() {
        int result = -1;
        if (allowedToWrite) result = lastWrite;
        allowedToWrite = false;
        return result;
    }

    public void close() {
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
