import java.io.*;
import java.net.Socket;
import java.util.stream.Stream;

public class InputOutputOverview {
    public static void main(String[] args) throws IOException {
        // File-Stream Reader
        File file = new File("filename");   // creates new file

        InputStream fis = new FileInputStream("the_file_name");
        fis = new FileInputStream(file);
        int i = fis.read();     // no readLine();

        InputStreamReader isr = new InputStreamReader(fis);
        i = isr.read();     // no readLine();

        BufferedReader br = new BufferedReader(isr);
        Stream<String> streamString = br.lines();
        String readLine = br.readLine();

        // File-Stream Writer
        OutputStream fos = new FileOutputStream("filename");
        fos = new FileOutputStream(file);
        fos.write(new byte[10]);
        fos.write(8);   // no String-Writer

        OutputStreamWriter osw = new OutputStreamWriter(fos);
        osw.write("Test");
        osw.write(8);
        osw.write(new char[10]);

        BufferedOutputStream bos = new BufferedOutputStream(fos);
        bos.write(8);
        bos.write(new byte[10]); //no String-Writer

        PrintWriter printWriter = new PrintWriter("filename");
        printWriter = new PrintWriter(file);
        printWriter.println(); //Zeilenumbruch
        printWriter.print("teststring");
        printWriter.print('c'); // + long, double, boolean, etc.

        Socket s = new Socket("localhost", 80);
        InputStream is = s.getInputStream();
        int j = is.read();
        is.read(new byte[10]);

        InputStreamReader nisr = new InputStreamReader(is);
        BufferedInputStream bisr = new BufferedInputStream(is);

        OutputStream os = s.getOutputStream();
        os.write(8);
        os.write(new byte[10]);

        OutputStreamWriter osr = new OutputStreamWriter(os);
        osr.write("Write string");
    }
}
