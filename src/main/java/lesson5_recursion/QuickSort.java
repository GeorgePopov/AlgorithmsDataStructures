package lesson5_recursion;

import java.util.Arrays;
/*
 реализация быстрой сортировки (один из самых оптимальных вариантов)
 */
public class QuickSort {
    public static void quickSort(int[] array, int low, int high) {

        if (array.length == 0)
            return;//завершить выполнение, если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2; // средний эл-нт
        int pivot = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < pivot) { // все элементы котрый меньше попадают в этот массив
                i++;
            }

            while (array[j] > pivot) { // все элементы котрый больше попадают в этот массив
                j--;
            }

            /*
             в конечном итоге в массиве делаем перестановки относительно среднего эл-та,
             всё что меньше находится слева, всё что больше находится спара
             */
            if (i <= j) { //меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }

    public static void main(String[] args) {
        int[] x = {8, 0, 4, 7, 3, 7, 10, 12, -3};
        System.out.println("Было");
        System.out.println(Arrays.toString(x)); // так выводить массив

        int low = 0;
        int high = x.length - 1;

        quickSort(x, low, high);
        System.out.println("Стало");
        System.out.println(Arrays.toString(x));
    }
}