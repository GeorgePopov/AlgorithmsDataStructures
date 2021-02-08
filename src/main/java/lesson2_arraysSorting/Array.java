package lesson2_arraysSorting;

public interface Array<E> {

    void add(E value); // алгоритм добавления эл-та

    E get(int index); // алгоритм поиска эл-та

    boolean remove(E value); // алгоритм удаления эл-та

    E remove(int index);

    int indexOF(E value);

    boolean contains(E value);

    boolean isEmpty();

    int size();

    void display();

    // сортировки
    void sortBubble(); // пузырьком
    void sortSelect(); // выбором
    void sortInsert(); // вставкой
}