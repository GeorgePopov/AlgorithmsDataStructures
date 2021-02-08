package lesson2_arraysSorting.trainingManual;

public class MyArr {
    private int[] arr;
    private int size;

    public MyArr(int size) {
        this.size = size;
        this.arr = new int[size];
    }

    public int getElement(int index) {
        return this.arr[index];
    }

    public void setElement(int index, int elem) {
        this.arr[index] = elem;
    }

    public int[] deleteElement(int elem) {
        int i = 0;
        for (i = 0; i < this.size; i++) {
            if (this.arr[i] == elem) break;
        }

        for (int j = i; j < this.size - 1; j++) {
            this.arr[j] = this.arr[j + 1];
        }
        this.size--;

        return this.arr;
    }

    public int getSize() {
        return this.size;
    }
}