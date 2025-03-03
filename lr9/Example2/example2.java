package lr9.Example2;

import java.util.Scanner;

public class example2 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите целое число: ");
            int number = scanner.nextInt();
            scanner.close();

            System.out.print("Двоичное представление: ");
            decimalToBinary(number);
        }

        public static void decimalToBinary(int n) {
            if (n > 1) {
                decimalToBinary(n / 2);
            }
            System.out.print(n % 2);
        }
    }