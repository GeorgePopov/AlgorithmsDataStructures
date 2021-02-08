package lesson2_arraysSorting;

/*
 !*!*! Интерфейс Comparable сипользуется в наших классах для возможности сравнения на предмет >, < или ==
 В интерфейсе Comparable, есть метод compareTo(), он возвращает числовое значение объекта, в каждом
 классе мы можем реализовывать данный интерфейс по своему. Integer реализуем данный интерфейс
 см. 1:50мин
 */
public class SortedArrayImpl<E extends Comparable<? super E>> extends ArrayImpl<E> { // ??

    public SortedArrayImpl() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public SortedArrayImpl(int initialCapacity) {
        this.data = (E[]) new Comparable[initialCapacity];
    }

    @Override
    public int indexOF(E value) {
        int low = 0;
        int high = size - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (data[mid].equals(value)) {
                return mid;
            } else if (value.compareTo(data[mid]) > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    @Override
    public void add(E value) {
        checkAndGrow();

        int index = size;
        for (int i = 0; i < size; i++) {
            if (data[i].compareTo(value) > 0) {
                index = i;
                break;
            }
        }

        if (index == size) {
            data[size++] = value;
        } else {
            doInsert(value, index);
        }
    }

    private void doInsert(E value, int index) {
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = value;
        size++;
    }
}