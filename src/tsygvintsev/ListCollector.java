package tsygvintsev;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class ListCollector {
    public static <T, P> P collect(List<T> list, Creator<P> creator, Adder<P, T> adder) {
        P result = creator.get();
        for (T item : list) {
            adder.add(result, item);
        }
        return result;
    }
}
