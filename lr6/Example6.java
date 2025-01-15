package lr6;

import java.util.Arrays;

public class Example6 {

    // Статический метод, который возвращает новый массив
    public static int[] getInitialElements(int[] originalArray, int count) {
        // Проверяем, если count больше длины originalArray
        if (count > originalArray.length) {
            // Возвращаем копию оригинального массива
            return Arrays.copyOf(originalArray, originalArray.length);
        }
        // Возвращаем новый массив, состоящий из первых count элементов
        return Arrays.copyOf(originalArray, count);
    }

    public static void main(String[] args) {
        // Пример использования метода
        int[] numbers = {10, 20, 30, 40, 50};

        // Взять 3 элемента
        int[] result1 = getInitialElements(numbers, 3);
        System.out.println("Первый результат: " + Arrays.toString(result1)); // Вывод: [10, 20, 30]

        // Взять 10 элементов (больше чем длина массива)
        int[] result2 = getInitialElements(numbers, 10);
        System.out.println("Второй результат: " + Arrays.toString(result2)); // Вывод: [10, 20, 30, 40, 50]
    }
}
