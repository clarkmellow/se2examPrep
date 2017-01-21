import java.io.*;

/**
 * Created by Sascha on 02/01/2017.
 */
public class CharFilterCopy {
    private final Reader filteredOutputReader;
    private Writer filteredOutputWriter;


    public CharFilterCopy(Writer w, Reader r, char[] charset) throws IOException {
        filteredOutputReader = r;

        filteredOutputWriter = w;
        for (char excludedChar : charset) {
            filteredOutputWriter = new CharFilterWriter(filteredOutputWriter, excludedChar);
        }
    }

    /**
     * Main only for testing. Not part of the exam.
     *
     * @param ignored No command line arguments used.
     * @throws IOException Throws exception if read or write error occur.
     */
    public static void main(String[] ignored) throws IOException {
        // Use filter 1
        CharFilterCopy charFilter1Copy = new CharFilterCopy(new FileWriter("test_filter1.txt"), new FileReader("input.txt"), "aeiouAEIOU".toCharArray());
        charFilter1Copy.filter1();

        // Use filter 2
        CharFilterCopy charFilter2Copy = new CharFilterCopy(new FileWriter("test_filter2.txt"), new FileReader("input.txt"), "aeiouAEIOU".toCharArray());
        charFilter2Copy.filter2();
    }

    public void filter1() throws IOException {
        for (int readChar = filteredOutputReader.read(); readChar != -1; readChar = filteredOutputReader.read()) {
            filteredOutputWriter.write(readChar);
        }
        filteredOutputWriter.flush();
    }

    public void filter2() throws IOException {
        int charRead = filteredOutputReader.read();
        if (charRead == -1) {
            return;
        }
        filteredOutputWriter.write(charRead);
        filteredOutputWriter.flush();
        filter2();
    }
}
