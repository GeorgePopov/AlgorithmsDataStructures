package lesson4_linkedLists;

public interface ToSideLinkedList<E> extends LinkedList<E> { // нам доступны все методы LinkedList

    void insertLast(E value);
}