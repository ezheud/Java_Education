package timus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task1313 {

//На выходе преобразователя должна получиться последовательность для ввода в новый монитор. Пиксели нумеруются от левого 
    верхнего угла, по диагоналям, слева-направо и снизу-вверх. Подробнее объяснять тут долго и неинтересно, 
    посмотрите на пример, дальше сами догадаетесь.

    public static void main(String[] args) throws IOException {
        String inputFileName = "timus_task/input.txt";
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
        try {
            BufferedReader bufferedReader =
                    oj ? new BufferedReader(new InputStreamReader(System.in)) :
                            new BufferedReader(new FileReader(inputFileName));
            String readLine = "";
            int length = Integer.parseInt(bufferedReader.readLine());
            int [] listNumber = new int[length*length];
            int [][] doubleListNumber = new int[length][length];
            int index = 0;
            while ((readLine = bufferedReader.readLine()) != null) {
                String [] stringNumber = readLine.split(" ");
                for (int i = 0; i < stringNumber.length; i++) {
                    listNumber[index] = Integer.parseInt(stringNumber[i]);
                    index++;
                }
            }
            index = 0;
            for (int x = 0; x < length; x++) {
                for (int y = 0; y < length; y++) {
                    doubleListNumber[x][y] = listNumber[index];
                    index ++;
                }
            }
            for (int x = 0; x < length; x++) {
                for (int y = x; y >= 0; y--) {
                    System.out.print(doubleListNumber[y][x-y] + " ");
                }
            }
            for (int x = 1; x < length; x++) {
                for (int y = length - 1 ; y >= x; y--) {
                    System.out.print(doubleListNumber[y][length - y + x - 1] + " ");
                }
            }
            System.out.println();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
