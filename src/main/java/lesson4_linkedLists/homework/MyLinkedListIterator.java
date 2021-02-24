package lesson4_linkedLists.homework;

import java.util.Iterator;

public class MyLinkedListIterator<E> implements Iterator<E> {

    LinkedListMyEx.Node<E> current;

    public MyLinkedListIterator(MyLinkedList<E> myLinkedList) {
        current = myLinkedList.firstElement;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public E next() {
        E data = current.item;
        current = current.next;
        return data;
    }
}