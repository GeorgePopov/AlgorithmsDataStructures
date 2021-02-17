package lesson4_linkedLists.trainingManual.stackQueueList;

import lesson4_linkedLists.trainingManual.TwoSideLinkedListEx;

// в данном примере стек и очередь одинаковы, надо разбираться
public class QueueStack {
    private TwoSideLinkedListEx queue;

    public QueueStack() {
        queue = new TwoSideLinkedListEx();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public void insert(String name, int age){
        queue.insert(name, age);
    }

    public String delete(){
        return queue.delete();
    }

    public void display(){
        queue.display();
    }
}

class LinkQueueApp {
    public static void main(String[] args) {
        QueueStack q = new QueueStack();
        q.insert("Artem", 30);
        q.insert("Viktor", 20);
        q.insert("Sergey", 10);
        q.display();
        while (!q.isEmpty()) {
            System.out.println("Item " + q.delete() + " remove from stack");
        }
    }
}