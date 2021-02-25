package lesson5_recursion.homework;

import java.util.ArrayList;
import java.util.List;

public class Backpack {

    private final int maxWeight = 7;
    private List<Things> backpack = new ArrayList<>();;
    private int bestPrice;

    public int getCapacity() {
        return maxWeight;
    }

    public void addInBackpack(List<Things> list) {
        int count = list.size();
        Things item = list.get(count - 1);
        bestPrice = item.getPrice();
        while (count != 0)
        for (Things thing : list) {
            if (!item.getName().equals(thing.getName())) {
                if (item.getWeight() + thing.getWeight() <= maxWeight) {
                    backpack.add(thing);
                    bestPrice += thing.getPrice();
                    count--;
                }
            }
        }
    }
}