package lr1;

import java.util.Scanner;
public class Example6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите вашу фамилию: ");
        String lastName = in.nextLine();
        System.out.println("Введите ваше имя: ");
        String firstName = in.nextLine();
        System.out.println("Введите ваше отчество: ");
        String patronymic = in.nextLine();
        System.out.println("Привет, дорогой друг! " + lastName + " " + firstName + " " +patronymic);
        in.close();
    }
}