package timus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task1876 {

    public static void main(String[] args) throws IOException {
        String inputFileName = "timus_task/input.txt";
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
        try {
            BufferedReader bufferedReader =
                    oj ? new BufferedReader(new InputStreamReader(System.in)) :
                            new BufferedReader(new FileReader(inputFileName));
            String [] str = bufferedReader.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int resultOne = 0;
            int resultTwo = 0;
            resultOne += 120 + (2 * (b - 40));
            resultTwo += 119 + (2 * (a - 40));
            if (resultOne > resultTwo) {
                System.out.println(resultOne);
            } else {
                System.out.println(resultTwo);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
