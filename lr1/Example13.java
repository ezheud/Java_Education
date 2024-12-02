package lr1;

import java.util.Scanner;
public class Example13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите 1 число : ");
        int firstnumber = sc.nextInt();
        System.out.print("Введите 2 число : ");
        int secondnumber = sc.nextInt();
        int sum = firstnumber + secondnumber;
        System.out.println( "Сумма двух чисел = " + sum);
        sc.close();
    }
}
