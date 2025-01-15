package lr5;

public class Example1 {
    // Закрытое символьное поле
    private char character;

    // Метод для присвоения значения полю
    public void setCharacter(char character) {
        this.character = character;
    }

    // Метод для возвращения кода символа
    public int getCharacterCode() {
        return (int) character; // Преобразование символа в его код
    }

    // Метод для вывода символа и его кода
    public void displayCharacterInfo() {
        System.out.println("Символ: " + character + ", Код: " + getCharacterCode());
    }

    // Пример использования класса
    public static void main(String[] args) {
        Example1 charField = new Example1();
        charField.setCharacter('A'); // Присваиваем символ
        charField.displayCharacterInfo(); // Выводим информацию о символе
    }
}
