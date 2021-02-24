package lesson5_recursion;

import lesson2_arraysSorting.ArrayImpl;
/*
 пример с двоичной рекурсией класса SortedArrayImpl из 2 урока
 тестируем данный пример в классе TestDynamicArray из 2-го урока
 */
public class RecursionSortedArrayImpl<E extends Comparable<? super E>> extends ArrayImpl<E> {

    public RecursionSortedArrayImpl() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public RecursionSortedArrayImpl(int initialCapacity) {
        this.data = (E[]) new Comparable[initialCapacity];
    }

    @Override
    public int indexOF(E value) {
        return recBinaryFind(value, 0, size - 1);
    }

    private int recBinaryFind(E value, int low, int high) {
        if (low > high) { // если мы не нашли эл-нт
            return -1;
        }

        int mid = (low + high) / 2;
        if (data[mid].equals(value)) { // дата среднего значения эквивалента тому среднему значению, которые мы ищем
            return mid;
        }

        if (value.compareTo(data[mid]) > 0) { // если искомый эл-нт больше того что мы ищем
            // вызываем рекурсию передавая туда изменённое состояние нижней границы, а верхнее оставляем неизменное
            return recBinaryFind(value, mid + 1, high);
        } else {
            return recBinaryFind(value, low, mid - 1);
        }
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