package lr1;

import java.util.Scanner;
public class Example14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число : ");
        int number = sc.nextInt();
        int fnumber = number - 1;
        int snumber = number + 1;
        int sum = snumber + number + fnumber;
        int squareOfSum = sum * sum;
        System.out.println("Последовательность чисел:");
        System.out.println(fnumber);
        System.out.println(number);
        System.out.println(snumber);
        System.out.println("Квадрат суммы первых трех чисел: " + squareOfSum);
        sc.close();
    }
}