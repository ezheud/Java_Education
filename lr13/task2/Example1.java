package lr13.task2;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Example1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Ввод размера массива
            System.out.print("Введите размер массива: ");
            int size = scanner.nextInt();

            if (size <= 0) {
                throw new IllegalArgumentException("Размер массива должен быть положительным");
            }

            int[] array = new int[size];
            int sum = 0;
            int count = 0;

            // Ввод элементов массива
            System.out.println("Введите элементы массива:");
            for (int i = 0; i < size; i++) {
                try {
                    array[i] = scanner.nextInt();
                    if (array[i] > 0) {
                        sum += array[i];
                        count++;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка: введена строка вместо числа. Элемент будет пропущен.");
                    scanner.next(); // Очистка буфера
                }
            }

            // Проверка наличия положительных элементов
            if (count == 0) {
                throw new ArithmeticException("В массиве нет положительных элементов");
            }

            // Вычисление среднего значения
            double average = (double) sum / count;
            System.out.println("Среднее значение положительных элементов: " + average);

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: введена строка вместо числа для размера массива");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
