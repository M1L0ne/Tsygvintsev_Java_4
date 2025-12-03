package tsygvintsev;

import java.util.ArrayList;
import java.util.List;

public class MaximumSearch {
    private List<Box<?>> boxes = new ArrayList<>();

    public double findMaximum() {
        if (boxes.isEmpty()) {
            throw new RuntimeException("Кробок нет");
        }

        double max = Double.NEGATIVE_INFINITY;

        for (Box<?> box : boxes) {
            Object object = box.getValue();
            if (object instanceof Number) {
                double value = ((Number) object).doubleValue();
                if (value > max) {
                    max = value;
                }
            }
        }

        return max;
    }

    public void addBox (Box<?> box) {
        boxes.add(box);
    }
}
