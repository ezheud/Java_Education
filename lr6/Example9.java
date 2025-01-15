package lr6;

public class Example9 {

    // Статический метод для обмена элементов массива попарно
    public static void swapCharArray(char[] charArray) {
        int left = 0; // Индекс с начала массива
        int right = charArray.length - 1; // Индекс с конца массива

        // Меняем элементы местами, пока индекс слева меньше индекса справа
        while (left < right) {
            // Меняем элементы местами
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            // Перемещаем индексы
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        // Пример использования метода
        char[] characters = {'Д', 'Р', 'У', 'Г'};

        // Выводим исходный массив
        System.out.println("Исходный массив: ");
        System.out.println(charArrayToString(characters));

        // Меняем элементы массива местами
        swapCharArray(characters);

        // Выводим измененный массив
        System.out.println("Измененный массив: ");
        System.out.println(charArrayToString(characters));
    }

    // Вспомогательный метод для преобразования массива символов в строку
    private static String charArrayToString(char[] array) {
        StringBuilder sb = new StringBuilder();
        for (char c : array) {
            sb.append(c);
            sb.append(" "); // добавляем пробел между символами
        }
        return sb.toString().trim();
    }
}