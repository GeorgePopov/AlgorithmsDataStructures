package lesson2_arraysSorting.trainingManual;

public class Main {
    public static void main(String[] args) {

//        exampleMain();
//        exampleMyArr();
//        exampleMyArrAdvance();
//        exampleMyArrAdvanceFind();
//        exampleMyArrBinaryFind();

    }

    private static void exampleMyArrBinaryFind() {
        MyArrBinaryFind arr = new MyArrBinaryFind(10);
        arr.insert(-10);
        arr.insert(45);
        arr.insert(26);
        arr.insert(20);
        arr.insert(25);
        arr.insert(40);
        arr.insert(75);
        arr.insert(80);
        arr.insert(82);
        arr.insert(91);

        int search = 40;
        System.out.println(arr.binaryFind(search));
    }

    private static void exampleMyArrAdvanceFind() {
        MyArrAdvance arr = new MyArrAdvance(10);
        arr.insert(5);
        arr.insert(1);
        arr.insert(2);
        arr.insert(5);
        arr.insert(4);
        arr.insert(5);
        arr.insert(6);
        arr.insert(5);
        arr.insert(8);
        arr.insert(9);

        int search = 8;

        System.out.println("Displaying an array");
        arr.display();

        if (arr.find(search)) {
            arr.delete(search);
            System.err.println("Element " + search + " removed");
            System.out.println("Displaying a new array");
            arr.display();
        } else {
            System.out.println("Could not find item " + search);
        }
    }

    private static void exampleMyArrAdvance() {
        MyArrAdvance arr = new MyArrAdvance(10);
        arr.insert(5);
        arr.insert(1);
        arr.insert(2);
        arr.insert(5);
        arr.insert(4);
        arr.insert(5);
        arr.insert(6);
        arr.insert(5);
        arr.insert(8);
        arr.insert(9);

        System.out.println("Displaying an array");
        arr.display();
        arr.delete(1);
        arr.delete(2);
        arr.delete(3);
        System.out.println("Displaying a new array");
        arr.display();
    }

    private static void exampleMyArr() {
        MyArr arr = new MyArr(10);
        arr.setElement(0,5);
        arr.setElement(1,5);
        arr.setElement(2,5);
        arr.setElement(3,5);
        arr.setElement(4,5);
        arr.setElement(5,5);
        arr.setElement(6,1);
        arr.setElement(7,5);
        arr.setElement(8,5);
        arr.setElement(9,5);

        System.out.println("Displaying an array");
        for (int j = 0; j < arr.getSize(); j++) {
            System.out.println(arr.getElement(j));
        }

        arr.deleteElement(1);

        System.out.println("Displaying a new array");
        for (int j = 0; j < arr.getSize(); j++) {
            System.out.println(arr.getElement(j));
        }
    }

    private static void exampleMain() {
        int[] myArr1 = {1, 2, 3, 4, 5, 2};
        int i;
        int len = myArr1.length;
        int search = 4;

        System.out.println("Displaying an array");
        for (int j = 0; j < len; j++) {
            System.out.println(myArr1[j]);
        }

        System.out.println("Find an item");
        for (i = 0; i < len; i++) {
            if (myArr1[i] == search) {
                break;
            }
        }

        System.out.println("Shift all elements 1 step to the left");
        for (int j = i; j < len - 1; j++) {
            myArr1[j] = myArr1[j + 1];
        }
        len--;

        System.out.println("Outputting an array with an element removed");
        for (int j = 0; j < len; j++) {
            System.out.println(myArr1[j]);
        }
    }
}