package lesson3_stackQueue.stack;

import java.util.Map;

// последняя открывающаяся должна соответствовать последней закрывающейся
public class Brackets {
    private static final String EXAMPLE = """
                    public static void main(String[] args) {
                        testStack();
                    }
            """;

    private static final Map<Character, Character> BRACKETS_MAP = Map.of(
            '{', '}',
            '[', ']',
            '(', ')'
    );

    public static void main(String[] args) {
        new Brackets().check(EXAMPLE);
    }

    public void check(String text) {
        IStack<Character> stack = new StackImpl<>(text.length());

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i); // с помощью метода charAt() извлекаем текущий эл-нт нашей строки

            switch (currentChar) {
                case '{':
                case '[':
                case '(':
                    stack.push(currentChar);
                    break;
                case  '}':
                case  ']':
                case  ')':
                    if (stack.isEmpty()) { // последних закрывающихся не больше чем открывающихся
                        System.err.println("Error: " + currentChar + " at " + i);
                        break;
                    }
                    Character lastOpenBracket = stack.pop(); // проверка на совпадение типов
                    if (!BRACKETS_MAP.get(lastOpenBracket).equals(currentChar)) {
                        System.err.println("Error: " + currentChar + " at " + i);
                    }
                    break;
                default:
                    break;
            }
        }

        if (!stack.isEmpty()) { // последних открывающихся не больше чем закрывающихся
            System.err.println("Error: missing right delimiter");
        }
    }
}