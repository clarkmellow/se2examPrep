import java.util.List;

public interface Ring<E> extends List<E> {
    // Liefert eine Instanz eines RingIterators
    RingIterator<E> ringIterator();
}
