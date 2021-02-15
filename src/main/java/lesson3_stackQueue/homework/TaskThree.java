package lesson3_stackQueue.homework;

/**
 * Создать класс для реализации дека.
 */
public class TaskThree {
    public static void main(String[] args) {
//        queueExample();

        MyDeque<Integer> myDeque = new MyDeque<>(5);
//        inLeftReRight(myDeque);
//        inLeftReLeft(myDeque);
//        inRightReRight(myDeque);
        inRightReLeft(myDeque);
    }

    private static void inRightReLeft(MyDeque<Integer> myDeque) {
        System.out.println("queue equivalent");
        for (int i = 1; i <= myDeque.size(); i++) {
            int n = myDeque.insertRight(i);
            System.out.println("Добавлено число " + n + " ");
        }

        System.out.println();
        while (!myDeque.isEmpty()) {
            System.out.println("Удалино число " + myDeque.removeLeft() + " ");
        }
    }

    private static void inRightReRight(MyDeque<Integer> myDeque) {
        System.out.println("stack equivalent");
        for (int i = 1; i <= myDeque.size(); i++) {
            int n = myDeque.insertRight(i);
            System.out.println("Добавлено число " + n + " ");
        }

        System.out.println();
        while (!myDeque.isEmpty()) {
            System.out.println("Удалино число " + myDeque.removeRight() + " ");
        }
    }

    private static void inLeftReLeft(MyDeque<Integer> myDeque) {
        System.out.println("queue");
        for (int i = 1; i <= myDeque.size(); i++) {
            int n = myDeque.insetLeft(i);
            System.out.println("Добавлено число " + n + " ");
        }

        System.out.println();
        while (!myDeque.isEmpty()) {
            System.out.println("Удалино число " + myDeque.removeRight() + " ");
        }
    }

    private static void inLeftReRight(MyDeque<Integer> myDeque) {
        System.out.println("stack");
        for (int i = 1; i <= myDeque.size(); i++) {
            int n = myDeque.insetLeft(i);
            System.out.println("Добавлено число " + n + " ");
        }

        System.out.println();
        while (!myDeque.isEmpty()) {
            System.out.println("Удалино число " + myDeque.removeLeft() + " ");
        }
    }

    private static void queueExample() {
        MyQueue<Integer> myQueue = new MyQueue<>(5);

        for (int i = 1; i <= myQueue.size(); i++) {
            int n = myQueue.inset(i);
            System.out.print(n + " ");
        }

        System.out.println();
        while (!myQueue.isEmpty()) {
            System.out.print(myQueue.remove() + " ");
        }
    }
}