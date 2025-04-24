package lr11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Example4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        System.out.println("Введите количество чисел:");
        int count = in.nextInt();

        for (int i = 0; i < count; i++) {
            System.out.println("Введите число " + (i+1) + ":");
            numbers.add(in.nextInt());
        }

        List<Integer> squares = squareNumbers(numbers);
        System.out.println("Квадраты чисел: " + squares);
    }

    public static List<Integer> squareNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(x -> x * x)
                .toList();
    }
}