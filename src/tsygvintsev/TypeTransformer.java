package tsygvintsev;

import java.util.ArrayList;
import java.util.List;

public class TypeTransformer {
    public static <T, P> List<P> changeTypes(List<T> list, Function<T, P> function) {
        List<P> newList = new ArrayList<>();
        for (T item : list) {
            newList.add(function.apply(item));
        }

        return newList;
    }
}
