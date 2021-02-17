package lesson4_linkedLists;

import java.util.Optional;

// здесь работает принцип LIFO
public class SimpleLinkedListImpl<E> implements LinkedList<E> {

    protected int size; // хранение кол-ва эл-тов, default: null
    protected Node<E> firstElement; // ссылка на первый эл-нт нашего связанного списка, default: null //002[006-->005]
    // firstElement будет всегда ссылаться на последний добавленный эл-нт
    /*
     три дейстия для вставки:
     1 создание эл-та
     2 связка нового эл-та с первым эл-том
     3 перекидывание значения ссылки самого нашего свяанного списка
     */
    @Override
    public void insertFirst(E value) { // вставка слева
        // создаём экземпляр класса, передаём в него значение и ссылку на первый эл-нт
        // теперь связанный список будет ссылаться не на предыдущий эл-нт, а на тот который добавили
        firstElement = new Node<>(value, firstElement); //001[005] --> //002[006-->005]
        size++;
    }

    // основные действия здесь обновление ссылки
    @Override
    public E removeFirst() { // удаление слева
        if (isEmpty()) {
            return null;
        }

        Node<E> removeNode = firstElement; // запоминаем удаляемый эл-нт
        firstElement = removeNode.next; // обновляем firstElement, на тот который стоит правее от него
//        firstElement = firstElement.next;

        removeNode.next = null; // у обнуляемого эл-та обнуляем ссылку, что бы ни кто не достучался
        size--;
        return removeNode.item;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = firstElement; // ссылка на первый эл-нт
        Node<E> previous = null; // ссылка на предыдущий эл-нт

        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }

            previous = current; // 1 2 3 ...
            current = current.next; // 2 3 4 ...
        }

        if (current == null) { // элемент не найден, после прохода всего списка
            return false;
        }

        if (current == firstElement) {
            firstElement = firstElement.next; // удаляем эл-нт слева первый
        } else {
            previous.next = current.next; // перекидываем ссылку через удаляемый эл-нт
        }

        current.next = null;
        size--;
        return true;
    }

    @Override
    public boolean contains(E value) {
        Node<E> current = firstElement;
        while (current != null) {
            if (current.item.equals(value)) {
                return true;
            }
            current = current.next; // переходим на следующий эл-нт
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return firstElement == null;
    }

    /*
    !*!*! Пример как нужно обойти все данные LinkedList
     */
    @Override
    public void display() {
        System.out.println("----------");
        Node<E> current = firstElement;
        while (current != null) {
            System.out.println(current.item);
            current = current.next;
        }
        System.out.println("----------");
    }

    // метод для LinkedStackImpl
    @Override
    public E getFirst() {
//        return firstElement != null ? firstElement.item : null;
        /*
         !*!*! Optional опшионал функционал в java, который позволяет обернуть в себя
         игициализируем наш Optional null-лебл объектом, говоря, что эта ссылка возможно будет пустой
         доступно с java 8
         */
        return Optional.ofNullable(firstElement)
                .map(node -> node.item)
                .orElse(null);
    }
}