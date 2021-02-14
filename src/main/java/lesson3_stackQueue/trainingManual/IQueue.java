package lesson3_stackQueue.trainingManual;

public class IQueue {
    private int maxSize;
    private int[] queue;
    private int front; // маркер начала
    private int rear;  // маркер конца
    private int items; // колличество эл-тов

    public IQueue(int s) {
        maxSize = s;
        queue = new int[maxSize];
        front = 0;
        rear = -1;
        items = 0;
    }

    public boolean isEmpty() {
        return (items == 0);
    }

    public int remove() {
        int temp = queue[front++];
        if (front == maxSize)
            front = 0;
        items--;
        return temp;
    }

    public int peek() {
        return queue[front];
    }

    public boolean isFull() {
        return (items == maxSize);
    }

    public int size() {
        return items;
    }

    public void insert(int i) {
        if (rear == maxSize - 1)
            rear = -1;
            queue[++rear] = i;
            items++;
    }
}

class MainClass {
    public static void main(String[] args) {
        IQueue queue = new IQueue(5);
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);
        queue.insert(50);
        queue.remove();
        queue.remove();

        queue.insert(50);
        queue.insert(60);
        queue.insert(70);
        queue.insert(80);

        while (!queue.isEmpty()) {
            int n = queue.remove();
            System.out.println(n);
        }
    }
}














