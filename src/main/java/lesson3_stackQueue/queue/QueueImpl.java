package lesson3_stackQueue.queue;

/*
в данном примере все проверки на заполнение и т.д. будут внутри
класс который реализует данный пример в JDK это ArrayDeque
 */
public class QueueImpl<E> implements IQueue<E> { // Iинтерфейс, так можно обозначать интерфейсы

    private static final int DEFAULT_HEAD = 0;
    private static final int DEFAULT_TAIL = -1;

    protected final E[] data;
    protected int size;

    private int tail;
    private int head;

    @SuppressWarnings("unchecked")
    public QueueImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        this.head = DEFAULT_HEAD;
        this.tail = DEFAULT_TAIL;
    }

    @Override
    public boolean inset(E value) {
        if (isFull()) {
            return false;
        }

        if (tail == data.length - 1) {
            tail = DEFAULT_TAIL;
        }

        data[++tail] = value;
        size++;
        return true;
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            return null;
        }

        if (head == data.length) {
            head = DEFAULT_HEAD;
        }

        E removedValue = data[head];
        /*
        делаем обнуление, если мы не дойдём до этой ячейки, сборщик мусора удалит значение
        которое было привязано к данной ячейке, это необязательное действие, помощь GC (garbage collector)
         */
        data[head++] = null;
        size--;
        return removedValue;
    }

    @Override
    public E peekHead() {
        return data[head];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }
}