package lesson5_recursion;

import java.util.LinkedHashSet;
import java.util.Set;

/*
 нужно смотреть урок непростой пример, непонятный
 */
public class Anagram {
    private final char[] chars;
    private String word;
    private Set<String> anagrams = new LinkedHashSet<>();

    public Anagram(String word) {
        this.word = word;
        this.chars = word.toCharArray(); // !*!*! помним про этот метод
    }

    public static void main(String[] args) {
        Anagram anagram = new Anagram("cat");
        Set<String> result = anagram.getAnagrams();
        for (String value : result) {
            System.out.println(value);
        }
    }

    private Set<String> getAnagrams() {
        anagrams.clear(); // если не пустая очищаем
        processAnagram(word.length());
        return anagrams;
    }

    private void processAnagram(int length) {
        if (length <= 1) {
            return;
        }

        for (int i = 0; i < length; i++) {
            // вызываем рекурсивный метод
            processAnagram(length - 1); // вызываем одну и туже задачу для слова из меньшего кол-ва букв
            anagrams.add(String.valueOf(chars)); // фиксируем все анаграммы
            rotate(length);
        }
    }

    private void rotate(int length) {
        int pos = word.length() - length; // находим изначальную позицию откудп делать перестановки
        char temp = chars[pos]; // фиксируем 1-й символ во временную переменную, относительно нашей позиции

        for (int i = pos + 1; i < chars.length; i++) { // реализовываем циклический сдвиг
            chars[i - 1] = chars[i];
        }
        chars[chars.length - 1] = temp;
    }
}