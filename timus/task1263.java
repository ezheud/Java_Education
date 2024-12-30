import java.util.Scanner;

public class task1263 {

    //Программа для подсчета голосов избирателей

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество кандидатов (N) и количество избирателей (M): ");

        int N = scanner.nextInt();
        if (N > 1 && N < 10000);
            else {
            System.out.println("Число " + N + " не соответствует условиям.");
            System.exit(1); // Завершение программы с ненормальным статусом
        }

        int M = scanner.nextInt();
        if (M > 1 && M < 10000) {}
        else {
            System.out.println("Число " + M + " не соответствует условиям.");
            System.exit(1); // Завершение программы с ненормальным статусом
        }

        int[] voteCounts = new int[N + 1];

        System.out.println("Введите номера кандидатов, за которых проголосовали избиратели:");
        for (int i = 0; i < M; i++) {
            int candidate = scanner.nextInt();
            if (candidate >= 1 && candidate <= N) {
                voteCounts[candidate]++;
            } else {
                System.out.println("Некорректный номер кандидата: " + candidate);
            }
        }
        System.out.println("Количество голосов за каждого кандидата:");
        for (int i = 1; i <= N; i++) {
            System.out.println("Кандидат " + i + ": " + voteCounts[i] + " голосов");
        }
        for (int i = 1; i <= N; i++) {
            double percentage = (M > 0) ? (voteCounts[i] / (double) M) * 100 : 0;
            System.out.printf("%.2f%n", percentage);
        }
        scanner.close();
    }
}
