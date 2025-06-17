package timus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task1209 {

    public static void main(String[] args) throws IOException {
        String inputFileName = "timus_task/input.txt";
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
        try {
            BufferedReader bufferedReader =
                    oj ? new BufferedReader(new InputStreamReader(System.in)) :
                            new BufferedReader(new FileReader(inputFileName));
            String readLine = "";
            int count_number = Integer.parseInt(bufferedReader.readLine());
            while ((readLine = bufferedReader.readLine()) != null) {
                long index = Long.parseLong(readLine) - 1;
                long indexResult = (long) Math.sqrt(8 * index + 1);
                if ((indexResult * indexResult) == (8 * index + 1)) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }

            }
            System.out.println();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
