package lr1;
import java.time.LocalDate;
import java.util.Scanner;
public class Example10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите ваш год рождения: ");
        int birthYear = sc.nextInt();
        int currentYear = LocalDate.now().getYear();
        int age = currentYear - birthYear;
        System.out.println("Ваш возраст: " + age + " лет.");
        sc.close();
    }
}
