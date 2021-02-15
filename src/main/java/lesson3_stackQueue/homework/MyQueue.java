package lesson3_stackQueue.homework;

public class MyQueue<E> {
    private final E[] queue;
    private int size; // храниться текущее кол-во эл-тов
    private final int sizeArray;
    private int front;
    private int rear;

    @SuppressWarnings("unchecked")
    public MyQueue(int size) {
        this.sizeArray = size;
        this.queue = (E[]) new Object[sizeArray];
        this.front = 0;
        this.rear = -1;
    }

    public E inset(E value) {
        if (isFull()) return null;
        if (rear == queue.length - 1) rear = -1;

        queue[++rear] = value;
        size++;
        return value;
    }

    public E remove() {
        if (isEmpty()) return null;
        if (front == queue.length) front = 0;

        E removedValue = queue[front];
        queue[front++] = null;
        size--;
        return removedValue;
    }

    public E peek() {
        return queue[front];
    }

    public int size() {
        return sizeArray;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }
}