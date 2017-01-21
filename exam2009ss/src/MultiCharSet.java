import java.util.Collection;
import java.util.HashMap;

/**
 * Created by Sascha on 20/01/2017.
 */
public class MultiCharSet extends HashMap<Character, Long> {

    public long contains(char key) {
        long result = 0;
        if (containsKey(key)) {
            result = get(key);
        }
        return result;
    }

    public MultiCharSet add(long n, char c) {
        if (containsKey(c)) {
            n += get(c);
        }
        put(c, n);
        return this;
    }

    public int size() {
        long result = 0;
        Collection<Long> values = values();
        for (Long elem : values) {
            result += elem;
        }
        return (int) result;
    }

    public MultiCharSet remove(long n, char c) {
        long count;
        if ((count = contains(c)) > 0) {
            if (count - n <= 0) {
                super.remove(c);
            } else {
                put(c, count - n);
            }
        }
        return this;
    }

    public boolean isIn(MultiCharSet that) {
        for (Entry<Character, Long> elem : entrySet()) {
            if (that.contains(elem.getKey()) < elem.getValue())
                return false;
        }
        return true;
    }
}
