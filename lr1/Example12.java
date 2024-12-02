package lr1;

import java.time.LocalDate;
import java.util.Scanner;
public class Example12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите ваш возраст: ");
        int age = sc.nextInt();
        int currentYear = LocalDate.now().getYear();
        int birthday = currentYear - age;
        System.out.println("Вы родились в " + birthday + " году.");
        sc.close();
    }
}
