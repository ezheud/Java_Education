package lr13.task1;

public class Example10 {
    public static int m() {
        try {
            System.out.println("0");
            return 15;
        } finally {
            System.out.println("1");
            return 20; // Переопределяет возвращаемое значение
        }
    }

    public static void main(String[] args) {
        System.out.println(m());
    }
}