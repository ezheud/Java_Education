package lr3;

import java.util.Scanner;

public class Exampe4 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Первое число: ");
            int firstNumber = scanner.nextInt();

            System.out.print("Второе число: ");
            int secondNumber = scanner.nextInt();

            int minNumber = Math.min(firstNumber, secondNumber);
            int maxNumber = Math.max(firstNumber, secondNumber);

            System.out.println("Все целые числа (For): ");
            printNumbersWithForLoop(minNumber, maxNumber);
            System.out.println();

            System.out.println("Все целые числа (While): ");
            printNumbersWithWhileLoop(minNumber, maxNumber);
            System.out.println();

            System.out.println("Все целые числа (Do While): ");
            printNumbersWithDoWhileLoop(minNumber, maxNumber);

            scanner.close();
        }

        public static void printNumbersWithForLoop(int minNumber, int maxNumber) {
            for (int i = minNumber; i <= maxNumber; i++) {
                System.out.print(i + " ");
            }
        }

        public static void printNumbersWithWhileLoop(int minNumber, int maxNumber) {
            int i = minNumber;
            while (i <= maxNumber) {
                System.out.print(i + " ");
                i++;
            }
        }

        public static void printNumbersWithDoWhileLoop(int minNumber, int maxNumber) {
            int i = minNumber;
            do {
                System.out.print(i + " ");
                i++;
            } while (i <= maxNumber);
        }
    }