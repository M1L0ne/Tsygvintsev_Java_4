package tsygvintsev;

import java.util.ArrayList;
import java.util.List;

public class TypeTransformer {
    public static <T, P> List<P> changeTypes(List<T> oldList, Function<T, P> function) {
        List<P> newList = new ArrayList<>();
        for (T item : oldList) {
            newList.add(function.apply(item));
        }

        return newList;
    }
}
