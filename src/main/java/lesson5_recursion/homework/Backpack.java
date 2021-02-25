package lesson5_recursion.homework;

import java.util.List;

public class Backpack<E> {

    private final int maxWeight = 7;
    private E[] arr;

    @SuppressWarnings("unchecked")
    public Backpack(List<E> list) {
        arr = (E[]) new Object[list.size()];
    }

    public int getCapacity() {
        return maxWeight;
    }

    public void addInBackpack(List<E> list) {
        for (E e : list) {

        }
    }
}