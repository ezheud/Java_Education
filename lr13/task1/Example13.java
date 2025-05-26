package lr13.task1;

public class Example13 {
    public static void main(String[] args) {
        try {
            int l = args.length;
            System.out.println("размер массива = " + l);
            int h = 10 / l;
            args[l + 1] = "10"; // ArrayIndexOutOfBoundsException
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Индекс не существует");
        }
    }
}