import java.util.function.Function;

public class CachingFunction<T, R> implements Function<T, R> {
    private final BoundHashMap<T, R> boundHashMap;
    private final Function<T, R> function;

    public CachingFunction(Function<T, R> function) {
        this.boundHashMap = new BoundHashMap<>();
        this.function = function;
    }

    @Override
    public R apply(T t) {
        if (boundHashMap.containsKey(t)) {
            return boundHashMap.get(t);
        } else {
            R result = function.apply(t);
            boundHashMap.put(t, result);
            return result;
        }
    }
}
