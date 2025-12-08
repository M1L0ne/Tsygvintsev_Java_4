package tsygvintsev;

import java.util.List;

public class ListReduction {
    public static <T> T reduce(List<T> list, Reduction<T> reducer, T identity) {
        if (list == null || list.isEmpty()) {
            return identity;
        }

        T result = identity;
        for (T value : list) {
            result = reducer.reduction(result, value);
        }

        return result;
    }
}
