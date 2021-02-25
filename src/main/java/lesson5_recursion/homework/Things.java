package lesson5_recursion.homework;

import java.util.Objects;

public class Things {
    private final String name;
    private final int weight;
    private final int price; // in euro

    public Things(String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Things things = (Things) o;
        return weight == things.weight && price == things.price && Objects.equals(name, things.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, price);
    }
}
