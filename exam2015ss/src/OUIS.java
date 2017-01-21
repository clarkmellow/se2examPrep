import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by Sascha on 12/01/2017.
 */
public class OUIS extends InputStream {
    final private List<Integer> numbers = new ArrayList<>();
    final private Comparator<Integer> comparator;
    final private Integer stopper;
    // Objektvariablen
    private boolean readCalled;

    public OUIS(Comparator<Integer> comparator, Integer stopper) {
        this.comparator = comparator;
        this.stopper = stopper;
        readCalled = false;
    }

    public void add(Integer i) {
        if (readCalled) throw new ConcurrentModificationException();

        boolean doAdd = true;
        for (Integer n : numbers) {
            doAdd = !(comparator.compare(n, i) == 0);
        }
        if (doAdd) numbers.add(i);
        Collections.sort(numbers, comparator);
    }

    public int available() {
        return numbers.size();
    }

    @Override
    public int read() throws IOException {
        readCalled = true;
        int result = stopper;
        if (available() > 0) {
            result = numbers.remove(0);
        }
        return result;
    }
}
