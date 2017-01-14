import java.util.Iterator;

/**
 * Created by Sascha on 02/01/2017.
 */
public class EulerFolge implements Iterable<Double> {
    private int n = 1;

    @Override
    public Iterator<Double> iterator() {
        return new Iterator<Double>() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Double next() {
                return Math.pow(1 + 1 / (double) n, n++);
            }
        };
    }
}
