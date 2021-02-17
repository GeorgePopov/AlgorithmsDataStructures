package lesson4_linkedLists;

import lesson3_stackQueue.queue.IQueue;

public class LinkedQueueImpl<E> implements IQueue<E> {

    private final ToSideLinkedList<E> data;

    public LinkedQueueImpl() {
        this.data = new TwoSideLinkedListImpl<>();
    }

    @Override
    public boolean inset(E value) { // т.к. удаление только сначала, то вставку делаем с конца (очередь)
        data.insertLast(value);
        return true;
    }

    @Override
    public E remove() {
        return data.removeFirst();
    }

    @Override
    public E peekHead() {
        return data.getFirst();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }
}