package lr3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Example10 {
    public static void main(String[] args) {
        int size = 10;
        int[] array = new int[size];
        int bound = 100;

        fillArrayWithRandomNumbers(array, bound);
        System.out.println("Массив:");
        printArray(array);
        System.out.println();

        array = sortArrayByDescending(array);
        System.out.println("Массив после сортировки в порядке убывания:");
        printArray(array);
        System.out.println();
    }

    private static void fillArrayWithRandomNumbers(int[] array, int bound) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(bound);
        }
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private static int[] sortArrayByDescending(int[] array) {
        Arrays.sort(array);
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.stream(array).boxed().toList());
        Collections.reverse(list);
        return list.stream().mapToInt(i -> i).toArray();
    }
}