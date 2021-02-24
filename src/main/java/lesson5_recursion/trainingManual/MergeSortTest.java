package lesson5_recursion.trainingManual;

import java.util.Arrays;
/*
 !*!*! крутейший пример сортировки слиянием
 */
public class MergeSortTest {
    public static void mergeSort(int[] arr, int size) { // рекурсивная функция разделения массива
        if (size < 2) {
            return;
        }
        int mid = size / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[size - mid];

        for (int i = 0; i < mid; i++) { // можно заменить на System.arrayCopy()
            leftArr[i] = arr[i];
        }

        for (int i = mid; i < size; i++) {
            rightArr[i - mid] = arr[i];
        }

        mergeSort(leftArr, mid);
        mergeSort(rightArr, size - mid);

        merge(arr, leftArr, rightArr, mid, size - mid);
    }

    private static void merge(int[] arr, int[] leftArr, int[] rightArr, int left, int right) { // функция слияния
        int i = 0;
        int j = 0;
        int count = 0;

        while (i < left && j < right) {
            if (leftArr[i] <= rightArr[j]) {
                arr[count++] = leftArr[i++];
            } else {
                arr[count++] = rightArr[j++];
            }
        }
        while (i < left) {
            arr[count++] = leftArr[i++];
        }
        while ((j < right)) {
            arr[count++] = rightArr[j++];
        }
    }

    public void positiveTest() {
        int[] actual = {5, 1, 6, 2, 3, 4};
        int[] expected = { 1, 2, 3, 4, 5, 6 };
        MergeSortTest.mergeSort(actual, actual.length);
        assertArrayEquals(expected, actual);
    }

    private void assertArrayEquals(int[] expected, int[] actual) {
        System.out.println(Arrays.equals(expected, actual));
    }

    public static void main(String[] args) {
        new MergeSortTest().positiveTest();
    }
}