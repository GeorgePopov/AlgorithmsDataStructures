package lesson5_recursion.homework;

public class Things {
    private final String name;
    private final int weight;
    private final int price; // in euro

    public Things(String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name;
    }
}
