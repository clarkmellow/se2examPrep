import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Sascha on 12/01/2017.
 */
public class Pile<T> {
    /**
     * Hinweis: Laut Aufgabenstellung soll der Referenztyp "T" verwendet werden. Zur Vereinfachung wurde "Object" genommen.
     */
    Map<T, Integer> values = new HashMap<>();

    /**
     * Testen der Pile-Klasse. Nicht Teil der Aufgabe.
     *
     * @param ignored Command-Line args are ignored.
     */
    public static void main(String[] ignored) {
        Pile pile = new Pile();
        pile.add(5);
        pile.add(5);
        pile.add(3);
        pile.add(3);
        pile.add(1);
        System.out.println(pile.size());
        System.out.println(pile.remove(5, 3, 9, 5, 1, 1, 8));
        System.out.println(pile.size());
    }

    public int numberOfElement(Object element) {
        int result = 0;
        if (values.containsKey(element)) {
            return values.get(element);
        }
        return result;
    }

    public void add(T element) {
        if (values.containsKey(element)) {
            values.put(element, values.get(element) + 1);
        } else {
            values.put(element, 1);
        }
    }

    public int size() {
        int result = 0;
        Set<Map.Entry<T, Integer>> value = values.entrySet();
        Iterator<Map.Entry<T, Integer>> it = value.iterator();
        while (it.hasNext()) {
            Map.Entry<T, Integer> elem = it.next();
            result += elem.getValue();
        }
        return result;
    }

    public boolean remove(T element) {
        boolean result = false;
        if (values.containsKey(element)) {
            int numberOfElements = values.get(element);
            values.put(element, numberOfElements - 1);
            if (numberOfElements == 1) values.remove(element);
            result = true;
        }
        return result;
    }

    public boolean remove(T... elements) {
        boolean result = false;
        for (T element : elements) {
            if (remove(element)) result = true;
        }
        return result;
    }
}
