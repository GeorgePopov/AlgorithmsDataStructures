package lesson3_stackQueue;

import lesson3_stackQueue.queue.IQueue;
import lesson3_stackQueue.queue.PriorityQueueImpl;
import lesson3_stackQueue.queue.QueueImpl;
import lesson3_stackQueue.stack.IStack;
import lesson3_stackQueue.stack.StackImpl;

public class TestThree {
    public static void main(String[] args) {
//        testStack();
        testQueue();
    }

    private static void testStack() {
        IStack<Integer> stack = new StackImpl<>(5);

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

    private static void testQueue() {
//        IQueue<Integer> queue = new QueueImpl<>(5);
        IQueue<Integer> queue = new PriorityQueueImpl<>(5);

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
}