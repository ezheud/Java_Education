package lr7_Example5;

// Первый класс
class FirstClass {
    // Открытое символьное поле
    public char character;

    // Конструктор с параметром для инициализации поля
    public FirstClass(char character) {
        this.character = character;
    }

    // Конструктор создания копии
    public FirstClass(FirstClass original) {
        this.character = original.character;
    }

    // Переопределенный метод toString()
    @Override
    public String toString() {
        return "FirstClass{" +
                "character=" + character +
                '}';
    }
}

// Второй класс, наследующий FirstClass
class SecondClass extends FirstClass {
    // Открытое текстовое поле
    public String text;

    // Конструктор с параметрами для инициализации полей
    public SecondClass(char character, String text) {
        super(character); // Вызов конструктора суперкласса
        this.text = text;
    }

    // Конструктор создания копии
    public SecondClass(SecondClass original) {
        super(original); // Вызов конструктора копии суперкласса
        this.text = original.text;
    }

    // Переопределенный метод toString()
    @Override
    public String toString() {
        return "SecondClass{" +
                "character=" + character +
                ", text='" + text + '\'' +
                '}';
    }
}

// Третий класс, наследующий SecondClass
class ThirdClass extends SecondClass {
    // Открытое целочисленное поле
    public int number;

    // Конструктор с параметрами для инициализации полей
    public ThirdClass(char character, String text, int number) {
        super(character, text); // Вызов конструктора подкласса
        this.number = number;
    }

    // Конструктор создания копии
    public ThirdClass(ThirdClass original) {
        super(original); // Вызов конструктора копии подкласса
        this.number = original.number;
    }

    // Переопределенный метод toString()
    @Override
    public String toString() {
        return "ThirdClass{" +
                "character=" + character +
                ", text='" + text + '\'' +
                ", number=" + number +
                '}';
    }
}

// Основной класс для тестирования
public class Example5 {
    public static void main(String[] args) {
        // Создание объекта FirstClass
        FirstClass first = new FirstClass('A');
        System.out.println(first.toString());

        // Создание копии объекта FirstClass
        FirstClass firstCopy = new FirstClass(first);
        System.out.println("Copy of FirstClass: " + firstCopy.toString());

        // Создание объекта SecondClass
        SecondClass second = new SecondClass('B', "Hello");
        System.out.println(second.toString());

        // Создание копии объекта SecondClass
        SecondClass secondCopy = new SecondClass(second);
        System.out.println("Copy of SecondClass: " + secondCopy.toString());

        // Создание объекта ThirdClass
        ThirdClass third = new ThirdClass('C', "World", 42);
        System.out.println(third.toString());

        // Создание копии объекта ThirdClass
        ThirdClass thirdCopy = new ThirdClass(third);
        System.out.println("Copy of ThirdClass: " + thirdCopy.toString());
    }
}
