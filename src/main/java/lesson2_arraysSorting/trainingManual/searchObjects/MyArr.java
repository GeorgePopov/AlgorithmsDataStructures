package lesson2_arraysSorting.trainingManual.searchObjects;

public class MyArr {
    private Person[] arr;
    private int size;

    public MyArr(int size) {
        this.size = 0;
        this.arr = new Person[size];
    }

    public boolean find(String search) {
        int i;
        for (i = 0; i < size; i++) {
            if (this.arr[i].getName().equals(search)) break;
        }
        if (i == this.size) // интересное выражение
            return false;
        else
            return true;
    }

    public void display() {
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.arr[i].getName() + this.arr[i].getAge());
        }
    }

    public void delete(String search) {
        int i = 0;
        for (i = 0; i < this.size; i++) {
            if (this.arr[i].getName().equals(search)) break;
        }

        for (int j = i; j < this.size - 1; j++) {
            this.arr[j] = this.arr[j + 1];
        }
        this.size--;
    }

    public void insert(String name, int age) {
        this.arr[this.size] = new Person(name, age);
        this.size++;
    }
}

class Main {
    public static void main(String[] args) {
        int size = 100;
        MyArr arr = new MyArr(size);
        arr.insert("Rob", 10);
        arr.insert("Sam", 15);
        arr.insert("Bill", 20);
        arr.display();

        System.out.println("After deletion");
        arr.delete("Bill");
        arr.display();
    }
}














