package timus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task1327 {

//Ваша цель помочь ему подготовить заказ для отдела снабжения. Заказ на предохранители составляется на некоторый промежуток 
времени от A-го Сашиного рабочего дня, до B-го включительно. Помогите Саше посчитать, сколько раз спалит Янус злосчастный
предохранитель за этот промежуток времени.

    public static void main(String[] args) throws IOException {
        String inputFileName = "timus_task/input.txt";
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
        try {
            BufferedReader bufferedReader =
                    oj ? new BufferedReader(new InputStreamReader(System.in)) :
                            new BufferedReader(new FileReader(inputFileName));
            int a = Integer.parseInt(bufferedReader.readLine());
            int b = Integer.parseInt(bufferedReader.readLine());
            int result = 0;
            for (int i = a; i <= b; i++) {
                if (i % 2 != 0) {
                    result++;
                }
            }
            System.out.println(result);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
