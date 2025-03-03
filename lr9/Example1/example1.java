package lr9.Example1;

public class example1 {
    // Пример 1: Последовательность значений элементов числового ряда
    public class Recursion1 {
        public static void m(int x) {
            System.out.println("x=" + x);
            if ((2 * x + 1) < 20) {
                m(2 * x + 1);
            }
        }

        public static void main(String[] args) {
            m(1);
        }
    }

    // Пример 2: Последовательность в обратном порядке
    public class Recursion2 {
        public static void m(int x) {
            if ((2 * x + 1) < 20) {
                m(2 * x + 1);
            }
            System.out.println("x=" + x);
        }

        public static void main(String[] args) {
            m(1);
        }
    }

    // Пример 3: Вывод параметра перед и после рекурсивного вызова
    public class Recursion3 {
        private static int step = 0;

        public static void m(int x) {
            space();
            System.out.println("" + x + "-> ");
            step++;
            if ((2 * x + 1) < 20) {
                m(2 * x + 1);
            }
            step--;
            space();
            System.out.println("" + x + " <-");
        }

        public static void space() {
            for (int i = 0; i < step; i++) {
                System.out.print(" ");
            }
        }

        public static void main(String[] args) {
            m(1);
        }
    }

    // Пример 4: Вычисление факториала числа с использованием рекурсии
    public class Recursion4 {
        public static int factorial(int n) {
            if (n == 0 || n == 1) {
                return 1;
            }
            return n * factorial(n - 1);
        }
    }

    // Пример 5: Вычисление числа Фибоначчи и вывод последовательности вызовов
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        System.out.println("Calculating Fibonacci(" + n + ")");
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println("Пример 5:");
        int fibN = 6;
        System.out.println("Число Фибоначчи под номером " + fibN + " = " + fibonacci(fibN));
    }
}