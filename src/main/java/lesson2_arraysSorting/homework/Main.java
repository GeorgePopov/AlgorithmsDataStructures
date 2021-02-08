package lesson2_arraysSorting.homework;

public class Main {

    public static void main(String[] args) {
        int size = 100000;
        sortBubbleExample(size);
//        sortSelectExample(size);
//        sortInsertExample(size);
    }

    private static void sortBubbleExample(int size) {
        MyArr arr1 = new MyArr(size);

        long l = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr1.insert((int) (Math.random() * size) + 1);
        }
        arr1.sortBubble();
        System.out.println(System.currentTimeMillis() - l);
    }

    private static void sortSelectExample(int size) {
        MyArr arr3 = new MyArr(size);

        long l = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr3.insert((int) (Math.random() * size) + 1);
        }
        arr3.sortSelect();
        System.out.println(System.currentTimeMillis() - l);
    }

    private static void sortInsertExample(int size) {
        MyArr arr2 = new MyArr(size);

        long l = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr2.insert((int) (Math.random() * size) + 1);
        }
        arr2.sortInsert();
        System.out.println(System.currentTimeMillis() - l);
    }
}