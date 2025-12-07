package tsygvintsev;

import java.util.ArrayList;
import java.util.List;

public class ListFilter {
    public static <T> List<T> filterList (List<T> list, Filter<T> filter){
        List<T> newList = new ArrayList<>();
        for (T item : list) {
            if (filter.test(item)) {
                newList.add(item);
            }
        }

        return newList;
    }
}
