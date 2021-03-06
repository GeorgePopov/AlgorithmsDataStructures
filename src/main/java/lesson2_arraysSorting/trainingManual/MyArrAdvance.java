package lesson2_arraysSorting.trainingManual;

public class MyArrAdvance {
    private int[] arr;
    private int size;

    public MyArrAdvance(int size) {
        this.size = 0;
        this.arr = new int[size];
    }

    public void display() {
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.arr[i]);
        }
    }

    public void delete(int value) {
        int i = 0;
        for(i = 0; i < this.size; i++) {
            if (this.arr[i] == value) break;
        }

        for (int j = i; j < this.size - 1; j++) {
            this.arr[j] = this.arr[j + 1];
        }
        this.size--;
    }

    public void insert(int value) {
        this.arr[this.size] = value;
        this.size++;
    }

    public boolean find(int value) {
        for (int i = 0; i < this.size; i++) {
            if (this.arr[i] == value) {
                return true;
            }
        }
        return false;
    }

    public boolean binaryFind(int value) {
        int low = 0;
        int high = this.size - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (value < this.arr[mid]) {
                return true;
            } else {
                if (value < this.arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return false;
    }
}
