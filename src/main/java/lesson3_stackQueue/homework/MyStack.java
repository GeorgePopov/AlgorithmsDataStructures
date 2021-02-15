package lesson3_stackQueue.homework;

public class MyStack<E> {
    private final E[] stack;
    private int size;
    private final int sizeArray;

    @SuppressWarnings("unchecked")
    public MyStack(int size) {
        this.sizeArray = size;
        this.stack = (E[]) new Object[sizeArray];
    }

    public void push(E value) {
        stack[size++] = value;
    }

    public E pop() {
        return stack[--size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == stack.length;
    }

    public E peek() {
        return stack[size - 1];
    }

    public int size() {
        return sizeArray;
    }
}