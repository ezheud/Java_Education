package lr6;

public class Example5 {

    // Статический метод для вычисления суммы квадратов натуральных чисел
    public static long sumOfSquares(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Число n должно быть натуральным (n >= 1).");
        }

        long sum = 0;

        // Вычисление суммы квадратов
        for (int i = 1; i <= n; i++) {
            sum += i * i;
        }

        return sum;
    }

    // Формула для проверки, сумма квадратов
    public static long formulaSumOfSquares(int n) {
        return (long) (n * (n + 1) * (2 * n + 1)) / 6;
    }

    public static void main(String[] args) {
        int n = 5; // Пример использования, можно изменить это значение

        long computedSum = sumOfSquares(n);
        long formulaSum = formulaSumOfSquares(n);

        System.out.println("Сумма квадратов до " + n + " = " + computedSum);
        System.out.println("Проверка по формуле: сумма квадратов до " + n + " = " + formulaSum);

        // Проверка правильности
        if (computedSum == formulaSum) {
            System.out.println("Результаты совпадают.");
        } else {
            System.out.println("Результаты не совпадают.");
        }
    }
}
