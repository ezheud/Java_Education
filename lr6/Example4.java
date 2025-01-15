package lr6;

public class Example4 {

    // Статический метод для вычисления двойного факториала
    public static long doubleFactorial(int n) {
        // Проверка на отрицательные значения
        if (n < 0) {
            throw new IllegalArgumentException("Двойной факториал не определен для отрицательных чисел.");
        }

        long result = 1;

        // Вычисление двойного факториала через одно
        for (int i = n; i > 0; i -= 2) {
            result *= i;
        }

        return result; // Возврат результата
    }

    public static void main(String[] args) {
        // Примеры использования метода
        int n1 = 11;
        int n2 = 22;

        System.out.println(n1 + "!! = " + doubleFactorial(n1)); // 11!! = 10395
        System.out.println(n2 + "!! = " + doubleFactorial(n2)); // 22!! = 81749606400
    }
}