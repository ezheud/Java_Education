package timus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class task1617 {

//Исходные данные
В первой строке записано целое число n — количество имеющихся колесных пар (1 ≤ n ≤ 150). 
  В следующих n строках записаны диаметры колес в миллиметрах (целые числа от 600 до 700).
  Результат
Выведите количество вагонов, которое удастся оснастить колесными парами из имеющегося набора.

    public static void main(String[] args) throws IOException {
        String inputFileName = "timus_task/input.txt";
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
        try {
            BufferedReader bufferedReader =
                    oj ? new BufferedReader(new InputStreamReader(System.in)) :
                            new BufferedReader(new FileReader(inputFileName));
            int length = Integer.parseInt(bufferedReader.readLine());
            Map<Integer, Integer> diameterCount = new HashMap<>();
            for (int i = 0; i < length; i++) {
                int diameter = Integer.parseInt(bufferedReader.readLine());
                diameterCount.put(diameter, diameterCount.getOrDefault(diameter, 0) + 1);
            }
            int result = 0;
            for (int count : diameterCount.values()) {
                result += count / 4;
            }
            System.out.println(result);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
