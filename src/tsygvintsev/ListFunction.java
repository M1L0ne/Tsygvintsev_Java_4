package tsygvintsev;

import java.util.ArrayList;
import java.util.List;

public class ListFunction {
    public static <T, P> List<P> changeTypes(List<T> list, Function<T, P> function) {
        List<P> result = new ArrayList<>();
        for (T item : list) {
            result.add(function.apply(item));
        }

        return result;
    }
}
