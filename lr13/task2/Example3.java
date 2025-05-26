package lr13.task2;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Example3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Ввод размера массива
            System.out.print("Введите размер массива: ");
            int size = scanner.nextInt();

            if (size <= 0) {
                throw new IllegalArgumentException("Размер массива должен быть положительным");
            }

            byte[] array = new byte[size];
            byte sum = 0;

            // Ввод элементов массива
            System.out.println("Введите элементы массива (от -128 до 127):");
            for (int i = 0; i < size; i++) {
                try {
                    int input = scanner.nextInt();
                    if (input < Byte.MIN_VALUE || input > Byte.MAX_VALUE) {
                        throw new ArithmeticException("Введенное значение выходит за границы диапазона byte");
                    }
                    array[i] = (byte) input;
                    sum += array[i];
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка: введена строка вместо числа. Элемент будет заменен на 0.");
                    scanner.next(); // Очистка буфера
                } catch (ArithmeticException e) {
                    System.out.println("Ошибка: " + e.getMessage() + ". Элемент будет заменен на 0.");
                }
            }

            // Проверка переполнения суммы
            if ((sum > 0 && sum < 0) || (sum < 0 && sum > 0)) {
                throw new ArithmeticException("Переполнение при вычислении суммы");
            }

            System.out.println("Сумма элементов массива: " + sum);

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
