package lr11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Example6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        System.out.println("Введите количество чисел:");
        int count = in.nextInt();

        for (int i = 0; i < count; i++) {
            System.out.println("Введите число " + (i+1) + ":");
            numbers.add(in.nextInt());
        }

        System.out.println("Введите делитель:");
        int divisor = in.nextInt();

        List<Integer> result = filterDivisibleNumbers(numbers, divisor);
        System.out.println("Числа, делящиеся на " + divisor + ": " + result);
    }

    public static List<Integer> filterDivisibleNumbers(List<Integer> numbers, int divisor) {
        return numbers.stream()
                .filter(n -> n % divisor == 0)
                .toList();
    }
}