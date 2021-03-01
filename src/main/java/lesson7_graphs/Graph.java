package lesson7_graphs;

import java.util.*;

public class Graph implements IGraph { // невзвешенный, ненаправленный графф

    private final List<Vertex> vertexList; // список для хранения вершин
    private final boolean[][] adjMat; // массив для хранения связей

    public Graph(int maxVertex) {
        this.vertexList = new ArrayList<>(maxVertex);
        this.adjMat = new boolean[maxVertex][maxVertex];
    }

    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    @Override
    public void addEdge(String startLabel, String endLabel) { // добавление вершин
        int startIndex = indexOf(startLabel); // что бы добавить связь нужно узнать есть ли эти вершины
        int endIndex = indexOf(endLabel);

        if (startIndex == -1 || endIndex == -1) {
            throw new IllegalArgumentException("Invalid label for vertex");
        }

        adjMat[startIndex][endIndex] = true; // устанавливаем факт связи
        adjMat[endIndex][startIndex] = true;
    }

    /*
     метод по добавдению ребра, который упрощает реализацию графа;
     вершину связываем со всеми добавляемыми
     добавляется 1-й параметр, 2-й(конечный) он обязательный и далее все остальные (не очень понятно)
     */
    @Override
    public void addEdges(String startLabel, String secondLabel, String... others) { // ! ... варируемое кол-во аргументов
        addEdge(startLabel, secondLabel);
        for (String other : others) {
            addEdge(startLabel, other);
        }
    }

    private int indexOf(String startLabel) {
        for (int index = 0; index < getSize(); index++) {
            if (vertexList.get(index).getLabel().equals(startLabel)) {
                return index;
            }
        }

        return -1;
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        for (int i = 0; i < getSize(); i++) {
            System.out.println(vertexList.get(i)); // выводим логику для отображения связей
            for (int j = 0; j < getSize(); j++) {
                if (adjMat[i][j]) {
                    System.out.print(" -> " + vertexList.get(j));
                }
            }
            System.out.println();
        }
    }

    // Обходы графов

    @Override
    public void dfs(String startLabel) { // in depth
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid start label");
        }

        Stack<Vertex> stack = new Stack<>(); // создаём стек
        Vertex vertex = vertexList.get(startIndex); // получаем экземпляр вершины

        visitVertex(stack, vertex); // посещаем текущую вершину
        while (!stack.isEmpty()) { // пока стек не путой
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }

        resetVertexState(); // сбрасываем состояние(true) у всех наших вершин
    }

    @Override // вся логика обхода точно такая же, меняется только стек и очередь и метод peek/remove
    public void bfs(String startLabel) { // in width
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid start label");
        }

        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(queue, vertex);
        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex != null) {
                visitVertex(queue, vertex);
            } else {
                queue.remove();
            }
        }

        resetVertexState();
    }

    private void resetVertexState() {
        for (Vertex vertex : vertexList) {
            vertex.setVisited(false);
        }
    }

    private Vertex getNearUnvisitedVertex(Vertex current) { // находим от нашей вершины ближайшую непосещенную
        int currentIndex = vertexList.indexOf(current);
        for (int i = 0; i < getSize(); i++) {
            // если связь у нас имеется(т.е. вршины смежные) и наша текущая вершина была не посещена
            if (adjMat[currentIndex][i] && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }

        return null;
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.println(vertex); // выводим в консоль
        vertex.setVisited(true); // помечаем как посещённую
        stack.push(vertex); // добавляем текущую вершину в стек
    }

    private void visitVertex(Queue<Vertex> queue, Vertex vertex) {
        System.out.println(vertex);
        vertex.setVisited(true);
        queue.add(vertex);
    }
}