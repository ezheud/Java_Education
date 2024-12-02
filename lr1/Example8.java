package lr1;

import java.util.Scanner;
public class Example8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите название текущего дня недели: ");
        String dayOfWeek = sc.nextLine();
        System.out.print("Введите название месяца: ");
        String month = sc.nextLine();
        System.out.print("Введите дату (номер дня в месяце): ");
        int date = sc.nextInt();
        System.out.println("Сегодня: " + dayOfWeek + ", " + date + " " + month);
        sc.close();
    }
}
