package lr8.task_2;

import java.io.*;
import java.util.Scanner;

public class FileFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запрос пути к исходному файлу
        System.out.print("Введите путь к исходному файлу: ");
        String inputFile = scanner.nextLine();

        // Определяем директорию исходного файла
        File input = new File(inputFile);
        String parentDir = input.getParent(); // Получаем папку, где лежит исходный файл

        // Формируем путь для результирующего файла
        String outputFile = parentDir + File.separator + "output.txt";

        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            // Открываем поток для чтения из исходного файла (UTF-8)
            br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(inputFile), "UTF-8"));

            // Открываем поток для записи в результирующий файл (UTF-8)
            bw = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(outputFile), "UTF-8"));

            System.out.println("Результирующий файл будет создан по пути: " + outputFile);

            // В исходном файле содержится две строки — пропускаем первую строку
            br.readLine();

            // Переписываем вторую строку в результирующий файл
            String secondLine = br.readLine();
            if (secondLine != null) {
                bw.write(secondLine);
                bw.newLine();
            }

            // В исходном файле содержится 5 чисел типа double — читаем их
            for (int i = 0; i < 5; i++) {
                String numberStr = br.readLine();
                if (numberStr != null) {
                    try {
                        double number = Double.parseDouble(numberStr);

                        // В результирующий файл переписываем только положительные числа
                        if (number > 0) {
                            bw.write(String.valueOf(number));
                            bw.newLine();
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка обработки числа: " + numberStr);
                    }
                }
            }
            System.out.println("Обработка завершена! Данные записаны в " + outputFile);
        } catch (IOException e) {
            System.out.println("Ошибка работы с файлами: " + e);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                System.out.println("Ошибка закрытия файлов: " + e);
            }
        }
    }
}