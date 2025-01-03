package lr3;

import java.util.ArrayList;
import java.util.Scanner;

public class Exampe5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество чисел в сумме: ");
        int count = scanner.nextInt();

        ArrayList<Integer> sumFor = sumWithForLoop(count);
        ArrayList<Integer> sumWhile = sumWithWhileLoop(count);
        ArrayList<Integer> sumDoWhile = sumWithDoWhileLoop(count);

        System.out.println("Версия с циклом (for)");
        printNumbersAndSum(sumFor);
        System.out.println("Версия с циклом (while)");
        printNumbersAndSum(sumWhile);
        System.out.println("Сумма чисел (do-while)");
        printNumbersAndSum(sumDoWhile);

        scanner.close();
    }

    private static ArrayList<Integer> sumWithForLoop(int count) {
        ArrayList<Integer> numbers = new ArrayList<>();
        int amountOfNumbers = 0;
        for (int i = 0; amountOfNumbers < count; i++) {
            if (i % 5 == 2 || i % 3 == 1) {
                numbers.add(i);
                amountOfNumbers += 1;
            }
        }
        return numbers;
    }

    private static ArrayList<Integer> sumWithWhileLoop(int count) {
        ArrayList<Integer> numbers = new ArrayList<>();
        int amountOfNumbers = 0;
        int number = 0;
        while (amountOfNumbers < count) {
            if (number % 5 == 2 || number % 3 == 1) {
                numbers.add(number);
                amountOfNumbers += 1;
            }
            number += 1;
        }
        return numbers;
    }

    private static ArrayList<Integer> sumWithDoWhileLoop(int count) {
        ArrayList<Integer> numbers = new ArrayList<>();
        int amountOfNumbers = 0;
        int number = 0;
        do {
            if (number % 5 == 2 || number % 3 == 1) {
                numbers.add(number);
                amountOfNumbers += 1;
            }
            number += 1;
        } while (amountOfNumbers < count);
        return numbers;
    }

    private static void printNumbersAndSum(ArrayList<Integer> list) {
        int sum = 0;
        System.out.print("Числа: ");
        for (Integer number : list) {
            System.out.print(number + " ");
            sum += number;
        }
        System.out.println();
        System.out.println("Результат суммы чисел: " + sum);
    }
}