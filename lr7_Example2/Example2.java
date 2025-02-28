package lr7_Example2;

// Суперкласс
class SuperClass {
    // Приватное текстовое поле
    private String text;

    // Конструктор с текстовым параметром
    public SuperClass(String text) {
        this.text = text;
    }

    // Метод для присваивания значения полю
    public void setText(String text) {
        this.text = text;
    }

    // Метод, возвращающий длину текстовой строки
    public int getTextLength() {
        return text.length();
    }

    // Переопределенный метод toString()
    @Override
    public String toString() {
        return "SuperClass{" +
                "text='" + text + '\'' +
                '}';
    }
}

// Подкласс, наследующий SuperClass
class SubClass extends SuperClass {
    // Публичное целочисленное поле
    public int number;

    // Конструктор с двумя параметрами (целочисленный и текстовый)
    public SubClass(int number, String text) {
        super(text); // Вызов конструктора суперкласса
        this.number = number;
    }

    // Метод без параметров (переопределение метода из суперкласса)
    public void setValues() {
        super.setText("Default Text"); // Устанавливаем значение по умолчанию
        this.number = 0; // Устанавливаем значение по умолчанию
    }

    // Метод с текстовым параметром (перегрузка метода из суперкласса)
    public void setValues(String text) {
        super.setText(text); // Устанавливаем текстовое значение
    }

    // Метод с целочисленным параметром (перегрузка метода из суперкласса)
    public void setValues(int number) {
        this.number = number; // Устанавливаем целочисленное значение
    }

    // Метод с текстовым и целочисленным параметром (перегрузка метода из суперкласса)
    public void setValues(String text, int number) {
        super.setText(text); // Устанавливаем текстовое значение
        this.number = number; // Устанавливаем целочисленное значение
    }

    // Переопределенный метод toString()
    @Override
    public String toString() {
        return "SubClass{" +
                "text='" + super.toString() + '\'' +
                ", number=" + number +
                '}';
    }
}

// Основной класс для тестирования
public class Example2 {
    public static void main(String[] args) {
        // Создание объекта суперкласса
        SuperClass superClass = new SuperClass("Hello from SuperClass");
        System.out.println(superClass.toString());
        System.out.println("Text length: " + superClass.getTextLength());

        // Создание объекта подкласса
        SubClass subClass = new SubClass(42, "Hello from SubClass");
        System.out.println(subClass.toString());

        // Использование методов для присваивания значений
        subClass.setValues(); // Без параметров
        System.out.println("After setValues(): " + subClass.toString());

        subClass.setValues("New Text"); // С текстовым параметром
        System.out.println("After setValues(String): " + subClass.toString());

        subClass.setValues(100); // С целочисленным параметром
        System.out.println("After setValues(int): " + subClass.toString());

        subClass.setValues("Final Text", 200); // С текстовым и целочисленным параметром
        System.out.println("After setValues(String, int): " + subClass.toString());
    }
}