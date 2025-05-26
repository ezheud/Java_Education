package lr13.task1;

public class Example2 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new RuntimeException("Непроверяемая ошибка");
            // System.out.println("1"); // Ошибка: недостижимый код (исправлено — удалено)
        } catch (Exception e) {
            System.out.println("2 " + e);
        }
        System.out.println("3");
    }
}