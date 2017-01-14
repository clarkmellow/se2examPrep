import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sascha on 11/01/2017.
 */
public class BoundHashMap<K, V> extends HashMap<K, V> {
    public static final int MAX_SIZE = 5;
    private List<K> keys = new ArrayList<>();

    @Override
    public V put(K key, V value) {
        if (size() < MAX_SIZE) {
            if (keys.contains(key)) keys.remove(key);
            keys.add(key);
        } else {
            keys.remove(0);
            keys.add(key);
        }
        return super.put(key, value);
    }

    @Override
    public V remove(Object key) {
        keys.remove(key);
        return super.remove(key);
    }
}
