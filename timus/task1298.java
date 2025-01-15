package timus;

import java.util.*;
//Если обход квадратного поля N на N клеток конём возможен, выведите N2 строк, содержащих правильный
//обход шахматного поля, иначе единственное слово “IMPOSSIBLE”.
public class task1298 {
        private static final int[] DX = {2, 1, -1, -2, -2, -1, 1, 2};
        private static final int[] DY = {1, 2, 2, 1, -1, -2, -2, -1};

        private static int[][] board;
        private static int N;

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите размер шахматной доски (1 ≤ N ≤ 8):");

            N = scanner.nextInt();
            if (N < 1 || N > 8) {
                System.out.println("IMPOSSIBLE");
                return;
            }

            board = new int[N][N];

            // Инициализация доски
            for (int[] row : board) {
                Arrays.fill(row, -1);
            }

            // Начинаем с клетки (0, 0)
            board[0][0] = 0;

            if (solve(0, 0, 1)) {
                printBoard();
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }

        // Решение задачи с использованием поиска с возвратом
        private static boolean solve(int x, int y, int moveCount) {
            if (moveCount == N * N) {
                return true; // Все клетки посещены
            }

            // Перебираем все возможные ходы коня
            for (int i = 0; i < 8; i++) {
                int nextX = x + DX[i];
                int nextY = y + DY[i];

                if (isValidMove(nextX, nextY)) {
                    board[nextX][nextY] = moveCount; // Делаем ход
                    if (solve(nextX, nextY, moveCount + 1)) {
                        return true;
                    }
                    board[nextX][nextY] = -1; // Отменяем ход (шаг назад)
                }
            }

            return false; // Если ни один ход не подходит
        }

        // Проверка, что ход допустим
        private static boolean isValidMove(int x, int y) {
            return x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1;
        }

        // Печать доски
        private static void printBoard() {
            for (int[] row : board) {
                for (int cell : row) {
                    System.out.print((cell + 1) + " ");
                }
                System.out.println();
            }
        }
    }
