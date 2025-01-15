package lr5;

public class Example2 {
        // Два символьных поля
        private char start;
        private char end;

        // Конструктор для инициализации полей
        public Example2(char start, char end) {
            this.start = start;
            this.end = end;
        }

        // Метод для вывода символов в диапазоне
        public void displayCharactersBetween() {
            // Определяем начало и конец диапазона
            char lower = (char) Math.min(start, end);
            char upper = (char) Math.max(start, end);

            // Выводим все символы в диапазоне
            for (char c = lower; c <= upper; c++) {
                System.out.print(c + " ");
            }
            System.out.println(); // Для перехода на новую строку
        }

        // Пример использования класса
        public static void main(String[] args) {
            Example2 charRange = new Example2('A', 'D'); // Инициализируем диапазон от 'A' до 'D'
            charRange.displayCharactersBetween(); // Вызываем метод для вывода символов
        }
    }
