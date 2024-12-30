package lr3;

import java.util.Scanner;

public class Exampe3 {
    private static final int FIRST_NUMBER = 1;
    private static final int SECOND_NUMBER = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество чисел в последовательности: ");
        int count = scanner.nextInt();

        if (count >= 3) {
            System.out.println("Последовательность Фибоначчи (For): ");
            int[] fibonacciArrayFor = fillAndReturnFibonacciArrayForLoop(createFibonacciArray(count));
            printFibonacciArray(fibonacciArrayFor);

            System.out.println();

            System.out.println("Последовательность Фибоначчи (While): ");
            int[] fibonacciArrayWhile = fillAndReturnFibonacciArrayWhileLoop(createFibonacciArray(count));
            printFibonacciArray(fibonacciArrayWhile);

            System.out.println();

            System.out.println("Последовательность Фибоначчи (Do While): ");
            int[] fibonacciArrayDoWhile = fillAndReturnFibonacciArrayDoWhileLoop(createFibonacciArray(count));
            printFibonacciArray(fibonacciArrayDoWhile);
        } else {
            System.out.println("Количество чисел в последовательности, не может быть меньше 3.");
            System.out.println("Так как первые два числа в последовательности Фибоначчи уже заданы по условию задачи.");
        }
        scanner.close();
    }

    private static int[] createFibonacciArray(int count) {
        int[] fibonacciArray = new int[count];

        fibonacciArray[0] = FIRST_NUMBER;
        fibonacciArray[1] = SECOND_NUMBER;

        return fibonacciArray;
    }

    private static int[] fillAndReturnFibonacciArrayForLoop(int[] fibonacciArray) {
        for (int i = 2; i < fibonacciArray.length; i++) {
            fibonacciArray[i] = fibonacciArray[i - 1] + fibonacciArray[i - 2];
        }

        return fibonacciArray;
    }

    private static int[] fillAndReturnFibonacciArrayWhileLoop(int[] fibonacciArray) {
        int i = 2;

        while (i < fibonacciArray.length) {
            fibonacciArray[i] = fibonacciArray[i - 1] + fibonacciArray[i - 2];
            i++;
        }

        return fibonacciArray;
    }

    private static int[] fillAndReturnFibonacciArrayDoWhileLoop(int[] fibonacciArray) {
        int i = 2;

        do {
            fibonacciArray[i] = fibonacciArray[i - 1] + fibonacciArray[i - 2];
            i++;
        } while (i < fibonacciArray.length);

        return fibonacciArray;
    }

    private static void printFibonacciArray(int[] fibonacciArray) {
        for (int j : fibonacciArray) {
            System.out.print(j + " ");
        }
    }
}