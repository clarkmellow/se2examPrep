import java.util.Iterator;
import java.util.List;

public class RingIterator<T> implements Iterator<T> {
    private int pos = 0;
    private List<? extends T> list;


    /**
     * Wie soll mit dem Fall umgegangen werden, bei dem eine leere Liste (size() == 0) übergeben wird?
     * Alle modulo divisionen mit "x % list.size()" würden eine Division durch 0 ergeben!!!
     * Es wird daher bei den folgenden Methoden davon ausgegangen, dass keine Listen mit size() == 0 aufgerufen werden.
     *
     * @param list
     */
    RingIterator(List<? extends T> list) {
        if (list == null) throw new IllegalArgumentException("List is null");
        // if(list.size() == 0) Was soll in diesem Fall passieren?
        this.list = list;
    }

    private int movePos(int diff) {
        pos = (pos + diff) % list.size();
        if (pos < 0) pos = pos + list.size();
        return pos;
    }

    @Override
    public boolean hasNext() {
        return list.size() > 0;
    }

    @Override
    public T next() {
        T result = list.get(pos);
        pos = (pos + 1) % list.size();
        return result;
    }

    @Override
    public void remove() {
        if (list.size() == 0) return;

        pos = pos - 1;
        if (pos < 0) {
            pos += list.size();
        }
        list.remove(pos);
    }
}
