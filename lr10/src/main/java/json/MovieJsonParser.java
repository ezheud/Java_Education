package json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Iterator;
import java.util.Scanner;

public class MovieJsonParser {
    private static final String FILE_PATH = "src/main/resources/movies.json";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            JSONObject jsonObject = readJsonFile();

            boolean running = true;
            while (running) {
                System.out.println("\nВыберите действие:");
                System.out.println("1. Добавить фильм");
                System.out.println("2. Найти фильмы по режиссеру");
                System.out.println("3. Удалить фильм");
                System.out.println("4. Показать все фильмы");
                System.out.println("5. Выход");
                System.out.print("> ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addMovie(jsonObject);
                        break;
                    case 2:
                        searchByDirector(jsonObject);
                        break;
                    case 3:
                        deleteMovie(jsonObject);
                        break;
                    case 4:
                        printAllMovies(jsonObject);
                        break;
                    case 5:
                        running = false;
                        break;
                    default:
                        System.out.println("Неверный выбор!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static JSONObject readJsonFile() throws IOException, ParseException {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            createInitialJsonFile(file);
        }

        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(file);
        return (JSONObject) parser.parse(reader);
    }

    private static void createInitialJsonFile(File file) throws IOException {
        JSONObject jsonObject = new JSONObject();
        JSONArray moviesArray = new JSONArray();

        JSONObject movie1 = new JSONObject();
        movie1.put("title", "Крестный отец");
        movie1.put("director", "Фрэнсис Форд Коппола");
        movie1.put("year", "1972");
        movie1.put("genre", "Криминал");
        moviesArray.add(movie1);

        JSONObject movie2 = new JSONObject();
        movie2.put("title", "Побег из Шоушенка");
        movie2.put("director", "Фрэнк Дарабонт");
        movie2.put("year", "1994");
        movie2.put("genre", "Драма");
        moviesArray.add(movie2);

        jsonObject.put("movies", moviesArray);

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(jsonObject.toJSONString());
            writer.flush();
        }
    }

    private static void addMovie(JSONObject jsonObject) throws IOException {
        System.out.print("Введите название фильма: ");
        String title = scanner.nextLine();

        System.out.print("Введите режиссера: ");
        String director = scanner.nextLine();

        System.out.print("Введите год выпуска: ");
        String year = scanner.nextLine();

        System.out.print("Введите жанр: ");
        String genre = scanner.nextLine();

        JSONObject newMovie = new JSONObject();
        newMovie.put("title", title);
        newMovie.put("director", director);
        newMovie.put("year", year);
        newMovie.put("genre", genre);

        JSONArray moviesArray = (JSONArray) jsonObject.get("movies");
        moviesArray.add(newMovie);

        saveJsonFile(jsonObject);
        System.out.println("Фильм успешно добавлен!");
    }

    private static void searchByDirector(JSONObject jsonObject) {
        System.out.print("Введите режиссера для поиска: ");
        String director = scanner.nextLine();

        JSONArray moviesArray = (JSONArray) jsonObject.get("movies");
        boolean found = false;

        for (Object obj : moviesArray) {
            JSONObject movie = (JSONObject) obj;
            String movieDirector = (String) movie.get("director");
            if (movieDirector.equalsIgnoreCase(director)) {
                printMovie(movie);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Фильмы не найдены!");
        }
    }

    private static void deleteMovie(JSONObject jsonObject) throws IOException {
        System.out.print("Введите название фильма для удаления: ");
        String title = scanner.nextLine();

        JSONArray moviesArray = (JSONArray) jsonObject.get("movies");
        Iterator iterator = moviesArray.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            JSONObject movie = (JSONObject) iterator.next();
            String movieTitle = (String) movie.get("title");
            if (movieTitle.equalsIgnoreCase(title)) {
                iterator.remove();
                found = true;
                break;
            }
        }

        if (found) {
            saveJsonFile(jsonObject);
            System.out.println("Фильм успешно удален!");
        } else {
            System.out.println("Фильм не найден!");
        }
    }

    private static void printAllMovies(JSONObject jsonObject) {
        JSONArray moviesArray = (JSONArray) jsonObject.get("movies");
        if (moviesArray.isEmpty()) {
            System.out.println("Список фильмов пуст!");
            return;
        }

        System.out.println("Список всех фильмов:");
        for (Object obj : moviesArray) {
            JSONObject movie = (JSONObject) obj;
            printMovie(movie);
        }
    }

    private static void printMovie(JSONObject movie) {
        String title = (String) movie.get("title");
        String director = (String) movie.get("director");
        String year = (String) movie.get("year");
        String genre = (String) movie.get("genre");

        System.out.println("\nФильм: " + title);
        System.out.println("Режиссер: " + director);
        System.out.println("Год выпуска: " + year);
        System.out.println("Жанр: " + genre);
    }

    private static void saveJsonFile(JSONObject jsonObject) throws IOException {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            writer.write(jsonObject.toJSONString());
            writer.flush();
        }
    }
}
