package timus;

import java.util.*;
import java.text.DecimalFormat;

public class task1001 {
    //Для каждого числа Ai, начиная с последнего и заканчивая первым, в отдельной строке
    // вывести его квадратный корень не менее чем с четырьмя знаками после десятичной точки.
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            List<Long> numbers = new ArrayList<>();

            System.out.println("Введите числа. Нажмите Enter, затем Ctrl+D, чтобы завершить ввод:");

            // Считываем весь ввод, разделяя на пробелы и строки
            while (scanner.hasNext()) {
                if (scanner.hasNextLong()) {
                    numbers.add(scanner.nextLong());
                } else {
                    System.err.println("Ошибка: некорректный формат ввода.");
                    scanner.next(); // Пропускаем некорректное значение
                }
            }

            // Закрываем Scanner
            scanner.close();

            // Создаем формат для вывода
            DecimalFormat df = new DecimalFormat("0.0000");

            // Обрабатываем числа в обратном порядке
            for (int i = numbers.size() - 1; i >= 0; i--) {
                System.out.println(df.format(Math.sqrt(numbers.get(i))));
            }
        }
    }
