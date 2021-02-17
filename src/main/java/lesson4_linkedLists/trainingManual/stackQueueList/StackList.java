package lesson4_linkedLists.trainingManual.stackQueueList;

import lesson4_linkedLists.trainingManual.TwoSideLinkedListEx;

// в данном примере стек и очередь одинаковы, надо разбираться
public class StackList {
    private TwoSideLinkedListEx list;

    public StackList() {
        list = new TwoSideLinkedListEx();
    }

    public void push(String name, int age){
        list.insert(name, age);
    }

    public String pop(){
        return list.delete();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void display(){
        list.display();
    }
}

class LinkStackApp {
    public static void main(String[] args) {
        StackList sl = new StackList();
        sl.push("Artem", 30);
        sl.push("Viktor", 20);
        sl.push("Sergey", 10);
        sl.display();
        while (!sl.isEmpty()) {
            System.out.println("Item " + sl.pop() + " remove from stack");
        }
    }
}
