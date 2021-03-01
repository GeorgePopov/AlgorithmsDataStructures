package lesson7_graphs;

public interface IGraph { // можно сделать обобщенным

    void addVertex(String label);

    void addEdge(String startLabel, String endLabel);

    void addEdges(String startLabel, String secondLabel, String... others);

    int getSize();

    void display();

    /**
     * англ. Depth-first search, DFS, алгоритм обхода в глубину
     */
    void dfs(String startLabel);

    /**
     * англ. Breadth-first search, BFS, алгоритм обхода в ширину
     */
    void bfs(String startLabel);
}