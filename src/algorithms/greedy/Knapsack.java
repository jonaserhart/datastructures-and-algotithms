package algorithms.greedy;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {
    private int availableCapacity;
    private final List<Item> itemsPacked = new ArrayList<>();

    public Knapsack(int capacity) {
        this.availableCapacity = capacity;
    }

    public int getAvailableCapacity() {
        return availableCapacity;
    }

    /**
     * adds an item to the knapsack inventory
     * @param item item to add
     * @return true, if capacity is sufficient, otherwise false
     */
    public boolean addItem(Item item){
        if (item.getWeight() > availableCapacity)
            return false;

        itemsPacked.add(item);
        availableCapacity -= item.getWeight();
        return true;
    }

    private String itemsToString(){
        var sBuilder = new StringBuilder();
        sBuilder.append("[").append("\n");
        for (var item: itemsPacked){
            sBuilder.append("\t").append(item).append("\n");
        }
        sBuilder.append("\n").append("]");
        return sBuilder.toString();
    }

    public void printValue(){
        var result = 0;
        for(var item: itemsPacked){
            result += item.getValue();
        }
        System.out.println("Value in knapsack is: " + result);
    }

    @Override
    public String toString() {
        return "Knapsack{" +
                "availableCapycity=" + availableCapacity + "\n" +
                itemsToString() + "\n" +
                '}';
    }
}
