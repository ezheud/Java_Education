package lr6;

public class Example8 {

    // Статический метод для вычисления среднего значения элементов массива
    public static double calculateAverage(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Массив не должен быть пустым.");
        }

        int sum = 0; // Переменная для хранения суммы элементов

        // Суммируем все элементы массива
        for (int number : array) {
            sum += number;
        }

        // Возвращаем среднее значение
        return (double) sum / array.length; // Приведение к double для точности
    }

    public static void main(String[] args) {
        // Пример использования метода
        int[] numbers = {11, 22, 33, 44, 55};

        // Вычисляем среднее значение
        double average = calculateAverage(numbers);

        // Выводим среднее значение на экран
        System.out.println("Среднее значение: " + average); // Вывод: 33
    }
}