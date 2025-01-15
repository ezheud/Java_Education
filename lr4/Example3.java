package lr4;

public class Example3 {
    public static void main(String[] args) {
        int line = 5;                      // Назначенное количество строк
        int cols = 10;                     // Назначенное количество столбцов

        int[][] rectangle = new int[line][cols];
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < cols; j++) {
                rectangle[i][j] = 2;
                System.out.print(rectangle[i][j] + " ");
            }
            System.out.println();
        }
    }
}