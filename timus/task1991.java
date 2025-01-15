package timus;

import java.util.Scanner;

// программа считывает блоков дроидов и количество дроидов в каждом блоке, а также количество бум-бумов в каждой тележке.
// после этого она вычисляет, сколько бум-бумов останется неиспользованными и сколько дроидов выживет после атаки

public class task1991 {
      public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Считываем количество блоков (n) и количество дроидов в каждом блоке (k)
            System.out.print("Введите n и k: ");
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            // Создаем массив для хранения количества бум-бумов
            int[] bumbumCounts = new int[n];

            // Считываем количество бум-бумов в каждой тележке
            System.out.print("Введите количество бум-бумов в каждой тележке: ");
            for (int i = 0; i < n; i++) {
                bumbumCounts[i] = scanner.nextInt();
            }

            // Общее количество дроидов
            int totalDroids = n * k;

            // Общее количество бум-бумов
            int totalBumbums = 0;
            for (int count : bumbumCounts) {
                totalBumbums += count;
            }

            // Определяем количество неиспользованных бум-бумов и выживших дроидов
            int unusedBumbums;
            int survivingDroids;

            if (totalBumbums >= totalDroids) {
                // Все дроиды будут уничтожены
                unusedBumbums = totalBumbums - totalDroids;
                survivingDroids = 0;
            } else {
                // Часть дроидов останется в живых
                unusedBumbums = 0;
                survivingDroids = totalDroids - totalBumbums;
            }

            // Выводим результат
            System.out.println("Неиспользованные бум-бумы: " + unusedBumbums);
            System.out.println("Выжившие дроиды: " + survivingDroids);
        }
    }