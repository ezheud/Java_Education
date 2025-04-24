package lr11;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Example2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Введите размер первого массива:");
        int size1 = in.nextInt();
        int[] arr1 = new int[size1];
        for (int i = 0; i < size1; i++) {
            arr1[i] = random.nextInt(10);
        }

        System.out.println("Введите размер второго массива:");
        int size2 = in.nextInt();
        int[] arr2 = new int[size2];
        for (int i = 0; i < size2; i++) {
            arr2[i] = random.nextInt(10);
        }

        System.out.println("Массив arr1: " + Arrays.toString(arr1));
        System.out.println("Массив arr2: " + Arrays.toString(arr2));

        int[] common = findCommonElements(arr1, arr2);
        System.out.println("Общие элементы: " + Arrays.toString(common));
    }

    public static int[] findCommonElements(int[] arr1, int[] arr2) {
        return Arrays.stream(arr1)
                .filter(x -> Arrays.stream(arr2).anyMatch(y -> y == x))
                .distinct()
                .toArray();
    }
}