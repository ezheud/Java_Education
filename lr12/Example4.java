package lr12;

public class Example4 {
    public static void main(String[] args) {
        // Создаем 10 потоков
        for (int i = 0; i < 10; i++) {
            // Сохраняем номер потока в final переменной
            final int threadNumber = i;
            // Создаем и запускаем поток
            new Thread(() -> {
                // Поток выводит свой номер
                System.out.println("Поток " + threadNumber);
            }).start();
        }
    }
}