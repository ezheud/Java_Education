package lr9.Example6;

import java.util.HashMap;
import java.util.Map;

public class example6 {
    public static void main(String[] args) {
        // Создаем и заполняем HashMap
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");

        // Находим строки, у которых ключ > 5
        System.out.println("Строки с ключом > 5:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() > 5) {
                System.out.println(entry.getValue());
            }
        }

        // Если ключ = 0, выводим строки через запятую
        if (map.containsKey(0)) {
            System.out.println("Строки с ключом 0: " + String.join(", ", map.values()));
        } else {
            System.out.println("Ключ 0 отсутствует в HashMap.");
        }

        // Перемножаем все ключи, где длина строки > 5
        long product = 1;
        boolean found = false;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().length() > 5) {
                product *= entry.getKey();
                found = true;
            }
        }

        if (found) {
            System.out.println("Произведение ключей, где длина строки > 5: " + product);
        } else {
            System.out.println("Нет строк с длиной > 5.");
        }
    }
}