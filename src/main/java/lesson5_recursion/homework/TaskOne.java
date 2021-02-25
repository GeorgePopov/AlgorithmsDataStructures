package lesson5_recursion.homework;
/*
 Написать программу по возведению числа в степень с помощью рекурсии.
 */
public class TaskOne {
    public static void main(String[] args) {
        System.out.println("Положительное число или 0 в степени 0 = " + raisingNumberToPower(7, 0));
        System.out.println("Отрицательное число в степени 0 = " + raisingNumberToPower(-8, 0));
        System.out.println("Число в степени = " + raisingNumberToPower(5, 5));
        System.out.println("Отрицательное число в степени = " + raisingNumberToPower(-3, 3));
        System.out.println("Exception: " + raisingPositiveNumberToPower(-4, 4));
    }

    private static double raisingNumberToPower(double number, double power) {
        if (power == 1) {
            return number;
        } else if (power == 0) {
            if (number >= 0) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return number * raisingNumberToPower(number, power - 1);
        }
    }

    private static double raisingPositiveNumberToPower(double number, double power) {
        if (number > 0) {
            if (power == 1 || power <= 0) {
                return number;
            } else {
                return number * raisingNumberToPower(number, power - 1);
            }
        } else {
            throw new IllegalArgumentException("Negative number or zero entered");
        }
    }
}