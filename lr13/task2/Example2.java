package lr13.task2;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Example2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Ввод размеров матрицы
            System.out.print("Введите количество строк матрицы: ");
            int rows = scanner.nextInt();
            System.out.print("Введите количество столбцов матрицы: ");
            int cols = scanner.nextInt();

            if (rows <= 0 || cols <= 0) {
                throw new IllegalArgumentException("Размеры матрицы должны быть положительными");
            }

            int[][] matrix = new int[rows][cols];

            // Ввод элементов матрицы
            System.out.println("Введите элементы матрицы:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    try {
                        matrix[i][j] = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: введена строка вместо числа. Элемент будет заменен на 0.");
                        scanner.next(); // Очистка буфера
                        matrix[i][j] = 0;
                    }
                }
            }

            // Ввод номера столбца
            System.out.print("Введите номер столбца для вывода: ");
            int column = scanner.nextInt();

            // Проверка существования столбца
            if (column < 0 || column >= cols) {
                throw new ArrayIndexOutOfBoundsException("Столбец с таким номером не существует");
            }

            // Вывод столбца
            System.out.println("Столбец " + column + ":");
            for (int i = 0; i < rows; i++) {
                System.out.println(matrix[i][column]);
            }

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: введена строка вместо числа");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
