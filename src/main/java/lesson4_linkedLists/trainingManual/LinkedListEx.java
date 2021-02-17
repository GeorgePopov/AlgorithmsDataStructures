package lesson4_linkedLists.trainingManual;

public class LinkedListEx <T> {
    private Link<T> first;

    public LinkedListEx(){
        first = null;
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public void insert(T link){
        Link<T> l = new Link<>(link);
        l.setNext(first);
        this.first = l;
    }

    public Link<T> delete(){
        Link<T> temp = first;
        first = first.getNext();
        return temp;
    }

    public void display() {
        Link<T> current = first;
        while (current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }

    public T find(T searchNode) {
        Link<T> findNode = new Link<>(searchNode);
        Link<T> current = first;
        while (current != null) {
            if (current.getValue().equals(findNode.getValue())) {
                return findNode.getValue();
            }
            current = current.getNext();
        }

        return null;
    }

//    public Link find(String name){ // поиск по заданному параметру
//        Link current = first;
//        while(current.name != name){
//            if(current.next == null)
//                return null;
//            else
//                current = current.next;
//        }
//        return current;
//    }

//    public Link delete(String name){ // удаление по заданному параметру
//        Link current = first;
//        Link previous = first;
//        while(current.name != name){
//            if(current.next == null)
//                return null;
//            else{
//                previous = current;
//                current = current.next;
//            }
//        }
//        if(current == first)
//            first = ((Link<T>) first).next;
//        else
//            previous.next = current.next;
//        return current;
//    }
}