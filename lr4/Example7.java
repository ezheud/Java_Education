package lr4;

public class Example7 {
    public static void main(String[] args) {
        int line = 22;                      // назначенное количество строк
        int cols = 22;                      // назначенное количество столбцов

        int[][] snakeArray = new int[line][cols];
        int num = 1;      // начальное значение для заполнения массива
        for (int i = 0; i < line; i++) {
            boolean isRowEven = (i % 2 == 0);           // проверка на четность

            if (isRowEven) {
                // Если строка чётная, заполняем слева направо
                for (int j = 0; j < cols; j++) {
                    snakeArray[i][j] = num++;
                }
            } else {
                // Если строка нечётная, заполняем справа налево
                for (int j = cols - 1; j >= 0; j--) {
                    snakeArray[i][j] = num++;
                }
            }
        }

        printArray(snakeArray);
    }

    public static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int value : row) {
                System.out.printf("%3d ", value);
            }
            System.out.println();
        }
    }
}
