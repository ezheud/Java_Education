package timus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task1639 {

//Исходные данные
В единственной строке через пробел записаны целые числа m и n (1 ≤ m, n ≤ 50) — длина и ширина шоколадки в дольках.
Результат
Если для того, чтобы выиграть, Карлсону нужно ходить первым, выведите в единственной строке «[:=[first]», 
  иначе выведите «[second]=:]».
  
    public static void main(String[] args) throws IOException {
        String inputFileName = "timus_task/input.txt";
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
        BufferedReader bufferedReader =
                oj ? new BufferedReader(new InputStreamReader(System.in)) :
                        new BufferedReader(new FileReader(inputFileName));
        String [] str = bufferedReader.readLine().split(" ");
        String resultFirst = "[:=[first]";
        String resultSecond = "[second]=:]";
        int [] numbers = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            numbers[i] = Integer.parseInt(str[i]);
        }
        int square = numbers[0] * numbers[1];
        if (square % 2 == 0) {
            System.out.println(resultFirst);
        } else {
            System.out.println(resultSecond);
        }
    }
}
