package lr11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Example9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> strings = new ArrayList<>();

        System.out.println("Введите количество строк:");
        int count = in.nextInt();
        in.nextLine();

        for (int i = 0; i < count; i++) {
            System.out.println("Введите строку " + (i+1) + ":");
            strings.add(in.nextLine());
        }

        List<String> result = filterLettersOnly(strings);
        System.out.println("Строки только с буквами: " + result);
    }

    public static List<String> filterLettersOnly(List<String> strings) {
        return strings.stream()
                .filter(s -> s.matches("[a-zA-Zа-яА-Я]+"))
                .toList();
    }
}