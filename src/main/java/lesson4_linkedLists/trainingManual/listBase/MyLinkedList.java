package lesson4_linkedLists.trainingManual.listBase;

public class MyLinkedList {
    private MyLink first;

    public MyLinkedList(MyLink first) {
        this.first = first;
    }
    public boolean isEmpty() {
        return (first == null);
    }

    public void insert(String name, int age) {
        MyLink newLink = new MyLink(name, age);
        newLink.next = first;
        first = newLink;
    }

    public MyLink delete() {
        MyLink temp = first;
        first = first.next;
        return temp;
    }

    public void display() {
        MyLink current = first;
        while (current != null) {
            current.display();
            current = current.next;
        }
    }
}