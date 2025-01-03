package lr3;

import java.util.Scanner;

public class Exampe6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер массива:");
        int size = getUserInputWithValidation(scanner);

        int[] array = new int[size];
        fillArray(array);
        printArray(array);

        scanner.close();
    }

    private static int getUserInputWithValidation(Scanner scanner) {
        int size;
        while (true) {
            try {
                size = scanner.nextInt();
                if (size > 0) {
                    return size;
                } else {
                    System.out.println("Размер массива не должен быть < 0. Введите корректное значение:");
                }
            } catch (Exception e) {
                System.out.println("Введите корректное значение:");
                scanner.next();
            }
        }
    }

    private static void fillArray(int[] array) {
        int index = 0;
        int arraySize = array.length;
        int amountOfNumbers = 0;
        for (int i = 0; amountOfNumbers < arraySize; i++) {
            if (i % 5 == 2) {
                array[index] = i;
                index += 1;
                amountOfNumbers += 1;
            }
        }
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}