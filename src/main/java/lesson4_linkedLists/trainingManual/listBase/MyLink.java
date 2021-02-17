package lesson4_linkedLists.trainingManual.listBase;

public class MyLink {
    private String name;
    private int age;

    protected MyLink next; // default value: null

    public MyLink(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Name: " + this.name + ", age: " + this.age);
    }
}