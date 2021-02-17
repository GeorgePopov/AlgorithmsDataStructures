package lesson4_linkedLists.trainingManual;

public class GenericListApp {
    public static void main(String[] args) {
        LinkedListEx<String> list = new LinkedListEx<>();

        list.insert("Artem");
        list.insert("Roman");
        list.insert("George");

        System.out.println("search: " + list.find("Artem"));

        list.display();

        System.out.println("---");
        list.delete();
        list.display();

        System.out.println("-----");
        while (!list.isEmpty()) {
            System.out.println(list.delete().getValue());
        }

        System.out.println("list is empty: " + list.isEmpty());

        System.out.println("----------");
        LinkedListEx<People> peopleList = new LinkedListEx<>();

        peopleList.insert(new People("Artem", 22));
        peopleList.insert(new People("Roman", 18));
        peopleList.insert(new People("George", 24));

        peopleList.insert(new People("Vova", 27));
        peopleList.insert(new People("Mihsa", 30));

        System.out.println(peopleList.find(new People("Artem", 22)).toString());
        peopleList.display();

        peopleList.delete();
        peopleList.delete();

        System.out.println("people is empty: " + peopleList.isEmpty());
        peopleList.display();
    }
}