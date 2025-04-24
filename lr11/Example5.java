package lr11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Example5 {
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

        System.out.println("Введите подстроку для поиска:");
        String substring = in.nextLine();

        List<String> result = filterStringsContainingSubstring(strings, substring);
        System.out.println("Строки содержащие '" + substring + "': " + result);
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(s -> s.contains(substring))
                .toList();
    }
}