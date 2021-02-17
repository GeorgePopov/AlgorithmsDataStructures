package lesson4_linkedLists;

import lesson3_stackQueue.stack.IStack;

public class LinkedStackImpl<E> implements IStack<E> {

    private final LinkedList<E> data;

    public LinkedStackImpl() {
        this.data = new SimpleLinkedListImpl<>(); // за основу стека используем простой связанный список
    }

    @Override
    public void push(E value) {
        data.insertFirst(value);
    }

    @Override
    public E pop() {
        return data.removeFirst();
    }

    @Override
    public E peek() {
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

    @Override // не используем
    public boolean isFull() {
        return false;
    }

    @Override
    public void display() {
        data.display();
    }
}