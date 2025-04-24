package lr11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Example3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> strings = new ArrayList<>();

        System.out.println("Введите количество строк:");
        int count = in.nextInt();
        in.nextLine(); // Очистка буфера

        for (int i = 0; i < count; i++) {
            System.out.println("Введите строку " + (i+1) + ":");
            strings.add(in.nextLine());
        }

        List<String> result = filterUppercaseStrings(strings);
        System.out.println("Строки с заглавной буквы: " + result);
    }

    public static List<String> filterUppercaseStrings(List<String> strings) {
        return strings.stream()
                .filter(s -> !s.isEmpty() && Character.isUpperCase(s.charAt(0)))
                .toList();
    }
}