package lesson4_linkedLists.trainingManual;

import lesson4_linkedLists.trainingManual.listBase.LinkForTwoSide;

public class TwoSideLinkedListEx {
    public LinkForTwoSide first;
    public LinkForTwoSide last;

    public TwoSideLinkedListEx(){
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public void insert(String name, int age) {
        LinkForTwoSide newLink = new LinkForTwoSide(name, age);
        if (this.isEmpty()) {
            last = newLink;
        }
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(String name, int age) {
        LinkForTwoSide newLink = new LinkForTwoSide(name, age);
        if (this.isEmpty()) {
            last = newLink;
        } else {
            last.next = newLink;
        }
        last = newLink;
    }

    public String delete() {
        LinkForTwoSide temp = first;
        if (first.next == null) {
            last = null;
        }
        first = first.next;
        return temp.name;
    }

    public void display() {
        LinkForTwoSide current = first;
        while(current != null){
            current.display();
            current = current.next;
        }
    }

    public LinkForTwoSide find(String name){
        LinkForTwoSide current = first;
        while(!current.name.equals(name)){
            if(current.next == null)
                return null;
            else
                current = current.next;
        }
        return current;
    }

    public LinkForTwoSide delete(String name){
        LinkForTwoSide current = first;
        LinkForTwoSide previous = first;
        while(!current.name.equals(name)){
            if(current.next == null)
                return null;
            else{
                previous = current;
                current = current.next;
            }
        }
        if(current == first)
            first = first.next;
        else
            previous.next = current.next;
        return current;
    }
}

class TwoSideApp {
    public static void main(String[] args) {
        TwoSideLinkedListEx list = new TwoSideLinkedListEx();

        list.insert("Sam", 30);
        list.insert("Ben", 27);
        list.insert("Bob", 28);
        list.insertLast("George", 25);

        list.display();
        System.out.println("remove items from the list");
        list.delete("George");
        list.delete();
        list.display();



    }
}




















