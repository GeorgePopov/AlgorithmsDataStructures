package lesson4_linkedLists;

public class TwoSideLinkedListImpl<E>
        extends SimpleLinkedListImpl<E>
        implements ToSideLinkedList<E> {

    private Node<E> lastElement;

    @Override
    public void insertFirst(E value) {
        super.insertFirst(value);
        if (size == 1) {
            lastElement = firstElement;
        }
    }

    @Override
    public E removeFirst() {
        E removeValue =  super.removeFirst();
        if (isEmpty()) {
            lastElement = null;
        }

        return removeValue;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = firstElement;
        Node<E> previous = null;

        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }

            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (size == 1) { // исключаем ситуацию, когда в списке один эл-нт
            removeFirst();
            return true;
        }

        if (current == firstElement) {
            firstElement = firstElement.next;
        }
        else if (current == lastElement) {
            lastElement = previous;
            previous.next = null; // обнуляем ссылку у предыдущего эл-та на следующий(последний эл-нт, который удалили)
        }
        else {
            previous.next = current.next;
        }

        current.next = null;
        size--;
        return true;
    }

    @Override
    public void insertLast(E value) {
        Node<E> newNode = new Node<>(value, null); // создаём новый эл-нт, ссылаться ни куда он не будет, он последний
        if (isEmpty()) { // если мы вставляем первый эл-нт
            firstElement = newNode;
//            lastElement = newNode;
        } else {
            lastElement.next = newNode; // последний эл-нт ссылается на добавляемый эл-нт
//            lastElement = newNode;
        }

        lastElement = newNode; // чтобы код не дублировать выносим его
        size++;
    }
}