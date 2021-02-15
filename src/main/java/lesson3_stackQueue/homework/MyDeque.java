package lesson3_stackQueue.homework;

public class MyDeque<E> {
    private final E[] deque;
    private int size;
    private final int sizeArray;
    private int front; // удаляем эл-нт
    private int rear; // добавляем эл-нт

    @SuppressWarnings("unchecked")
    public MyDeque(int size) {
        this.sizeArray = size;
        this.deque = (E[]) new Object[sizeArray];
        this.front = 0;
        this.rear = -1;
    }

    public E insetLeft(E value) {
        if (isFull()) return null;
        if (rear == deque.length - 1) rear = -1;

        deque[++rear] = value;
        size++;
        return value;
    }

    public E insertRight(E value) {
        if (isFull()) return null;
        deque[front++] = value;
        size++;
        return value;
    }

    public E removeRight() {
        if (isEmpty()) return null;
        if (front == deque.length) front = 0;

        E removedValue = deque[front];
        deque[front++] = null;
        size--;
        return removedValue;
    }

    public E removeLeft() {
        if (isEmpty()) return null;
        return deque[--size];
    }

    public E peek() {
        return deque[front];
    }

    public int size() {
        return sizeArray;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == deque.length;
    }
}