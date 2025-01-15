package lr5;

public class Example6 {
    // Закрытые целочисленные поля
    private int max;
    private int min;

    // Конструктор без аргументов
    public Example6() {
        this.max = Integer.MIN_VALUE; // Устанавливаем минимально возможное значение
        this.min = Integer.MAX_VALUE; // Устанавливаем максимально возможное значение
    }

    // Конструктор с одним аргументом
    public Example6(int value) {
        this(); // Вызываем конструктор без аргументов
        setValues(value); // Присваиваем значение полям
    }

    // Конструктор с двумя аргументами
    public Example6(int value1, int value2) {
        this(); // Вызываем конструктор без аргументов
        setValues(value1, value2); // Присваиваем значения полям
    }

    // Метод для присваивания значений полям (с одним аргументом)
    public void setValues(int value) {
        if (value > max) {
            max = value;
        }
        if (value < min) {
            min = value;
        }
    }

    // Метод для присваивания значений полям (с двумя аргументами)
    public void setValues(int value1, int value2) {
        setValues(value1); // Устанавливаем максимальное и минимальное значение из value1
        setValues(value2); // Устанавливаем максимальное и минимальное значение из value2
    }

    // Метод для отображения значений полей
    public void displayValues() {
        System.out.println("Max: " + max + ", Min: " + min);
    }

    // Пример использования класса
    public static void main(String[] args) {
        Example6 minMax = new Example6(); // Создаем объект с использованием конструктора без аргументов
        minMax.displayValues(); // Вывод: Max: -2147483648, Min: 2147483647

        minMax.setValues(5); // Устанавливаем значение 5
        minMax.displayValues(); // Вывод: Max: 5, Min: 5

        minMax.setValues(10, 3); // Устанавливаем значения 10 и 3
        minMax.displayValues(); // Вывод: Max: 10, Min: 3

        minMax.setValues(8, 15); // Устанавливаем значения 8 и 15
        minMax.displayValues(); // Вывод: Max: 15, Min: 3
    }
}
