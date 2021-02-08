package lesson1_baseInformation;

public class  Test {

    public static void main(String[] args) {
        int a = 5;
        System.out.println("before Main a = " + a);
        testPrimitive(a);
        System.out.println("after Main a = " + a);

        System.out.println("-------");
        Person p = new Person("TestName", 25);
        System.out.println("before Main p = " + p);
        testRef(p);
        System.out.println("after Main p = " + p);

        System.out.println("-------");
        Person p1 = new Person("TestName", 25); // 001[101]
        Person p2 = new Person("TestName", 25); // 002[202]
        System.out.println(p1 == p2); // 101 == 202
        System.out.println(p1.equals(p2));
    }

    private static void testPrimitive(int a) { // изменить значение переменной 'a' возможно если её объявить в классе
        System.out.println("before testPrimitive a = " + a);
        a = 7;
        System.out.println("after testPrimitive a = " + a);
    }

    private static void testRef(Person p) { // если необходимо изменить 'p' нужно использовать set-тер
        System.out.println("before testRef p = " + p);
        p = new Person("Another one", 33);
        System.out.println("after testRef p = " + p);
    }
}