package lr5;

public class Example3 {
        // Два целочисленных поля
        private int first;
        private int second;

        // Конструктор без аргументов (по умолчанию)
        public Example3() {
            this.first = 0; // устанавливаем значение по умолчанию
            this.second = 0; // устанавливаем значение по умолчанию
        }

        // Конструктор с одним аргументом
        public Example3(int first) {
            this.first = first; // устанавливаем значение первого поля
            this.second = 0; // устанавливаем значение второго поля по умолчанию
        }

        // Конструктор с двумя аргументами
        public Example3(int first, int second) {
            this.first = first; // устанавливаем значение первого поля
            this.second = second; // устанавливаем значение второго поля
        }

        // Метод для отображения значений полей
        public void displayValues() {
            System.out.println("First: " + first + ", Second: " + second);
        }

        // Пример использования класса
        public static void main(String[] args) {
            Example3 pair1 = new Example3(); // Объект без аргументов
            pair1.displayValues(); // Вывод: First: 0, Second: 0

            Example3 pair2 = new Example3(5); // Объект с одним аргументом
            pair2.displayValues(); // Вывод: First: 5, Second: 0

            Example3 pair3 = new Example3(10, 20); // Объект с двумя аргументами
            pair3.displayValues(); // Вывод: First: 10, Second: 20
        }
    }
