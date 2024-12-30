package lr2;

import java.util.Scanner;

public class Example3 {

    // Напишите программу, которая проверяет, удовлетворяет ли введенное
    // пользователем число следующим критериям: число делится на 4, и при
    // этом оно не меньше 10

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число:");
        int number = scanner.nextInt();

        if (number % 4 == 0 && number >= 10) {
            System.out.println("Число удовлетворяет критериям.");
        } else {
            System.out.println("Число не удовлетворяет критериям.");
        }
        scanner.close();
    }
}