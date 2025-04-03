package excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Scanner;

public class MovieExcelParser {
    private static final String FILE_PATH = "src/main/resources/movies.xlsx";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            boolean running = true;
            while (running) {
                System.out.println("\nВыберите действие:");
                System.out.println("1. Создать новый файл Excel с фильмами");
                System.out.println("2. Добавить фильм в существующий файл");
                System.out.println("3. Просмотреть все фильмы");
                System.out.println("4. Поиск фильмов по режиссеру");
                System.out.println("5. Выход");
                System.out.print("> ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        createExcelFile();
                        break;
                    case 2:
                        addMovieToExcel();
                        break;
                    case 3:
                        readExcelFile(false, null);
                        break;
                    case 4:
                        searchByDirector();
                        break;
                    case 5:
                        running = false;
                        break;
                    default:
                        System.out.println("Неверный выбор!");
                }
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
            System.out.println("Рекомендация: проверьте путь к файлу и его формат.");
            e.printStackTrace();
        }
    }

    private static void createExcelFile() throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Фильмы");

        // Создание заголовков
        Row headerRow = sheet.createRow(0);
        String[] headers = {"Название", "Режиссер", "Год", "Жанр", "Рейтинг"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        // Добавление начальных данных
        addMovieToSheet(sheet, "Крестный отец", "Фрэнсис Форд Коппола", "1972", "Криминал", "9.2");
        addMovieToSheet(sheet, "Побег из Шоушенка", "Фрэнк Дарабонт", "1994", "Драма", "9.3");

        // Автонастройка ширины столбцов
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Сохранение файла
        try (FileOutputStream outputStream = new FileOutputStream(FILE_PATH)) {
            workbook.write(outputStream);
        }
        workbook.close();

        System.out.println("Файл Excel успешно создан: " + FILE_PATH);
    }

    private static void addMovieToExcel() throws IOException {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("Файл не существует. Сначала создайте файл (опция 1).");
            return;
        }

        System.out.print("Введите название фильма: ");
        String title = scanner.nextLine();

        System.out.print("Введите режиссера: ");
        String director = scanner.nextLine();

        System.out.print("Введите год выпуска: ");
        String year = scanner.nextLine();

        System.out.print("Введите жанр: ");
        String genre = scanner.nextLine();

        System.out.print("Введите рейтинг: ");
        String rating = scanner.nextLine();

        try (FileInputStream inputStream = new FileInputStream(file)) {
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);

            int lastRowNum = sheet.getLastRowNum();
            addMovieToSheet(sheet, title, director, year, genre, rating);

            // Автонастройка ширины столбцов
            for (int i = 0; i < 5; i++) {
                sheet.autoSizeColumn(i);
            }

            try (FileOutputStream outputStream = new FileOutputStream(FILE_PATH)) {
                workbook.write(outputStream);
            }
            workbook.close();
        }

        System.out.println("Фильм успешно добавлен в файл Excel!");
    }

    private static void addMovieToSheet(Sheet sheet, String title, String director, String year, String genre, String rating) {
        int lastRowNum = sheet.getLastRowNum();
        Row row = sheet.createRow(lastRowNum + 1);

        row.createCell(0).setCellValue(title);
        row.createCell(1).setCellValue(director);
        row.createCell(2).setCellValue(year);
        row.createCell(3).setCellValue(genre);
        row.createCell(4).setCellValue(rating);
    }

    private static void readExcelFile(boolean filterByDirector, String director) throws IOException {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("Файл не существует. Сначала создайте файл (опция 1).");
            return;
        }

        try (FileInputStream inputStream = new FileInputStream(file)) {
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);

            System.out.println("\nСписок фильмов:");
            System.out.println("------------------------------------------------------------");
            System.out.printf("%-30s %-25s %-6s %-15s %-5s%n",
                    "Название", "Режиссер", "Год", "Жанр", "Рейтинг");
            System.out.println("------------------------------------------------------------");

            boolean found = false;
            for (Row row : sheet) {
                // Пропускаем заголовок
                if (row.getRowNum() == 0) continue;

                String currentDirector = row.getCell(1).getStringCellValue();
                if (filterByDirector && !currentDirector.equalsIgnoreCase(director)) {
                    continue;
                }

                found = true;
                String title = row.getCell(0).getStringCellValue();
                String year = row.getCell(2).getStringCellValue();
                String genre = row.getCell(3).getStringCellValue();
                String rating = row.getCell(4).getStringCellValue();

                System.out.printf("%-30s %-25s %-6s %-15s %-5s%n",
                        title, currentDirector, year, genre, rating);
            }

            if (filterByDirector && !found) {
                System.out.println("Фильмы данного режиссера не найдены!");
            }

            workbook.close();
        }
    }

    private static void searchByDirector() throws IOException {
        System.out.print("Введите режиссера для поиска: ");
        String director = scanner.nextLine();
        readExcelFile(true, director);
    }
}