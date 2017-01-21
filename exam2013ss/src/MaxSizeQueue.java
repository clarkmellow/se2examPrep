import java.util.ArrayList;

public class MaxSizeQueue<T> {
    private final int maxSize;
    private final ArrayList<T> elements;

    public MaxSizeQueue(int maxSize) {
        this.maxSize = maxSize;
        this.elements = new ArrayList<>();
    }

    public synchronized void enqueue(T elementToInsert) {
        if (elements.size() == maxSize) return;
        elements.add(elementToInsert);
    }

    public synchronized T dequeue() {
        if (elements.size() == 0) return null;
        T result;
        result = elements.get(0);
        elements.remove(0);
        return result;
    }
}
