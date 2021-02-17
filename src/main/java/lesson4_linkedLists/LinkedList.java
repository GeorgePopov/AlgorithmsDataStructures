package lesson4_linkedLists;

public interface LinkedList<E> {

    void insertFirst(E value);

    E removeFirst();

    boolean remove(E value);

    boolean contains(E value);

    int size();

    boolean isEmpty();

    void display();

    E getFirst(); // метод возвращает значение (метод для LinkedStackImpl)

    // описание эл-та связанного списка, он будет тогоже типа, что и список
    static class Node<E> {
        public E item; // ссылка на данные которое храним
        public Node<E> next; // ссылка на следующий эл-нт, тогоже типа

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }
}