package lr12;

import java.util.concurrent.*;

public class Example6 {
    public static void main(String[] args) {
        // Тестовый массив
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // Вычисляем сумму
        int sum = calculateSum(array);
        System.out.println("Сумма элементов: " + sum);
    }

    public static int calculateSum(int[] array) {
        // Получаем количество доступных ядер процессора
        int cores = Runtime.getRuntime().availableProcessors();
        // Создаем пул потоков
        ExecutorService executor = Executors.newFixedThreadPool(cores);

        // Вычисляем размер части массива для каждого потока
        int chunkSize = array.length / cores;
        if (array.length % cores != 0) chunkSize++;

        // Массив для хранения Future объектов
        Future<Integer>[] futures = new Future[cores];

        // Раздаем задачи потокам
        for (int i = 0; i < cores; i++) {
            final int start = i * chunkSize;
            final int end = Math.min((i + 1) * chunkSize, array.length);

            // Каждый поток суммирует свою часть массива
            futures[i] = executor.submit(() -> {
                int sum = 0;
                for (int j = start; j < end; j++) {
                    sum += array[j];
                }
                return sum;
            });
        }

        // Суммируем результаты всех потоков
        int totalSum = 0;
        try {
            for (Future<Integer> future : futures) {
                totalSum += future.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Завершаем работу пула потоков
        executor.shutdown();
        return totalSum;
    }
}