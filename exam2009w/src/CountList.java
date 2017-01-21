import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountList<T> extends ArrayList<T> {
    private final Map<T, Integer> counts = new HashMap<>();

    public int count(T e) {
        int result = 0;
        if (counts.containsKey(e))
            result = counts.get(e);
        return result;
    }

    public Map<T, Integer> counts() {
        return new HashMap<>(counts);   // Diamond-Operator möglich, da in Rückgabewert definiert.
    }

    public boolean add(T e) {
        super.add(e);
        if (counts.containsKey(e)) {
            int c = counts.get(e);
            counts.put(e, c + 1);
        } else {
            counts.put(e, 1);
        }
        return true;
    }

    public boolean remove(Object x) {
        boolean result = false;
        if (counts.containsKey(x)) {
            super.remove(x);
            int c = counts.get(x);
            if (c == 1) {
                counts.remove(x);
            } else {
                counts.put((T) x, c - 1);
            }
            result = true;
        }
        return result;
    }

    public T set(int i, T e) {
        T result = super.get(i);
        super.set(i, e);

        if (!result.equals(e)) {
            remove(result);
            add(e);
        }
        return result;
    }

    public void increment(T e) {
        if (counts.containsKey(e)) {
            int c = counts.get(e);
            counts.put(e, c + 1);
            super.add(e);
        }
    }

    public void decrement(T e) {
        remove(e);
    }
}
