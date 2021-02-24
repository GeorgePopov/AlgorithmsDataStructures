package lesson5_recursion;

import java.io.File;

public class ShowFiles {
    public static void main(String[] args) {
//        "d:\\Google Driver\\ GeekBrains\\Java. Уровень 3\\" teacher example
        File root = new File("C:\\Users\\polit\\Downloads\\10-45-pz(2)");
        viewDir("", root);
    }

    // крутой пример рекурсии, просмотреть текущую директорию и всё директории что в них имеются
    private static void viewDir(String prefix, File root) {
        if (root.isFile()) { // если файл
            System.out.println(prefix + "File: " + root.getName());
        } else {
            System.out.println(prefix + "Dir " + root.getName()); // если не файл а папка
            for (File file : root.listFiles()) { // проходимся по всем файлам
                viewDir(prefix + "  ", file);
            }
        }
    }
}