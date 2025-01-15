package lr4;

import java.util.Scanner;

public class Example8 {

    // Пользовательский алфавит
    private static final String ALPHABET = "АаБбВвГгДдЕеЁёЖжЗзИиЙйКкЛлМмНнОоПпРрСсТтУуФфХхЦцЧчШшЩщЪъЫыЬьЭэЮюЯя ";

    // Метод для шифрования
    public static String encrypt(String text, int key) {
        StringBuilder encrypted = new StringBuilder();

        for (char ch : text.toCharArray()) {
            int index = ALPHABET.indexOf(ch);

            if (index != -1) {
                // Вычисляем новый индекс с учетом ключа
                int newIndex = (index + key) % ALPHABET.length();
                encrypted.append(ALPHABET.charAt(newIndex));
            } else {
                // Если символ не найден в алфавите, добавляем его как есть
                encrypted.append(ch);
            }
        }

        return encrypted.toString();
    }

    // Метод для обратного шифрования
    public static String decrypt(String text, int key) {
        StringBuilder decrypted = new StringBuilder();

        for (char ch : text.toCharArray()) {
            int index = ALPHABET.indexOf(ch);

            if (index != -1) {
                // Вычисляем новый индекс с учетом ключа
                int newIndex = (index - key + ALPHABET.length()) % ALPHABET.length();
                decrypted.append(ALPHABET.charAt(newIndex));
            } else {
                // Если символ не найден в алфавите, добавляем его как есть
                decrypted.append(ch);
            }
        }

        return decrypted.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст для шифрования:");
        String text = scanner.nextLine();

        System.out.println("Введите ключ (целое число):");
        int key = scanner.nextInt();
        scanner.nextLine(); // Считываем оставляющийся символ новой строки

        String encryptedText = encrypt(text, key);
        System.out.println("Текст после преобразования: " + encryptedText);

        System.out.println("Выполнить обратное преобразование? (y/n)");
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("y")) {
            String decryptedText = decrypt(encryptedText, key);
            System.out.println("Текст после обратного преобразования: " + decryptedText);
        } else if (response.equalsIgnoreCase("n")) {
            System.out.println("До свидания!");
        } else {
            System.out.println("Введите корректный ответ.");
        }

        scanner.close();
    }
}