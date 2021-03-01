package lesson6_trees;

public class Node<T extends Comparable<? super T>> { // T пишеться в классах а E в коллекциях

    final T value;
    private Node<T> leftChild;
    private Node<T> rightChild;


    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    // внутри самого узла мы добавляем логику, что мы должны добавить под левым дочернем эл-том, а что под правым
    public boolean isLeftChild(T value) {
        return value.compareTo(this.value) < 0; // если передаваемое значение меньше то распологаться будет оно слева
    }

    public boolean isLeaf() {
        return leftChild == null || rightChild == null;
    }

    public boolean hasOnlyOneChild() {
//        return (leftChild == null && rightChild != null || leftChild != null && rightChild == null);
        /*
         ! пример побитовой операции т.к. мы получаем результат boolean;
         побитовую операцию с boolean можно использовать;
         исключающая или работает по принципу, что true она будет возвращать в том случае
         если наши операнды будут иметь разное значение;
         побитовую операцию здесь можем применить т.к. и с лева и с права boolean
         т.е. 0 или 1 и наоборот.
         */
        return leftChild == null ^ rightChild == null;

    }
}
