package tsygvintsev;

import java.util.ArrayList;
import java.util.List;

public class ListFilter {
    public static <T> List<T> filterList (List<T> list, Filter<T> filter){
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (filter.test(item)) {
                result.add(item);
            }
        }

        return result;
    }
}
