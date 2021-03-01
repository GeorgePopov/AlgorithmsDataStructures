package lesson6_trees;

public interface ITree<E extends Comparable<? super E>> {
    void add(E value);
    boolean contains(E value);
    boolean remove(E value);

    boolean isEmpty();
    int size();
    void display();

    /*
    !*!*! обход дерева может быть: семетричным прямым обратным
    расширяем интерфейс для обхода, enum будет представлять три режима обхода
    */
    enum TraverseMode {
        IN_ORDER, // симетричный
        PRE_ORDER, // прямой
        POST_ORDER // обратный
    }

    void traverse(TraverseMode mode);
}
