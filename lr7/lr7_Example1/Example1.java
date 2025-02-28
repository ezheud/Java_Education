package lr7.lr7_Example1;
    // Суперкласс
 class SuperClass {
        private String text;

        // Конструктор с текстовым параметром
        public SuperClass(String text) {
            this.text = text;
        }

        // Переопределение метода toString()
        @Override
        public String toString() {
            return "SuperClass: " + text;
        }
    }

    // Подкласс
 class subClass extends SuperClass {
        private String additionalText;

        // Конструктор с одним текстовым аргументом
        public subClass(int i, String text) {
            super(text);
            this.additionalText = "";
        }

        // Конструктор с двумя текстовыми аргументами
        public subClass(String text, String additionalText) {
            super(text);
            this.additionalText = additionalText;
        }

        // Переопределение метода toString()
        @Override
        public String toString() {
            return "SubClass: " + super.toString() + (additionalText.isEmpty() ? "" : ", Additional: " + additionalText);
        }
    }

    // Главный класс для тестирования
    public class Example1 {
            public static void main(String[] args) {
                SuperClass superClass = new SuperClass(" Hello from SuperClass! ");
                System.out.println(superClass);

                subClass subClass1 = new subClass(42, " Hello from SubClass ");
                System.out.println(subClass1);

                subClass subClass2 = new subClass(" Hello from SubClass ", " with additional text ");
                System.out.println(subClass2);
            }
        }