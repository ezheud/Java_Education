package lr12;

public class Example2 {
    public static void main(String[] args) {
        // Создаем новый поток
        Thread t = new Thread(() -> {
            // Цикл от 1 до 10
            for (int i = 1; i <= 10; i++) {
                // Выводим текущее число
                System.out.println(i);
                try {
                    // Пауза 1 секунда между выводами
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Запускаем поток
        t.start();

        try {
            // Ожидаем завершения потока
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}