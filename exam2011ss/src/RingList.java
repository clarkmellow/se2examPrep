import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Sascha on 04/01/2017.
 */
public class RingList<E> extends ArrayList<E> implements Ring<E> {

    public RingList() {
        super(10);
    }

    public RingList(Collection<? extends E> c) {
        super(c);
    }

    public RingList(int cap) {
        super(cap);
    }

    @Override
    public RingIterator<E> ringIterator() {
        return new RingIterator<E>(this);
    }
}
