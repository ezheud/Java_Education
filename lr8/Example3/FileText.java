package lr8.Example3;

import java.io.*;
import java.util.*;

public class FileText {

    public static void main(String[] args) {
        String inputFilePath = "C:/Users/MinkajdarovSV/IdeaProjects/Java_Education/lr8/Example3/input.txt"; // Путь к исходному файлу
        String outputFilePath = "C:/Users/MinkajdarovSV/IdeaProjects/Java_Education/lr8/Example3/output.txt"; // Путь к результирующему файлу

        try {
            // Чтение данных из исходного файла
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));

            String line;
            int lineNumber = 0;

            // Множество согласных букв (строчные и заглавные)
            Set<Character> consonants = new HashSet<>(Arrays.asList(
                    'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
                    'Б', 'В', 'Г', 'Д', 'Ж', 'З', 'Й', 'К', 'Л', 'М', 'Н', 'П', 'Р', 'С', 'Т', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ'
            ));

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                String[] words = line.split("\\s+"); // Разделение строки на слова по пробелам
                List<String> consonantWords = new ArrayList<>();

                // Поиск слов, начинающихся с согласных букв
                for (String word : words) {
                    if (!word.isEmpty() && consonants.contains(word.charAt(0))) {
                        consonantWords.add(word);
                    }
                }

                // Запись результатов в файл
                if (!consonantWords.isEmpty()) {
                    writer.write("Строка " + lineNumber + ": ");
                    writer.write(String.join(" ", consonantWords));
                    writer.write(" (Найдено слов: " + consonantWords.size() + ")");
                    writer.newLine();
                }
            }

            reader.close();
            writer.close();
            System.out.println("Обработка завершена. Результат записан в файл " + outputFilePath);

        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлами: " + e.getMessage());
        }
    }
}
