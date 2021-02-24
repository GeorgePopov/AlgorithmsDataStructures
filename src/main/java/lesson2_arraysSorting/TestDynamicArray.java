package lesson2_arraysSorting;

import lesson5_recursion.RecursionSortedArrayImpl;

public class TestDynamicArray {

    public static void main(String[] args) {

//        Array<Integer> data = new ArrayImpl<>(4);
//        Array<Integer> data = new SortedArrayImpl<>();

        Array<Integer> data = new RecursionSortedArrayImpl<>();

        data.add(5);
        data.add(4);
        data.add(3);
        data.add(2);
        data.add(1);
        data.add(2);

        data.display();

        data.remove(Integer.valueOf(3)); // т.к. используется Integer, необходимо передавать его явно. ! явная передача Integer
        data.remove(2);
        data.display();
//
        System.out.println("data[1] = " + data.get(1));
        System.out.println("Find 2: " + data.contains(2));
        System.out.println("Find 222: " + data.contains(222));
    }
}