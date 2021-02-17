package lesson4_linkedLists;

import lesson3_stackQueue.queue.IQueue;
import lesson3_stackQueue.stack.IStack;

import java.util.ArrayList;
import java.util.Iterator;

public class TestMainFour {
    public static void main(String[] args) {
//        testLinkedList();
//        testLinkedListToSide();
//        testLinkedStack();
//        testLinkedQueue();

        testIterator();
    }

    private static void testIterator() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        for (Integer o : arrayList) {
            System.out.println(o);
        }

        System.out.println("-----");
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            System.out.println(value);
        }
    }

    private static void testLinkedQueue() {
        IQueue<Integer> queue = new LinkedQueueImpl<>();

        System.out.println(queue.inset(3));
        System.out.println(queue.inset(5));
        System.out.println(queue.inset(1));
        System.out.println(queue.inset(2));
        System.out.println(queue.inset(6));
        System.out.println(queue.inset(4));

        System.out.println("Queue peek: " + queue.peekHead()); // первый эл-нт удалиться '3'
        System.out.println("Queue size: " + queue.size());
        System.out.println("Queue is full: " + queue.isFull());

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }

    private static void testLinkedStack() {
        IStack<Integer> stack = new LinkedStackImpl<>();

        System.out.println("Add value 1: " + addToStack(stack, 1));
        System.out.println("Add value 2: " + addToStack(stack, 2));
        System.out.println("Add value 3: " + addToStack(stack, 3));
        System.out.println("Add value 4: " + addToStack(stack, 4));
        System.out.println("Add value 5: " + addToStack(stack, 5));
        System.out.println("Add value 6: " + addToStack(stack, 6)); // 6 эл-нт не добаавиться

        System.out.println("Stack size: " + stack.size());
        System.out.println("Stack top: " + stack.peek());
        stack.display();

        while (!stack.isEmpty()) { // в данном примере все проверки снаружи
            System.out.println(stack.pop()); // просмотр стека обычно происходит с его отчисткой, удалиться первая '5'
        }
    }

    private static boolean addToStack(IStack<Integer> stack, int value) {
        if (!stack.isFull()) {
            stack.push(value);
            return true;
        }
        return false;
    }

    private static void testLinkedListToSide() {
        ToSideLinkedList<Integer> toSideLinkedList = new TwoSideLinkedListImpl<>();

        toSideLinkedList.insertFirst(1);
        toSideLinkedList.insertFirst(2);
        toSideLinkedList.insertFirst(3);
        toSideLinkedList.insertFirst(4);
        toSideLinkedList.insertLast(5);

        toSideLinkedList.display();

        System.out.println("Find 2: " + toSideLinkedList.contains(2));
        System.out.println("Find 1: " + toSideLinkedList.contains(1));
        System.out.println("Find 4: " + toSideLinkedList.contains(4));
        System.out.println("Find 5: " + toSideLinkedList.contains(5));
        System.out.println("Find 444: " + toSideLinkedList.contains(444));

        toSideLinkedList.removeFirst();
        toSideLinkedList.remove(2);

        toSideLinkedList.display();
    }

    private static void testLinkedList() {
        LinkedList<Integer> linkedList = new SimpleLinkedListImpl<>();

        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);

        linkedList.display();

        System.out.println("Find 2: " + linkedList.contains(2));
        System.out.println("Find 1: " + linkedList.contains(1));
        System.out.println("Find 4: " + linkedList.contains(4));
        System.out.println("Find 444: " + linkedList.contains(444));

        linkedList.removeFirst();
        linkedList.remove(2);

        linkedList.display();
    }
}