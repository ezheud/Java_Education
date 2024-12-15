package timus;

import java.util.Scanner;

public class task2056{

    // Программа помогает понять будет ли у студента стипендия

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество экзаменов: ");

        int n = scanner.nextInt(); // Число экзаменов
        int[] grades = new int[n]; // Массив оценок

        boolean hasThree = false; // Есть ли тройки
        boolean allFives = true; // Все ли пятерки
        int sum = 0; // Сумма оценок

        for (int i = 0; i < n; i++) {
            grades[i] = scanner.nextInt();
            if (grades[i] <= 3) {
                hasThree = true; // Если найдена тройка и ниже
            }
            if (grades[i] < 5) {
                allFives = false; // Если есть оценки меньше пятерки
            }
            sum += grades[i]; // Суммируем оценки
        }

        if (hasThree) {
            // Если есть тройки
            System.out.println("None");
        } else if (allFives) {
            // Если все пятерки
            System.out.println("Named");
        } else {
            // Если есть другие оценки, проверяем средний балл
            double average = (double) sum / n;
            if (average >= 4.5) {
                System.out.println("High");
            } else {
                System.out.println("Common");
            }
        }
    }
}
