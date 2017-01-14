import java.util.List;
import java.util.ListIterator;

/**
 * Created by Sascha on 04/01/2017.
 */
public class revertCopyClass {
    public static <T> void revertCopy(List<? extends T> list1, List<? super T> list2){
        ListIterator<? extends T> it = list1.listIterator(list1.size());
        while(it.hasPrevious()){
            list2.add(it.previous());
        }
    }
}
