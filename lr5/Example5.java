package lr5;

public class Example5 {
    // Закрытое целочисленное поле
    private int value;

    // Конструктор, работающий по тому же принципу, что и метод setValue
    public Example5() {
        setValue(0); // Значение поля по умолчанию 0
    }

    public Example5(int value) {
        setValue(value); // Присваиваем значение через метод setValue
    }

    // Метод для присваивания значения полю
    public void setValue() {
        this.value = 0; // Присваиваем нулевое значение при вызове без аргументов
    }

    public void setValue(int value) {
        if (value > 100) {
            this.value = 100; // Присваиваем 100, если значение больше 100
        } else {
            this.value = value; // В противном случае присваиваем переданное значение
        }
    }

    // Метод для проверки значения поля
    public int getValue() {
        return value; // Возвращаем текущее значение поля
    }

    // Пример использования класса
    public static void main(String[] args) {
        Example5 limitedValue1 = new Example5(); // Использование конструктора без аргументов
        System.out.println("Initial value (default constructor): " + limitedValue1.getValue()); // Вывод: 0

        limitedValue1.setValue(150); // Установка значения больше 100
        System.out.println("Value after setting to 150: " + limitedValue1.getValue()); // Вывод: 100

        limitedValue1.setValue(75); // Установка значения меньше 100
        System.out.println("Value after setting to 75: " + limitedValue1.getValue()); // Вывод: 75

        Example5 limitedValue2 = new Example5(50); // Использование конструктора с аргументом
        System.out.println("Initial value (constructor with argument 50): " + limitedValue2.getValue()); // Вывод: 50

        limitedValue2.setValue(); // Установка значения по умолчанию (0)
        System.out.println("Value after setting to default (0): " + limitedValue2.getValue()); // Вывод: 0
    }
}