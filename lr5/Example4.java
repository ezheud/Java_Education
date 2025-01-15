package lr5;

public class Example4 {
        // Символьное и целочисленное поля
        private char character;
        private int integer;

        // Конструктор с двумя аргументами
        public Example4(int code, char character) {
            this.character = character;
            this.integer = code;
        }

        // Конструктор с одним аргументом типа double
        public Example4(double value) {
            this.character = (char) ((int) value); // Действительная часть (код символа)
            this.integer = (int) ((value - (int) value) * 100); // Дробная часть в виде целого числа
        }

        // Метод для отображения значений полей
        public void displayValues() {
            System.out.println("Character: " + character + ", Integer: " + integer);
        }

        // Пример использования класса
        public static void main(String[] args) {
            // Объект с двумя аргументами
            Example4 pair1 = new Example4(65, 'A');
            pair1.displayValues(); // Вывод: Character: A, Integer: 65

            // Объект с одним аргументом типа double
            Example4 pair2 = new Example4(65.1267);
            pair2.displayValues(); // Вывод: Character: A, Integer: 12
        }
    }