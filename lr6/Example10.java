package lr6;

public class Example10 {

    // Статический метод для нахождения минимального и максимального значений
    public static int[] findMinMax(int... numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("Необходимо передать хотя бы одно целое число.");
        }

        int min = numbers[0]; // Инициализация минимального значения
        int max = numbers[0]; // Инициализация максимального значения

        // Проходим по всем элементам и находим минимальное и максимальное значения
        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
            if (number > max) {
                max = number;
            }
        }

        return new int[]{min, max}; // Возвращаем массив из двух элементов
    }

    public static void main(String[] args) {
        // Пример использования метода
        int[] result = findMinMax(11, 22, 4, 8, -4, 7, 4);

        System.out.println("Минимальное значение: " + result[0]);
        System.out.println("Максимальное значение: " + result[1]);
    }
}