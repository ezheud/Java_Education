package timus;

import java.util.Scanner;

public class task1409 {
    //В единственной строке записано 2 числа — количество банок, простреленных Гарри и Ларри соответственно
    // Выведите 2 числа — количество банок, не простреленных Гарри и Ларри соответственно.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод количества банок, простреленных Гарри и Ларри
        System.out.print("Введите количество банок, простреленных Гарри и Ларри через пробел: ");
        int G = scanner.nextInt();
        int L = scanner.nextInt();

        // Общее количество банок
        int N = G + L - 1;

        // Количество банок, не простреленных Гарри и Ларри
        int unshot_G = N - G;
        int unshot_L = N - L;

        // Вывод результата
        System.out.println(unshot_G + " " + unshot_L);

        scanner.close();
    }
}