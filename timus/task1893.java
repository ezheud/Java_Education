package timus;

import java.util.Scanner;

public class task1893 {
    // Программа определяет расположение места в самолете, по обозначению места в купленном билете

    public static String determineSeatLocation(String seatCode) {

        int row = Integer.parseInt(seatCode.substring(0, seatCode.length() - 1));
        char seat = seatCode.charAt(seatCode.length() - 1);

        // Проверяем верхнюю палубу
        if (row >= 1 && row <= 20) {
            if (row <= 2) { // Премиум класс
                if (seat == 'A' || seat == 'D') {
                    return "window"; // Иллюминатор
                } else if (seat == 'B' || seat == 'C') {
                    return "aisle"; // У прохода
                }
            } else { // Бизнес класс
                if (seat == 'A' || seat == 'F') {
                    return "window"; // Иллюминатор
                } else if (seat == 'C' || seat == 'D') {
                    return "aisle"; // У прохода
                }
            }
        }
        // Проверяем нижнюю палубу (эконом класс)
        else if (row >= 21 && row <= 65) {
            if (seat == 'A' || seat == 'K') {
                return "window";
            } else if (seat >= 'C' && seat <= 'D') {
                return "aisle";
            } else if (seat >= 'H' && seat <= 'J') {
                return "aisle";
            }
        }
        return "neither"; // Ни иллюминатор, ни проход
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите обозначение места (например, 12A): ");
        String seatCode = scanner.nextLine().trim().toUpperCase();

        String result = determineSeatLocation(seatCode);
        System.out.println(result);
    }
}
