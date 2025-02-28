package lr7_Example3;

// Первый суперкласс
class SuperClass {
    // Открытое целочисленное поле
    public int number;

    // Конструктор с одним параметром
    public SuperClass(int number) {
        this.number = number;
    }

    // Метод для присваивания значения полю
    public void setValue(int number) {
        this.number = number;
    }

    // Переопределенный метод toString()
    @Override
    public String toString() {
        return "SuperClass{" +
                "number=" + number +
                '}';
    }
}

// Второй класс, наследующий SuperClass
class SubClass1 extends SuperClass {
    // Открытое символьное поле
    public char character;

    // Конструктор с двумя параметрами
    public SubClass1(int number, char character) {
        super(number); // Вызов конструктора суперкласса
        this.character = character;
    }

    // Перегрузка метода для присваивания значений двум полям
    public void setValue(int number, char character) {
        super.setValue(number); // Использование метода суперкласса
        this.character = character;
    }

    // Переопределенный метод toString()
    @Override
    public String toString() {
        return "SubClass1{" +
                "number=" + number +
                ", character=" + character +
                '}';
    }
}

// Третий класс, наследующий SubClass1
class SubClass2 extends SubClass1 {
    // Открытое текстовое поле
    public String text;

    // Конструктор с тремя параметрами
    public SubClass2(int number, char character, String text) {
        super(number, character); // Вызов конструктора подкласса
        this.text = text;
    }

    // Перегрузка метода для присваивания значений трем полям
    public void setValue(int number, char character, String text) {
        super.setValue(number, character); // Использование метода подкласса
        this.text = text;
    }

    // Переопределенный метод toString()
    @Override
    public String toString() {
        return "SubClass2{" +
                "number=" + number +
                ", character=" + character +
                ", text='" + text + '\'' +
                '}';
    }
}

// Основной класс для тестирования
public class Example3 {
    public static void main(String[] args) {
        // Создание объекта SuperClass
        SuperClass superClass = new SuperClass(10);
        System.out.println(superClass.toString());

        // Создание объекта SubClass1
        SubClass1 subClass1 = new SubClass1(20, 'A');
        System.out.println(subClass1.toString());

        // Создание объекта SubClass2
        SubClass2 subClass2 = new SubClass2(30, 'B', "Hello");
        System.out.println(subClass2.toString());

        // Использование методов для присваивания значений
        superClass.setValue(100);
        System.out.println("After setValue in SuperClass: " + superClass.toString());

        subClass1.setValue(200, 'X');
        System.out.println("After setValue in SubClass1: " + subClass1.toString());

        subClass2.setValue(300, 'Y', "World");
        System.out.println("After setValue in SubClass2: " + subClass2.toString());
    }
}