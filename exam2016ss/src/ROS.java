import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Sascha on 11/01/2017.
 */
public class ROS extends FilterOutputStream {
    private long firstWrite;
    private long lastWrite;
    private long sumBytes;

    /**
     * Creates an output stream filter built on top of the specified
     * underlying output stream.
     *
     * @param out the underlying output stream to be assigned to
     *            the field <tt>this.out</tt> for later use, or
     *            <code>null</code> if this instance is to be
     *            created without an underlying stream.
     */
    public ROS(OutputStream out) {
        super(out);
    }

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        byte[] array = new byte[1024 * 1024];
        try (ROS test = new ROS(new FileOutputStream("test1.vcf", true))) {
            test.write(array);
            System.out.println(test.getRate() + " bytes/second");
        }
        System.out.println("Duration: " + (System.currentTimeMillis() - startTime) / 1000);
        System.out.println("Datarate: " + array.length / ((System.currentTimeMillis() - startTime) / 1000) + " bytes/second");
    }

    @Override
    public void write(int b) throws IOException {
        if (firstWrite == 0) firstWrite = System.currentTimeMillis();
        sumBytes++;
        lastWrite = System.currentTimeMillis();
        super.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        if (firstWrite == 0) firstWrite = System.currentTimeMillis();
        sumBytes += b.length;
        lastWrite = System.currentTimeMillis();
        super.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        if (firstWrite == 0) firstWrite = System.currentTimeMillis();
        sumBytes += len;
        lastWrite = System.currentTimeMillis();
        super.write(b, off, len);
    }

    public double getRate() {
        long sendingDuration = lastWrite - firstWrite;
        if (sendingDuration < 1000) return -1;

        return sumBytes / (sendingDuration / 1000);
    }
}
