package lr12;

import java.time.LocalTime;

public class Example1 {
    public static void main(String[] args) {
        // Создаем первый поток
        Thread t1 = new Thread(() -> {
            // Устанавливаем время окончания работы потока (текущее время + 10 секунд)
            long endTime = System.currentTimeMillis() + 10000;
            // Пока текущее время меньше времени окончания
            while (System.currentTimeMillis() < endTime) {
                // Выводим имя потока и текущее время
                System.out.println("Поток 1: " + LocalTime.now());
                try {
                    // Приостанавливаем поток на 1 секунду
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Создаем второй поток (аналогично первому)
        Thread t2 = new Thread(() -> {
            long endTime = System.currentTimeMillis() + 10000;
            while (System.currentTimeMillis() < endTime) {
                System.out.println("Поток 2: " + LocalTime.now());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Запускаем оба потока
        t1.start();
        t2.start();

        try {
            // Ожидаем завершения работы потоков
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}