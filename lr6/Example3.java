package lr6;

public class Example3 {
        // Метод для вычисления наибольшего значения
        public static int findMax(int... numbers) {
            if (numbers.length == 0) {
                throw new IllegalArgumentException("Нет чисел для нахождения максимума.");
            }
            int max = numbers[0];
            for (int number : numbers) {
                if (number > max) {
                    max = number;
                }
            }
            return max;
        }

        // Метод для вычисления наименьшего значения
        public static int findMin(int... numbers) {
            if (numbers.length == 0) {
                throw new IllegalArgumentException("Нет чисел для нахождения минимума.");
            }
            int min = numbers[0];
            for (int number : numbers) {
                if (number < min) {
                    min = number;
                }
            }
            return min;
        }

        // Метод для вычисления среднего значения
        public static double findAverage(int... numbers) {
            if (numbers.length == 0) {
                throw new IllegalArgumentException("Нет чисел для нахождения среднего значения.");
            }
            int sum = 0;
            for (int number : numbers) {
                sum += number;
            }
            return (double) sum / numbers.length;
        }

        public static void main(String[] args) {
            // Пример использования статических методов
            int[] values = {10, 20, 30, 40, 50};

            // Используем массив для нахождения статистики
            System.out.println("Max: " + findMax(values)); // Вывод: Max: 50
            System.out.println("Min: " + findMin(values)); // Вывод: Min: 10
            System.out.println("Average: " + findAverage(values)); // Вывод: Average: 30.0

            // Используем произвольное количество аргументов
            System.out.println("Max: " + findMax(5, 15, 25, 35, 45)); // Вывод: Max: 45
            System.out.println("Min: " + findMin(5, 15, 25, 35, 45)); // Вывод: Min: 5
            System.out.println("Average: " + findAverage(5, 15, 25, 35, 45)); // Вывод: Average: 25.0
        }
    }