package lesson7_graphs;

import java.util.Objects;

public class Vertex {

    private final String label; // данные которые охарактеризовывают вершину, объект название города
    private boolean isVisited; // была ли посещена вершина #для реализации обхода

    public Vertex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public boolean isVisited() { //#
        return isVisited;
    }

    public void setVisited(boolean visited) { //#
        isVisited = visited;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        /*
         !*!*! дополнительный код как сравнивать объекты в коллекции не только
          как объекты, но и по их стрингам, т.к. класс Vertex обёртка над стрингом
        if (o instanceof String) {
            return Objects.equals(label, o);
        }
         */
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(label, vertex.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label='" + label + '\'' +
                '}';
    }
}