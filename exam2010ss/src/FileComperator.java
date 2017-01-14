import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;

/**
 * Created by Sascha on 11/01/2017.
 */
public class FileComperator implements Comparator<File> {
    @Override
    public int compare(File file1, File file2) {
        long result = 0;
        result = file2.length() - file1.length();
        if(result == 0){
            try(FileReader r1 = new FileReader(file1);
            FileReader r2 = new FileReader(file2)){
                int b1 = 0;
                int b2 = 0;
                while (result == 0 && b1 != -1){
                    b1 = r1.read();
                    b2 = r2.read();
                    result = b2 - b1;
                }
            } catch (IOException e){
                throw new IllegalArgumentException(e);
            }
        }

        return (int) result;
    }


    public static void main(String[] args) {
        File file1 = new File("test.pptx");
        File file2 = new File("test.vcf");
        FileComperator test = new FileComperator();

        System.out.println(test.compare(file1, file2));
    }
}
