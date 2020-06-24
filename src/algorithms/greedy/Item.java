package algorithms.greedy;

public class Item implements Comparable<Item> {
    private final int value;
    private final double weight;

    public Item(int value, double weight) {
        this.value = value;
        this.weight = weight;
    }

    /**
     * Calculates the value/weight ratio for comparing two items
     * @return value/weight ratio of the item
     */
    public double getValueWeightRatio(){
        return ((double)value)/weight;
    }

    public int getValue() {
        return value;
    }

    public double getWeight() {
        return weight;
    }

    /**
     * Compares two items
     * @param that item to compare this one to
     * @return
     *          -1, if this item has a higher value/weight ratio,
     *          1 if that item has a higher ratio,
     *          0 if equal
     */
    @Override
    public int compareTo(Item that) {
        if (this.getValueWeightRatio() < that.getValueWeightRatio())
            return 1;
        if (this.getValueWeightRatio() > that.getValueWeightRatio())
            return -1;
        return 0;
    }

    @Override
    public String toString() {
        return "Item{" +
                "value=" + value +
                ", weight=" + weight +
                ", v/w-ratio=" + getValueWeightRatio() +
                '}';
    }
}
