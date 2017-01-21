import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class revertCopyClass {
    public static <T> void revertCopy(List<? extends T> list1, List<? super T> list2) {
        Collections.reverse(list1);
        Iterator<? extends T> iterator = list1.iterator();

        while (iterator.hasNext()) {
            list2.add(iterator.next());
        }
    }
}
