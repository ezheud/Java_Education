package html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NewsParser {
    // Константы для настройки
    private static final String URL = "https://www.film.ru/topic/news";
    private static final String OUTPUT_FILE = "news_data.txt";
    private static final int MAX_RETRIES = 3;
    private static final int TIMEOUT_MS = 5000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("HTML парсер новостей с сайта " + URL);

        try {
            // Пытаемся получить и обработать новости
            Document doc = connectWithRetry();
            Elements newsElements = doc.select(".block"); // CSS селектор для новостей

            if (newsElements.isEmpty()) {
                System.out.println("На странице не найдено новостей.");
                return;
            }

            // Выводим новости в консоль и записываем в файл
            System.out.println("\nНайдено новостей: " + newsElements.size());
            writeNewsToFile(newsElements);
            System.out.println("\nДанные успешно сохранены в файл: " + OUTPUT_FILE);

        } catch (IOException e) {
            System.err.println("Ошибка при обработке страницы: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static Document connectWithRetry() throws IOException {
        int attempts = 0;
        IOException lastException = null;

        while (attempts < MAX_RETRIES) {
            try {
                System.out.printf("Попытка подключения #%d...\n", attempts + 1);
                return Jsoup.connect(URL)
                        .userAgent("Mozilla/5.0")
                        .timeout(TIMEOUT_MS)
                        .get();
            } catch (IOException e) {
                lastException = e;
                attempts++;
                System.err.printf("Ошибка подключения (попытка %d из %d): %s\n",
                        attempts, MAX_RETRIES, e.getMessage());

                if (attempts < MAX_RETRIES) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        throw new IOException("Не удалось подключиться после " + MAX_RETRIES + " попыток", lastException);
    }

    private static void writeNewsToFile(Elements newsElements) throws IOException {
        try (FileWriter writer = new FileWriter(OUTPUT_FILE)) {
            writer.write("Новости с сайта: " + URL + "\n\n");

            for (Element news : newsElements) {
                // Извлекаем тему новости (первый элемент с классом .blocktitle)
                String title = news.select(".blocktitle").first().text();

                // Извлекаем дату новости (первый элемент с классом .blockdate)
                String date = news.select(".blockdate").first().text();

                // Формируем строку с информацией о новости
                String newsEntry = String.format("Тема: %s\nДата: %s\n\n", title, date);

                // Выводим в консоль
                System.out.print(newsEntry);

                // Записываем в файл
                writer.write(newsEntry);
            }
        }
    }
}