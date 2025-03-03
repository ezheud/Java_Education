package lr9.Example3;

import java.util.Scanner;

public class example3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        int[] array = new int[size];

        System.out.println("Введите элементы массива:");
        inputArray(array, 0, scanner);

        System.out.println("Элементы массива:");
        outputArray(array, 0);

        scanner.close();
    }

    // Рекурсивный метод для ввода элементов массива
    public static void inputArray(int[] array, int index, Scanner scanner) {
        if (index < array.length) {
            System.out.print("Элемент " + (index + 1) + ": ");
            array[index] = scanner.nextInt();
            inputArray(array, index + 1, scanner);
        }
    }

    // Рекурсивный метод для вывода элементов массива
    public static void outputArray(int[] array, int index) {
        if (index < array.length) {
            System.out.println("Элемент " + (index + 1) + ": " + array[index]);
            outputArray(array, index + 1);
        }
    }
}
