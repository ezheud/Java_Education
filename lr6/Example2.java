package lr6;

public class Example2 {
    // Закрытое статическое целочисленное поле
    private static int count = 0;

    // Статический метод для отображения текущего значения и увеличения поля
    public static void displayAndIncrement() {
        // Отображаем текущее значение поля
        System.out.println("Значение: " + count);
        // Увеличиваем значение поля на единицу
        count++;
    }

    // Основной метод для тестирования
    public static void main(String[] args) {
        // Вызываем метод несколько раз
        Example2.displayAndIncrement(); // Вывод: Значение: 0
        Example2.displayAndIncrement(); // Вывод: Значение: 1
        Example2.displayAndIncrement(); // Вывод: Значение: 2
    }
}