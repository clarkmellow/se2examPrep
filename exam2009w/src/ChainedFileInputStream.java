import java.io.*;

public class ChainedFileInputStream extends InputStream {
    private final InputStream[] inputStreams;
    private int index;


    public ChainedFileInputStream(String... filenames) throws FileNotFoundException {
        inputStreams = new InputStream[filenames.length];

        for (int i = 0; i < filenames.length; i++) {
            inputStreams[i] = new FileInputStream(new File(filenames[i]));
        }
        index = 0;
    }

    public static void main(String[] args) throws IOException {
        ChainedFileInputStream test = new ChainedFileInputStream("README.md", "se2examPrep.iml");

        int c = test.read();
        while (c != -1) {
            System.out.print(Character.toString((char) c));
            c = test.read();
        }
    }

    @Override
    public int read() throws IOException {
        int result = inputStreams[index].read();
        if (result == -1) {
            if (index < inputStreams.length - 1) {
                inputStreams[index].close();
                index++;
                result = inputStreams[index].read();
            }
        }
        return result;
    }

    public void close() throws IOException {
        for (InputStream stream : inputStreams)
            stream.close();
    }
}
