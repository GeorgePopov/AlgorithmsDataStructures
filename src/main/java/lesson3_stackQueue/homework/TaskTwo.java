package lesson3_stackQueue.homework;

/**
 * Создать программу, которая переворачивает вводимые строки (читает справа налево).
 */
public class TaskTwo {

    public static void main(String[] args) {
        String text = "Car Mercedes-Benz";

        MyStack<Character> myStack = new MyStack<>(text.length());
        reversText(text, myStack);
    }

    public static void reversText(String str, MyStack<Character> stack) {
        if (!stack.isFull()) {
            for (int i = 0; i < stack.size(); i++) {
                char item = str.charAt(i);
                stack.push(item);
            }
        }

        if (!stack.isEmpty()) {
            for (int i = 0; i < stack.size(); i++) {
                System.out.print(stack.pop());
            }
        }
    }
}