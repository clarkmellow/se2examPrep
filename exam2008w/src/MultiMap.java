import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Sascha on 22/01/2017.
 */
public class MultiMap<U,V> extends HashMap<U, ArrayList<V>> {

    void add(U key, V value){
        if(!containsKey(key)){
            put(key, new ArrayList<V>());
        }
        get(key).add(value);
    }

    void putOnly(U key, V... values){
        put(key, new ArrayList<V>());

        for(V value:values)
            get(key).add(value);
    }

    V getAny(U key){
        V result = null;

        if(containsKey(key)){
            if(!get(key).isEmpty())
                result = get(key).get(0);
        }
        return result;
    }
}
