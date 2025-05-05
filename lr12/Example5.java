package lr12;

import java.util.concurrent.*;

public class Example5 {
    public static void main(String[] args) {
        // Тестовый массив
        int[] array = {3, 7, 2, 9, 5, 1, 8, 4, 6, 0};
        // Находим максимальный элемент
        int max = findMax(array);
        System.out.println("Максимальный элемент: " + max);
    }

    public static int findMax(int[] array) {
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

            // Каждый поток ищет максимум в своей части массива
            futures[i] = executor.submit(() -> {
                int max = Integer.MIN_VALUE;
                for (int j = start; j < end; j++) {
                    if (array[j] > max) {
                        max = array[j];
                    }
                }
                return max;
            });
        }

        // Находим общий максимум из результатов потоков
        int globalMax = Integer.MIN_VALUE;
        try {
            for (Future<Integer> future : futures) {
                int localMax = future.get();
                if (localMax > globalMax) {
                    globalMax = localMax;
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Завершаем работу пула потоков
        executor.shutdown();
        return globalMax;
    }
}