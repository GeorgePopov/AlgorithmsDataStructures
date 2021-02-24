package lesson2_arraysSorting.teacherExample;

import lesson2_arraysSorting.Array;
import lesson2_arraysSorting.ArrayImpl;
import lesson2_arraysSorting.SortedArrayImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Крутейший пример!
 */
public class ConcurrencyMainDZ {
    private static final int ARRAY_CAPACITY = 10_000;
    private static final int MAX_VALUE = 10_000;

    public static void main(String[] args) throws InterruptedException {
//        Supplier<Array<Integer>> constructor = ArrayImpl::new;
        Supplier<Array<Integer>> constructor = SortedArrayImpl::new;

        /*
         интерфейс Array и классы ArrayImpl, SortedArrayImpl взяты из урока
         здесь мы создаём три новых пустых экземпляра класса
         */
        Array<Integer> arr1 = createArray(constructor);
        Array<Integer> arr2 = createArray(constructor);
        Array<Integer> arr3 = createArray(constructor);

//        Array<Integer> arr1 = new ArrayImpl<>(ARRAY_CAPACITY);
//        Array<Integer> arr2 = new ArrayImpl<>(ARRAY_CAPACITY);
//        Array<Integer> arr3 = new ArrayImpl<>(ARRAY_CAPACITY);

        randomInitialize(arr1, arr2, arr3);
//        randomInitialize(arr1);
//        Array<Integer> arr2 = arr1.copy();
//        Array<Integer> arr3 = arr1.copy();


        // Example 1 ----------
        /**
         создаём список Link с обобщением <Runnable>, и заполняем его тремя методами measureTime(), типа Runnable.
         ! так можно сделать три экземпляра класса, запустить у них какие-то методы и запустить их в разных потоках.
         */ // это последовательный вариант
        List<Runnable> tasks = List.of( // Link.of создаёт и формирует коллекцию одновременно
                // example 1
                measureTime(new Runnable() {
                    @Override
                    public void run() {
                        arr1.sortBubble(); // из нужного массива вызываем нужную сортировку
                    }
                }, "Sort Babble"),
                // example 2
                measureTime(() -> arr2.sortSelect(), "Sort Select"), // из нужного массива вызываем нужную сортировку
                // example 3
                measureTime(arr3::sortInsert, "Sort Insert") // из нужного массива вызываем нужную сортировку
        );

        // Example 2 ----------
        // паралельный вариант, передаём 3 потока, здесь формируется пул из 3 потоков
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // вызываем у эклемпляра интерфейса executorService метод execute, и передаём в него нашу сформулированную задачу
        tasks.forEach(executorService::execute);

//        tasks.forEach(command -> executorService.execute(command)); // без ::
        // без () -> {}
        /*
        tasks.forEach(new Consumer<Runnable>() {
            @Override
            public void accept(Runnable command) {
                executorService.execute(command);
            }
        });
        */

//        for (Runnable task : tasks) {
//            task.run();
//        }

        executorService.shutdown(); // shutdown() - закрываем наш пул потоков
        executorService.awaitTermination(1, TimeUnit.MINUTES); // таймаут, ожидаем завершение текущих задач не более чем минуту

//        System.out.println("bubble: " + Arrays.toString(arr1.toArray())); // toArray() не работает
//        System.out.println("bubble: " + Arrays.toString(arr1.toArray()));
//        System.out.println("bubble: " + Arrays.toString(arr1.toArray()));
    }

    // ! хороший пример, как заполнить три массива одинаковыми значениями
    private static void randomInitialize(Array<Integer>... arrays) {
        Random random = new Random();
        for (int i = 0; i < ARRAY_CAPACITY; i++) {
            int value = random.nextInt(MAX_VALUE); // !*!*! пример как генерить случайное число
            for (Array<Integer> array : arrays) {
                array.add(value);
            }
        }
    }

    /**
     под action мы здесь принимаем аргумент, который имеет тип Runnable, у Runnable есть
     метод run(), он ни чего не принимает и ни чего не возвращает, соответственно наши
     сортировки sortBubble, sortSelect, sortInsert описанные в нашем интерфейсе Array, так же
     ни чего не принимаю и не возвращают, и по сигнатуре подходят интерфейсу Runnable.
     По этому мы их можем передать таким образом arr1::sortBubble, как ссылки на методы sortBubble...
     */
    private static Runnable measureTime(Runnable action, String actionName) {
        return () -> {
            long startTime = System.nanoTime();
            action.run();
            long finishTime = System.nanoTime();
            long duration = finishTime - startTime;

            // ! Класс TimeUnit указывает из каких единиц мы хотим перевести в какие
            System.out.printf("%s took time: %d micros.%n", actionName, TimeUnit.NANOSECONDS.toMicros(duration));
        };

        // без () -> {}
        /*
        return new Runnable() {
            @Override
            public void run() {
                long startTime = System.nanoTime();
                action.run();
                long finishTime = System.nanoTime();
                long duration = finishTime - startTime;
                System.out.printf("%s took time: %d micros.%n", actionName, TimeUnit.NANOSECONDS.toMicros(duration));
            }
        };
        */
    }

    /**
    !*!*! на вход методу подаётся java-интерфейс Supplier, у которого есть один метод get(),
     он ни чего не принимает и возврящает объект определённого типа. Здесь мы маскируем вызов
     нашего конструктора - new ArrayImpl(). Это делается для того, что бы потом легко было
     переключиться с реализации - Supplier<Array<Integer>> constructor = ArrayImpl::new; на
     реализацию - Supplier<Array<Integer>> constructor = SortedArrayImpl::new;, автоматически
     отсортированного массива.
     */
    private static Array<Integer> createArray(Supplier<Array<Integer>> factory) {
        return factory.get(); // new ArrayImpl()
    }
}