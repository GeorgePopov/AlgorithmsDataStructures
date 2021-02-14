package lesson3_stackQueue.trainingManual;

public class PriorityQueue {
    private int maxSize;
    private int[] queueArray;
    private int items;

    public PriorityQueue(int i) {
        maxSize = i;
        queueArray = new int[maxSize];
        items = 0;
    }

    public void insert(int item) {
        int i;
        if (items == 0)
            queueArray[items++] = item;
        else {
            for (i = items - 1; i > 0; i--) {
                if (item > queueArray[i])
                    queueArray[i + 1] = queueArray[i];
                else
                    break;
            }
            queueArray[i + 1] = item; // вставка эл-та
            items++;
        }
    }

    public int remove() {
        return queueArray[--items];
    }

    public long peek() {
        return queueArray[items - 1];
    }

    public boolean isEmpty() {
        return items == 0;
    }

    public boolean isFull() {
        return (items == maxSize);
    }
}

class PriorityApp {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(5);
        pq.insert(30);
        pq.insert(50);
        pq.insert(10);
        pq.insert(40);
        pq.insert(20);
        while (!pq.isEmpty()) {
            int item = pq.remove();
            System.out.println(item + " ");
        }
        System.out.println(" ");
    }
}
