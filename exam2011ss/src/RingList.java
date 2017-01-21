import java.util.ArrayList;
import java.util.Collection;

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
