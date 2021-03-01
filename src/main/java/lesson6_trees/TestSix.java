package lesson6_trees;

public class TestSix {

    public static void main(String[] args) {
        ITree<Integer> tree = new TreeImpl<>();
        tree.add(60);
        tree.add(50);
        tree.add(66);
        tree.add(40);
        tree.add(55);
        tree.add(70);
        tree.add(31);
        tree.add(45);
        tree.add(42); // новые
        tree.add(43); // новые
        tree.add(67);
        tree.add(81);

        System.out.println("Find 70: " + tree.contains(70));
        System.out.println("Find 700: " + tree.contains(700));

        tree.display();
        tree.remove(66); // в данном примере работает некорректно
        tree.display();

//        tree.traverse(ITree.TraverseMode.IN_ORDER); // по возрастанию
//        tree.traverse(ITree.TraverseMode.PRE_ORDER); // сначала выводит всех родителей потом дочерние эл-ты слева направо
//        tree.traverse(ITree.TraverseMode.POST_ORDER); // сначала выводит все дочерние эл-ты потом родителей слева направо
    }
}