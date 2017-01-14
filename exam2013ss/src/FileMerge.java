import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileMerge {
    public static void main(String... args) throws IOException {
        File destinationFile = new File(args[0]);

        List<File> files = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            files.add(new File(args[i]));
        }

        try (FileWriter fw = new FileWriter(destinationFile);
             BufferedWriter bw = new BufferedWriter(fw)
        ) {
            for (File file : files) {
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    bw.write(br.readLine());
                }
            }
        }
    }
}
