import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class CharFilterWriter extends FilterWriter {
    private final char excludedChar;

    public CharFilterWriter(Writer out, char excludedChar) {
        super(out);
        this.excludedChar = excludedChar;
    }

    @Override
    public void write(int b) throws IOException {
        if (excludedChar != b)
            super.write(b);
    }

    @Override
    public void write(char[] a, int start, int len) throws IOException {
        for (int i = start; i < start + len; i++) {
            write(a[i]);
        }
    }

    @Override
    public void write(String s, int start, int len) throws IOException {
        char[] cbuf = s.toCharArray();
        write(cbuf, start, len);
    }
}
