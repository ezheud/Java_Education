package timus;

import java.util.Scanner;

public class task1787 {
    //Выведите количество машин, стоящих в пробке на повороте через n минут после начала наблюдений.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Проверка, были ли переданы аргументы командной строки
        if (args.length > 0) {
            // Если аргументы переданы, парсим их
            int k = Integer.parseInt(args[0]);
            int n = Integer.parseInt(args[1]);
            int[] cars = new int[n];

            for (int i = 0; i < n; i++) {
                cars[i] = Integer.parseInt(args[i + 2]);
            }

            // Вычисление количества машин в пробке
            int jamCount = calculateJamCount(k, n, cars);
            System.out.println(jamCount);
        } else {
            // Если аргументы не переданы, запрашиваем ввод у пользователя
            System.out.println("Введите количество машин, которые могут повернуть за минуту и количество минут наблюдения:");
            int k = scanner.nextInt();
            int n = scanner.nextInt();

            int[] cars = new int[n];
            System.out.println("Введите количество машин, подъехавших к повороту за каждую минуту:");
            for (int i = 0; i < n; i++) {
                cars[i] = scanner.nextInt();
            }

            // Вычисление количества машин в пробке
            int jamCount = calculateJamCount(k, n, cars);
            System.out.println(jamCount);
        }

        scanner.close();
    }

    private static int calculateJamCount(int k, int n, int[] cars) {
        int jamCount = 0;

        for (int i = 0; i < n; i++) {
            jamCount += cars[i]; // Добавляем количество машин, подъехавших за текущую минуту
            jamCount -= k; // Учитываем количество машин, которые смогли повернуть
            if (jamCount < 0) {
                jamCount = 0; // Если машин в пробке меньше 0, устанавливаем 0
            }
        }

        return jamCount;
    }
}