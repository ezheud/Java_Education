package timus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class task1723 {

//Исходные данные
Единственная строка содержит универсальное заклинание, которое открыл Сандро. 
Заклинание — непустая строка из строчных латинских букв длиной не более 50.
Результат
Выведите любое из заклинаний, обладающих, по мнению Сандро, наибольшей силой

    public static void main(String[] args) throws IOException {
        String inputFileName = "timus_task/input.txt";
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
        try {
            BufferedReader bufferedReader =
                    oj ? new BufferedReader(new InputStreamReader(System.in)) :
                            new BufferedReader(new FileReader(inputFileName));
            String spell = bufferedReader.readLine();
            Map<String, Integer> substringCount = new HashMap<>();
            for (int i = 0; i < spell.length(); i++) {
                for (int j = i + 1; j <= spell.length(); j++) {
                    String substring = spell.substring(i, j);
                    substringCount.put(substring, substringCount.getOrDefault(substring, 0) + 1);
                }
            }
            String maxSubstring = "";
            int maxCount = 0;
            for (Map.Entry<String, Integer> entry : substringCount.entrySet()) {
                if (entry.getValue() > maxCount ||
                        (entry.getValue() == maxCount && entry.getKey().length() > maxSubstring.length())) {
                    maxCount = entry.getValue();
                    maxSubstring = entry.getKey();
                }
            }
            System.out.println(maxSubstring);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
