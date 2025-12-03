package tsygvintsev;

public class Box<Item> {
    private Item value;

    public Box () {
        this.value = null;
    }

    public void setValue(Item value) {
        if (this.value != null) {
            throw new RuntimeException("Коробка не пуста");
        }
        this.value = value;
    }

    public Item getValue() {
        Item returnValue = this.value;
        this.value = null;
        return returnValue;
    }

    public boolean isFilled() {
        return this.value != null;
    }
}
