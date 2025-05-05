package lr12;

public class Example3 {
    // Общий объект для синхронизации
    private static final Object lock = new Object();
    // Общая переменная для хранения текущего числа
    private static int number = 1;

    public static void main(String[] args) {
        // Поток для четных чисел
        Thread evenThread = new Thread(() -> {
            synchronized (lock) {
                while (number <= 10) {
                    if (number % 2 == 0) {
                        // Если число четное - выводим его
                        System.out.println("Четное: " + number);
                        number++;
                        // Оповещаем другой поток
                        lock.notifyAll();
                    } else {
                        try {
                            // Если число нечетное - ждем
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        // Поток для нечетных чисел
        Thread oddThread = new Thread(() -> {
            synchronized (lock) {
                while (number <= 10) {
                    if (number % 2 != 0) {
                        // Если число нечетное - выводим его
                        System.out.println("Нечетное: " + number);
                        number++;
                        // Оповещаем другой поток
                        lock.notifyAll();
                    } else {
                        try {
                            // Если число четное - ждем
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        // Запускаем оба потока
        evenThread.start();
        oddThread.start();

        try {
            // Ожидаем завершения потоков
            evenThread.join();
            oddThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}