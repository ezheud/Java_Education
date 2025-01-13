package lr4;

import java.util.Random;

public class Example6 {
    public static void main(String[] args) {
        int line = 22;                      // назначенное количество строк
        int cols = 22;                      // назначенное количество столбцов
        int[][] originalArray = new int[line][cols];
        Random random = new Random();

        for (int i = 0; i < line; i++) {
            for (int j = 0; j < cols; j++) {
                originalArray[i][j] = random.nextInt(100);
            }
        }

        System.out.println("Исходный массив:");
        printArray(originalArray);

        int rowIndexToRemove = random.nextInt(line);
        int colIndexToRemove = random.nextInt(cols);

        System.out.println();

        System.out.println("Удаление строки с индексом " + rowIndexToRemove);
        System.out.println("Удаление столбец с индексом " + colIndexToRemove);


        int[][] reducedArray = new int[line - 1][cols - 1];

        for (int i = 0, newI = 0; i < line; i++) {
            if (i == rowIndexToRemove) continue;
            for (int j = 0, newJ = 0; j < cols; j++) {
                if (j == colIndexToRemove) continue;
                reducedArray[newI][newJ] = originalArray[i][j];
                newJ++;
            }
            newI++;
        }

        System.out.println();

        System.out.println("Массив после удаления строки и столбца:");
        printArray(reducedArray);
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