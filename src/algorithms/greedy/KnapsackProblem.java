package algorithms.greedy;

import java.util.List;
import java.util.PriorityQueue;

public class KnapsackProblem {

    public static void fractionalKnapsack(int knapsackCapaticy, List<Item> items){
        var knapSack = new Knapsack(knapsackCapaticy);
        var pqueue = new PriorityQueue<Item>();

        //O(n* log(n)
        for (var item : items){
            //O(log n)
            pqueue.add(item);
        }

        //O(n)
        while (!pqueue.isEmpty()){
            var item = pqueue.poll();

            if (!knapSack.addItem(item)){
                var capacity = knapSack.getAvailableCapacity();
                var fraction = capacity / item.getWeight();

                System.out.println("adding " + fraction + " parts of item " + item + " to knapsack");

                if (fraction == 0)
                    break;

                var newItem = new Item(item.getValue(), capacity);
                knapSack.addItem(newItem);
                break;
            }
            System.out.println("Added whole item " + item + " to knapsack");
            System.out.println("remaining capacity: " + knapSack.getAvailableCapacity());
        }
        System.out.println(knapSack);
        knapSack.printValue();
    }
}
