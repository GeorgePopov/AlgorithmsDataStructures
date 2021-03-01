package lesson6_trees;

import java.util.Stack;
import java.util.function.Consumer;

public class TreeImpl<E extends Comparable<? super E>> implements ITree<E> { // E пишеться в коллектиях, а T в классах

    private class NodeAndParent { // просто объект который в себе содержит две ссылки на текущий и предыдущий эл-нты
        Node<E> current;
        Node<E> parent;

        public NodeAndParent(Node<E> current, Node<E> parent) {
            this.current = current;
            this.parent = parent;
        }
    }
    private int size;
    private Node<E> root;

    @Override
    public void add(E value) {
        Node<E> newNode = new Node<>(value);

        if (isEmpty()) { // 1. если список пустой инициализируем корень
            root = newNode;
            size++;
            return;
        }

        // 2. если есть хотя бы один эл-нт занимаемся поиском
        /*Node<E> current = root;
        Node<E> previous = null; // у корневого нет предыдущего эл-та
        while (current != null) { // ищем элемент
            if (current.getValue().equals(value)) {
                // current.setValue(value); так типа перетирать
                return; // если находмим такоеже не перетираем, просто выходим
            }
            previous = current; // обновляем предыдущее
            if (value.compareTo(current.getValue()) < 0) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }*/
        NodeAndParent nodeAndParent = doFind(value); // усовершенствованный код относительно предыдущего
        if (nodeAndParent.current != null) {
            // nodeAndParent.setValue(value); можно так
            return;
        }
        Node<E> previous = nodeAndParent.parent;
        /*
         * условие заключаемтся в том, каой сеттер мы хотим использовать для переменной previous,
         * целый метод мы фиксируем как переменную и потом на основе того интерфейса к кторорому
         * мы его привели вызываем нужный сеттер. Consumer ни чего не возвращает но принимает один
         * аргумент.
         * !*!*! тернарный оператор мы можем использовать в том случае если мы хотим вернуть или присвоить какое-то значение
         * более сложный но копмактный пример

        Consumer<Node<E>> setter = previous.isLeftChild(value) ? previous::setLeftChild : previous::setRightChild;
        setter.accept(newNode);*/
        // 3. если нашли обновляем ссылку
        if (previous.isLeftChild(value)) { // если не нашли
            previous.setLeftChild(newNode);
        } else {
            previous.setRightChild(newNode);
        }

        size++;
    }

    @Override
    public boolean contains(E value) {
        /*Node<E> current = root;
        while (current != null) {
            if (current.getValue().equals(value)) {
                return true;
            } else if (current.isLeftChild(value)) {
                    current = current.getLeftChild(); // если искомое значение меньше
            } else {
                current = current.getRightChild(); // если больше идём вправо
            }
        }

        return false;*/
        NodeAndParent nodeAndParent = doFind(value); // усовершенствованный код относительно предыдущего
        return nodeAndParent.current != null;
    }

    // здесь занимаемся поиском от текущего эл-та до нужного. Ищет как текущий эл-нт так и предыдущий
    private NodeAndParent doFind(E value) {
        Node<E> current = root;
        Node<E> previous = null;
        while (current != null) {
            if (current.getValue().equals(value)) {
                return new NodeAndParent(current, previous); // возврящаем текущий и предыдущий(если он есть)
            }
            previous = current;
            if (current.isLeftChild(value)) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }

        return new NodeAndParent(null, previous);
    }

    @Override
    public boolean remove(E value) {
        // создаём объект класса, используем алгоритм поиска, что бы найти удаляемый эл-нт и его родителя
        NodeAndParent nodeAndParent = doFind(value);
        Node<E> removeNode = nodeAndParent.current;
        Node<E> parentNode = nodeAndParent.parent;

        if (removeNode == null) {
            return false;
        }

        if (removeNode.isLeaf()) { // 1. если эл-нт листовой
            if (removeNode == root) { // если удаляемый эл-нт корневой
                root = null; // обнуляем ссылку
            }
            if (parentNode.isLeftChild(value)) { // обнуляем ссылку родителя
                parentNode.setLeftChild(null);
            } else {
                parentNode.setRightChild(null);
            }
        } else if (removeNode.hasOnlyOneChild()) { // 2. если это не листовой эл-нт и у него одна ссылка left or right
            // возвращаем в переменную едиснтвенный дочерний эл-нт
            Node<E> childNode = removeNode.getLeftChild() != null
                    ? removeNode.getLeftChild()
                    : removeNode.getRightChild();

            if (removeNode == root) { // если удаляемы эл-нт корневой
                root = childNode;
            } else {
                if (parentNode.isLeftChild(value)) {
                    parentNode.setLeftChild(childNode); // перезаписываем новую ссылку
                } else {
                    parentNode.setRightChild(childNode);
                }
            }
        } else { // 3. удаляемый узел имеет двух потомков
            Node<E> successor = getSuccessor(removeNode); // находим кондидата под замену удаляемого эл-та
            if (removeNode == root) { // это означает, что у нас корень с двумя дочерними эл-ми
                root = successor; // тогда корень будет наш новый найденный кандидат
            } else if (parentNode.isLeftChild(value)) {
                parentNode.setLeftChild(successor);
            } else {
                parentNode.setRightChild(successor);
            }

            successor.setLeftChild(removeNode.getLeftChild());
        }

        size--;
        return true;
    }

    private Node<E> getSuccessor(Node<E> removeNode) { // сложный пример lesson 2:07min
        Node<E> successor = removeNode; // кандидат под замену
        Node<E> successorParent = null; // сылка на родителя кандидата под замену
        Node<E> current = removeNode.getRightChild();

        while (current != null) { // ищем минимальный левый эл-нт в правой ветке от удаляемого
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }

        if (successor != removeNode.getRightChild() && successorParent != null) { // что бы не сделать зацикливание
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(removeNode.getRightChild());
        }

        return successor;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() { // copy/paste. рекомендовано разобраться
        Stack<Node<E>> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 64;

        boolean isRowEmpty = false;
        System.out.println("................................................................");

        while (!isRowEmpty) {
            Stack<Node<E>> localStack = new Stack<>();

            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node<E> tempNode = globalStack.pop();
                if (tempNode != null) {
                    System.out.print(tempNode.getValue());
                    localStack.push(tempNode.getLeftChild());
                    localStack.push(tempNode.getRightChild());
                    if (tempNode.getLeftChild() != null || tempNode.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }

            nBlanks /= 2;
        }
        System.out.println("................................................................");
    }

    // обход
    // !*!*! вообще крутые примеры выбора действий, как и в клиент-чате
    @Override
    public void traverse(TraverseMode mode) {
        // !*!*! новая версия switch в новых версиях java
        /*switch (mode) { // !*!*! новая версия switch
            case IN_ORDER -> inOrder(root);
            case PRE_ORDER -> preOrder(root);
            case POST_ORDER -> postOrder(root);
        }*/
        switch (mode) {
            case IN_ORDER:
                inOrder(root);
                break;
            case PRE_ORDER:
                preOrder(root);
                break;
            case POST_ORDER:
                postOrder(root);
                break;
            default:
                // это стандартный кейс когда с помощью switch мы обходим какое-то значение
                // это в будующем поможет выявить метса, когда вы забыли обработать новое значение в enum
                throw new IllegalArgumentException("Unknown traverse mode: " + mode);
        }
    }

    // !*!*! крутые примеры рекурсии
    private void inOrder(Node<E> current) {
        if (current == null) {
            return;
        }

        inOrder(current.getLeftChild());
        System.out.println(current.getValue());
        inOrder(current.getRightChild());
    }

    private void preOrder(Node<E> current) {
        if (current == null) {
            return;
        }

        System.out.println(current.getValue()); // идём от текущего эл-та потом дочернии
        preOrder(current.getLeftChild());
        preOrder(current.getRightChild());
    }

    private void postOrder(Node<E> current) {
        if (current == null) {
            return;
        }

        postOrder(current.getLeftChild());
        postOrder(current.getRightChild());
        System.out.println(current.getValue()); // сначала дочернии эл-ты потом текущий
    }
}