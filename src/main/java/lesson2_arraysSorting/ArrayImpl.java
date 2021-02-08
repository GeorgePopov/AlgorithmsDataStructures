package lesson2_arraysSorting;

import java.util.Arrays;
/*
 Array List эфективен:
 * когда нужно найти эл-нт с известным индексом.
 * добавить эл-ты
 не эфективен:
 * удаление эл-тов
 * поиск эл-тов, т.к. у него линейный поиск
 */
public class ArrayImpl<E extends Comparable<? super E>> implements Array<E> {

    protected static final int DEFAULT_CAPACITY = 8;

    protected E[] data; // класс основывается на обычном массиве
    protected int size; // данную переменную ++ если добавляем новый элемент и -- если удаляем элемент

    /*
    @SuppressWarnings("unchecked") // что бы java не ругался
    public ArrayImpl() { // создание массива с дефолтным колличеством эл-тов
        this.data = (E[]) new Object[DEFAULT_CAPACITY]; // ! в java нельзя создавать массивы обобщённого типа
//        this.size = 0; // ! int по умолчанию равняется 0
    }
    */
    public ArrayImpl() { // через this() вызываем нижний конструктор, верхняя реализвация ненужна
        this(DEFAULT_CAPACITY); // !*!*!
    }

//    @SuppressWarnings("unchecked") // для примера без 'сортировок'
//    public ArrayImpl(int initialCapacity) { // создание массива с заранее известным колличеством эл-тов
//        this.data = (E[]) new Object[initialCapacity];
//    }

    @SuppressWarnings("unchecked")
    public ArrayImpl(int initialCapacity) { // создание массива с заранее известным колличеством эл-тов
        this.data = (E[]) new Comparable[initialCapacity];
    }

    @Override
    public void add(E value) {
        checkAndGrow();
        data[size++] = value; // совмещаем две опреации
//        size++;
    }

    protected void checkAndGrow() {
        if (data.length == size) {
            data = Arrays.copyOf(data, calculateNewLength());
        }
    }

    private int calculateNewLength() {
        return size == 0 ? 1 : size * 2;
    }

    @Override
    public E get(int index) { // взятие определённого индекса
        checkIndex(index);
        return data[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            String errMsg = String.format("Incorrect 'index' value: %d; max value is %d", index, size - 1);
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean remove(E value) {
        return remove(indexOF(value)) != null;
    }

    @Override
    public E remove(int index) { // логика по удалению эл-та
        checkIndex(index); // проверяем значение индекса

        E removedValue = data[index]; // запоминаем значение удаляемого элемента
        if ((size - index - 1) >= 0) { // если не удаляем единственный элемент
            System.arraycopy(data, index + 1, data, index, size - index - 1); // смещаем эл-ты в право на 1 позицию
        }

        data[--size] = null; // clear to let GC (Garbage Collection Вывоз мусора) do its work // обнуление
        return removedValue;
    }

    @Override
    public boolean contains(E value) { // алгоритм линейного поиска
        /*
        for (int i = 0; i < size; i++) {
            if (value.equals(data[i])) {
                return true;
            }
        }
        return false;
        */

        return indexOF(value) != -1;
    }

    @Override
    public int indexOF(E value) { // поиск индекса (отвечает за поиск)
        for (int i = 0; i < size; i++) {
            if (value.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() { // get-тер для size
        return size;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() { // !*!*! отличный пример использования StringBuilder
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(data[i]);
            sb.append(", ");
        }
        if (size > 0) {
            sb.append(data[size - 1]);
        }
        sb.append("]");
        return sb.toString();
    }

    // данная сортировка не эфективеная
    @Override
    public void sortBubble() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) { // если текущий эл-нт больше, то меняем их местами методом swap
                    swap(j, j + 1);
                }
            }
        }
    }

    // !*!*! важный алгоритм перестановки элемментов
    private void swap(int indexA, int indexB) {
        E temp = data[indexA]; // третья вспомогательная переменная
        data[indexA] = data[indexB];
        data[indexB] = temp;
    }

    @Override
    public void sortSelect() {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (data[j].compareTo(data[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(minIndex, i);
        }
    }

    @Override
    public void sortInsert() {
        for (int i = 0; i < size; i++) {
            E temp = data[i];
            int in = i;
            while (in > 0 && data[in - 1].compareTo(temp) >= 0) {
                data[in] = data[in - 1];
                in--;
            }
            data[in] = temp;
        }
    }
}