import java.util.Collection;
import java.util.LinkedList;

public class RingBuffer<E> extends LinkedList<E> {
    private final int max;

    public RingBuffer(int max) {
        this.max = max;
    }

    public RingBuffer(int max, Collection<E> collection) {
        this.max = max;
        int i = 0;
        for (E element : collection) {
            super.add(i % max, element);
            i++;
        }
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> collection) {
        if (collection == null) return false;

        for (E element : collection) {
            add(index, element);
            index++;
        }
        return true;
    }

    @Override
    public boolean add(E e) {
        if (max == super.size()) return false;

        add(0, e);
        return true;
    }

    @Override
    public void add(int index, E element) {
        if (max == super.size())
            super.set(index % max, element);
        else
            super.add(index % max, element);
    }

    @Override
    public E get(int index) {
        if (super.size() == 0) throw new IndexOutOfBoundsException();
        return super.get(index % max);
    }
}
