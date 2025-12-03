package tsygvintsev;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class InteractiveTransformer {
    public static List<Integer> stringLen(List<String> list) {
        List<Integer> newList;

        newList = TypeTransformer.changeTypes(list, new Function<String, Integer>() {
            @Override
            public Integer apply(String value) {
                return value.length();
            }
        });

        return newList;
    }

    public static List<Integer> deleteNegative(List<Integer> list) {
        List<Integer> newList;

        newList = TypeTransformer.changeTypes(list, new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer value) {
                return Math.abs(value);
            }
        });

        return newList;
    }

    public static List<Integer> maximumFromArrays(List<Integer[]> list) {
        return null;
    }
}
