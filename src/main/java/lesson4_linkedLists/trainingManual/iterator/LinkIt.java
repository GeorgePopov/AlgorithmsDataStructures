package lesson4_linkedLists.trainingManual.iterator;

// работает немного некорректно
public class LinkIt {
    public String name;
    public int age;

    public LinkIt next;

    public LinkIt(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void display(){
        System.out.println("Name: " +this.name+ ", age: " +this.age);
    }
}

class LinkedListIt {
    private LinkIt first;

    public LinkedListIt() {
        first = null;
    }

    public LinkIt getFirst() {
        return first;
    }

    public void setFirst(LinkIt first) {
        this.first = first;
    }

    public LinkIterator getIterator(){
        return new LinkIterator(this);
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public void display(){
        LinkIt current = first;
        while(current != null){
            current.display();
            current = current.next;
        }
    }
}

class LinkIterator {
    private LinkIt current;
    private LinkIt previous;
    private LinkedListIt list;

    public LinkIterator(LinkedListIt list) {
        this.list = list;
        this.reset();
    }

    public void reset() {
        current = list.getFirst();
        previous = null;
    }

    public boolean atEnd() {
        return (current.next == null);
    }

    public void nextLink() {
        previous = current;
        current = current.next;
    }

    public LinkIt getCurrent() {
        return current;
    }

    public void insertAfter(String name, int age) {
        LinkIt newLink = new LinkIt(name, age);
        if (list.isEmpty()) {
            list.setFirst(newLink);
            current = newLink;
        } else {
            newLink.next = current;
            current.next = newLink;
            nextLink();
        }
    }

    public void insertBefore(String name, int age) {
        LinkIt newLink = new LinkIt(name, age);
        if (previous == null) {
            list.setFirst(newLink);
            reset();
        } else {
            newLink.next = previous.next;
            previous.next = newLink;
            current = newLink;
        }
    }

    public String deleteCurrent() {
        String name = current.name;
        if (previous == null) {
            list.setFirst(current.next);
            reset();
        } else {
            previous.next = current.next;
            if (atEnd()) {
                reset();
            } else {
                current = current.next;
            }
        }

        return name;
    }
}

class LinkedIteratorApp {
    public static void main(String[] args) {
        LinkedListIt list = new LinkedListIt();

        LinkIterator itr = new LinkIterator(list);

        itr.insertAfter("Sam", 20);
        itr.insertBefore("George", 25);

        list.display();
    }
}