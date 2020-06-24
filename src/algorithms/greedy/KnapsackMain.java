package algorithms.greedy;

import java.util.ArrayList;

public class KnapsackMain {

    public static void main(String[] args) {

        var n = 5;
        var items = new ArrayList<Item>(n);
        items.add(new Item(4, 12));
        items.add(new Item(2,1));
        items.add(new Item(2,2));
        items.add(new Item(1,1));
        items.add(new Item(10,4));
        var w = 15;

        //O(n*log(n))
        KnapsackProblem.fractionalKnapsack(w, items);
    }
}
