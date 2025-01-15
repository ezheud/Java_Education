package timus;

import java.util.Scanner;

//программа, которая решает задачу о том, сколько лет останется жить венерианскому
//гномику в зависимости от его начального количества золота, порога, при котором жизнь
//теряет смысл, и комиссии Центрального Галактического Банка.

public class task1283 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Считываем входные данные
            System.out.print("Введите начальное количество золота, порог и комиссию: ");
            long initialGold = scanner.nextLong();
            long threshold = scanner.nextLong();
            double commissionPercent = scanner.nextDouble();

            // Переменные
            long currentGold = initialGold;
            int years = 0;

            // Вычисление оставшихся лет
            while (currentGold > threshold) {
                long commission = (long) (currentGold * (commissionPercent / 100));
                currentGold -= commission; // Уменьшаем золото на комиссию
                years++;
            }

            // Вывод результата
            System.out.println("Осталось лет жить гномику: " + years);
        }
    }