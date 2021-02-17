package lesson4_linkedLists.trainingManual.listBase;

public class LinkForTwoSide {
    public String name;
    public int age;

    public LinkForTwoSide next;

    public LinkForTwoSide(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void display(){
        System.out.println("Name: "+this.name+", age: "+this.age);
    }
}