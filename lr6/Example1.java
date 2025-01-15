package lr6;

public class Example1 {
        private char charField;
        private String textField;

        // Метод для присваивания символьного значения
        public void assignValue(char value) {
            this.charField = value;
        }

        // Метод для присваивания текстового значения
        public void assignValue(String value) {
            this.textField = value;
        }

        // Метод для присваивания значения из массив символов
        public void assignValue(char[] value) {
            if (value.length == 1) {
                this.charField = value[0]; // Присваиваем символьному полю
            } else {
                StringBuilder sb = new StringBuilder();
                for (char c : value) {
                    sb.append(c); // Формируем строку из массива символов
                }
                this.textField = sb.toString(); // Присваиваем текстовому полю
            }
        }

        // Методы для получения значений полей
        public char getCharField() {
            return charField;
        }

        public String getTextField() {
            return textField;
        }

        // Пример использования
        public static void main(String[] args) {
            Example1 myObject = new Example1();

            // Присваиваем символьное значение
            myObject.assignValue('A');
            System.out.println("Char field: " + myObject.getCharField()); // A

            // Присваиваем текстовое значение
            myObject.assignValue("Здравствуй");
            System.out.println("Text field: " + myObject.getTextField()); // Здравствуй

            // Присваиваем массив символов с одним элементом
            myObject.assignValue(new char[] {'B'});
            System.out.println("Char field: " + myObject.getCharField()); // B

            // Присваиваем массив символов с несколькими элементами
            myObject.assignValue(new char[] {'Д', 'р', 'у', 'г'});
            System.out.println("Text field: " + myObject.getTextField()); // Друг
        }
    }