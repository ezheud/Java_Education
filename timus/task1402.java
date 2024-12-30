import java.util.Scanner;

public class task1402 {


    //Программа рассчитывает какое количество различных коктейлей может получится из определенного количества напитков


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество напитков (1 ≤ N ≤ 21) в командной строке: ");
        int N = scanner.nextInt();
        scanner.close();

        // Проверяем ограничения
        if (N < 1 || N > 21) {
            System.out.println("Ошибка: N должно быть в диапазоне от 1 до 21.");
            return;
        }

        long totalCocktails = 0;

        // Рассчитываем количество коктейлей для k от 2 до N
        for (int k = 2; k <= N; k++) {
            totalCocktails += permutations(N, k);
        }

        // Выводим итоговое количество коктейлей
        System.out.println( "Итоговое количество коктейлей: " +totalCocktails );
    }

    // Метод для расчета перестановок P(N, k)
    private static long permutations(int N, int k) {
        long result = 1;
        for (int i = 0; i < k; i++) {
            result *= (N - i);
        }
        return result;
    }
}