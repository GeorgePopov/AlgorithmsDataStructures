package lesson4_linkedLists.homework;

public class TestClass {
    public static void main(String[] args) {

        LinkedListMyEx<Person> myList = new MyLinkedList<>();

        myList.insertFirst(new Person("Semen", 30));
        myList.insertFirst(new Person("Anna", 21));
        myList.insertFirst(new Person("Helena", 29));
        myList.insertFirst(new Person("Sam", 26));
        myList.insertFirst(new Person("Bob", 33));

        MyLinkedListIterator<Person> myIterator = (MyLinkedListIterator<Person>) myList.iterator();

        while (myIterator.hasNext()) {
            System.out.println(myIterator.next());
        }

        System.out.println("----------");
        for (Person o : myList) {
            System.out.println(o);
            myList.remove(o);
        }

        System.out.println("----------");
        System.out.println("Collection is empty: " + myList.isEmpty());
    }
}