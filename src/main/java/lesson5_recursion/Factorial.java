package lesson5_recursion;

/*
 здесь пример и хвостовой рекурсии
 !*!*! написание факториала спрашивают на собеседованиях (и хвостового факториала)
 5! = 5 * 4 * 3 * 2 * 1 = 120
 факториал - произведение всех чисел от текущего и до 0
 в калькуляторе (n!)
 */

import java.math.BigInteger;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(5));
//        System.out.println(tailFact(5));

        // ! можно так
//        Integer.MAX_VALUE
//        Integer.MIN_VALUE
//        BigInteger n;
//        BigInteger.ONE
//        BigInteger.valueOf(10);
    }

    private static int tailFact(int n) {
        return fact(1, n);
    }

    private static int fact(int acc, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n should be 0 or positive value");
        }

        if (n == 0 || n == 1) {
            return acc;
        }

        return fact(acc * n, n - 1);
    }

    private static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n should be 0 or positive value");
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }
}