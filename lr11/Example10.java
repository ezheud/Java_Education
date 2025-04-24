package lr11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Example10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        System.out.println("Введите количество чисел:");
        int count = in.nextInt();

        for (int i = 0; i < count; i++) {
            System.out.println("Введите число " + (i+1) + ":");
            numbers.add(in.nextInt());
        }

        System.out.println("Введите пороговое значение:");
        int threshold = in.nextInt();

        List<Integer> result = filterNumbersBelowThreshold(numbers, threshold);
        System.out.println("Числа меньше " + threshold + ": " + result);
    }

    public static List<Integer> filterNumbersBelowThreshold(List<Integer> numbers, int threshold) {
        return numbers.stream()
                .filter(n -> n < threshold)
                .toList();
    }
}