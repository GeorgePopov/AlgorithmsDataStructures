package lesson3_stackQueue.queue;

public interface IQueue<E> {

    boolean inset(E value);

    E remove();

    E peekHead();

    int size();

    boolean isEmpty();

    boolean isFull();
}