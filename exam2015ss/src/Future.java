/**
 * Created by Sascha on 12/01/2017.
 */
public class Future {
    private final Thread supplier;
    private Object result;

    public Future(Runnable supplier) {
        if (supplier == null) throw new RuntimeException();
        this.supplier = new Thread(supplier);
        this.supplier.start();
    }

    public Object get() {
        try {
            supplier.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public boolean available() {
        return supplier.isAlive();
    }


}
