package xml;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieXmlParser {
    private static final String FILE_PATH = "src/main/resources/movies.xml";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document;

            File file = new File(FILE_PATH);
            if (!file.exists()) {
                createInitialXmlFile(file);
                document = builder.parse(file);
            } else {
                document = builder.parse(file);
            }

            boolean running = true;
            while (running) {
                System.out.println("\nВыберите действие:");
                System.out.println("1. Добавить фильм");
                System.out.println("2. Найти фильмы по режиссеру");
                System.out.println("3. Найти фильмы по году выпуска");
                System.out.println("4. Удалить фильм");
                System.out.println("5. Показать все фильмы");
                System.out.println("6. Выход");
                System.out.print("> ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addMovie(document);
                        break;
                    case 2:
                        searchByDirector(document);
                        break;
                    case 3:
                        searchByYear(document);
                        break;
                    case 4:
                        deleteMovie(document);
                        break;
                    case 5:
                        printAllMovies(document);
                        break;
                    case 6:
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

    private static void createInitialXmlFile(File file) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element rootElement = document.createElement("movies");
        document.appendChild(rootElement);

        saveDocument(document, file);
    }

    private static void addMovie(Document document) throws Exception {
        System.out.print("Введите название фильма: ");
        String title = scanner.nextLine();

        System.out.print("Введите режиссера: ");
        String director = scanner.nextLine();

        System.out.print("Введите год выпуска: ");
        String year = scanner.nextLine();

        System.out.print("Введите жанр: ");
        String genre = scanner.nextLine();

        Element movieElement = document.createElement("movie");

        Element titleElement = document.createElement("title");
        titleElement.appendChild(document.createTextNode(title));
        movieElement.appendChild(titleElement);

        Element directorElement = document.createElement("director");
        directorElement.appendChild(document.createTextNode(director));
        movieElement.appendChild(directorElement);

        Element yearElement = document.createElement("year");
        yearElement.appendChild(document.createTextNode(year));
        movieElement.appendChild(yearElement);

        Element genreElement = document.createElement("genre");
        genreElement.appendChild(document.createTextNode(genre));
        movieElement.appendChild(genreElement);

        document.getDocumentElement().appendChild(movieElement);

        saveDocument(document, new File(FILE_PATH));
        System.out.println("Фильм успешно добавлен!");
    }

    private static void searchByDirector(Document document) {
        System.out.print("Введите режиссера для поиска: ");
        String director = scanner.nextLine();

        NodeList movieList = document.getElementsByTagName("movie");
        List<Element> movies = new ArrayList<>();

        for (int i = 0; i < movieList.getLength(); i++) {
            Element movie = (Element) movieList.item(i);
            String movieDirector = movie.getElementsByTagName("director").item(0).getTextContent();
            if (movieDirector.equalsIgnoreCase(director)) {
                movies.add(movie);
            }
        }

        if (movies.isEmpty()) {
            System.out.println("Фильмы не найдены!");
        } else {
            System.out.println("Найденные фильмы:");
            movies.forEach(MovieXmlParser::printMovie);
        }
    }

    private static void searchByYear(Document document) {
        System.out.print("Введите год выпуска для поиска: ");
        String year = scanner.nextLine();

        NodeList movieList = document.getElementsByTagName("movie");
        List<Element> movies = new ArrayList<>();

        for (int i = 0; i < movieList.getLength(); i++) {
            Element movie = (Element) movieList.item(i);
            String movieYear = movie.getElementsByTagName("year").item(0).getTextContent();
            if (movieYear.equals(year)) {
                movies.add(movie);
            }
        }

        if (movies.isEmpty()) {
            System.out.println("Фильмы не найдены!");
        } else {
            System.out.println("Найденные фильмы:");
            movies.forEach(MovieXmlParser::printMovie);
        }
    }

    private static void deleteMovie(Document document) throws Exception {
        System.out.print("Введите название фильма для удаления: ");
        String title = scanner.nextLine();

        NodeList movieList = document.getElementsByTagName("movie");
        boolean found = false;

        for (int i = 0; i < movieList.getLength(); i++) {
            Element movie = (Element) movieList.item(i);
            String movieTitle = movie.getElementsByTagName("title").item(0).getTextContent();
            if (movieTitle.equalsIgnoreCase(title)) {
                movie.getParentNode().removeChild(movie);
                found = true;
                break;
            }
        }

        if (found) {
            saveDocument(document, new File(FILE_PATH));
            System.out.println("Фильм успешно удален!");
        } else {
            System.out.println("Фильм не найден!");
        }
    }

    private static void printAllMovies(Document document) {
        NodeList movieList = document.getElementsByTagName("movie");
        if (movieList.getLength() == 0) {
            System.out.println("Список фильмов пуст!");
            return;
        }

        System.out.println("Список всех фильмов:");
        for (int i = 0; i < movieList.getLength(); i++) {
            Element movie = (Element) movieList.item(i);
            printMovie(movie);
        }
    }

    private static void printMovie(Element movie) {
        String title = movie.getElementsByTagName("title").item(0).getTextContent();
        String director = movie.getElementsByTagName("director").item(0).getTextContent();
        String year = movie.getElementsByTagName("year").item(0).getTextContent();
        String genre = movie.getElementsByTagName("genre").item(0).getTextContent();

        System.out.println("\nФильм: " + title);
        System.out.println("Режиссер: " + director);
        System.out.println("Год выпуска: " + year);
        System.out.println("Жанр: " + genre);
    }

    private static void saveDocument(Document document, File file) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(file);
        transformer.transform(source, result);
    }
}