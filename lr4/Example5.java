package lr4;

import java.util.Random;

public class Example5 {
    public static void main(String[] args) {
        int line = 22;                   // назначенное количество строк
        int cols = 22;                   // назначенное количество столбцов

        int[][] originalArray = new int[line][cols];
        Random random = new Random();
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < cols; j++) {
                originalArray[i][j] = random.nextInt(100);
            }
        }

        System.out.println("Исходный массив:");
        printArray(originalArray);

        System.out.println();

        int[][] changedArray = new int[cols][line];
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < cols; j++) {
                changedArray[j][i] = originalArray[i][j];
            }
        }

        System.out.println("Измененный массив:");
        printArray(changedArray);
    }

    public static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int value : row) {
                System.out.printf("%3d ", value);
            }
            System.out.println();
        }
    }
}