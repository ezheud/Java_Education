package lr6;

import java.util.Arrays;

public class Example7 {

    // Статический метод для преобразования символов в коды
    public static int[] convertCharsToCodes(char[] charArray) {
        // Создаем новый целочисленный массив такой же длины, как и исходный символьный массив
        int[] codesArray = new int[charArray.length];

        // Проходим по символьному массиву и заполняем целочисленный массив кодами символов
        for (int i = 0; i < charArray.length; i++) {
            codesArray[i] = (int) charArray[i]; // Получаем код символа и записываем в массив
        }

        return codesArray; // Возвращаем массив с кодами символов
    }

    public static void main(String[] args) {
        // Пример использования метода
        char[] characters = {'A', 'B', 'C', 'D', 'E'};

        // Получаем массив кодов символов
        int[] codes = convertCharsToCodes(characters);

        // Выводим полученные коды на экран
        System.out.println("Коды символов: ");
        for (int code : codes) {
            System.out.print(code + " "); // Выводим коды символов в строку
        }
    }
}