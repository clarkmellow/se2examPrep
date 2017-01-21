import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class SetList<T> extends ArrayList<T> {
    public SetList() {
    }

    ;

    public SetList(Collection<T> c) {
        if (c == null) throw new RuntimeException();

        addAll(c);
    }

    public static void main(String[] args) {
        SetList<String> sls = new SetList<>();
        System.out.println(sls.add("foo") + " " + sls);
        System.out.println(sls.add("bar") + " " + sls);
        System.out.println(sls.add("foo") + " " + sls);
        System.out.println(sls.set(0, "baz") + " " + sls);
        System.out.println(sls.set(0, "bar") + " " + sls);
        System.out.println(sls.size());
    }

    public boolean add(T e) {
        if (contains(e)) return false;

        super.add(e);
        return true;
    }

    public boolean addAll(Collection<? extends T> c) {
        Iterator<? extends T> elements = c.iterator();
        boolean result = false;

        while (elements.hasNext()) {
            T element = elements.next();
            if (!contains(element)) {
                result = true;
                add(element);
            }
        }
        return result;
    }

    public T set(int i, T e) {
        if (i >= size()) throw new RuntimeException();

        T result = null;
        if (!contains(e)) {
            result = get(i);
            super.set(i, e);
        }
        return result;
    }
}
