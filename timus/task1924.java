package timus;

import java.io.*;

public class task1924 {

    public static void main(String[] args) throws IOException {
        String inputFileName = "timus_task/input.txt";
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
        try {
            BufferedReader bufferedReader =
                    oj ? new BufferedReader(new InputStreamReader(System.in)) :
                            new BufferedReader(new FileReader(inputFileName));
            String readLine = "";
            int n = Integer.parseInt(bufferedReader.readLine());
            int[] listNumber = new int[n];
            int result = 0;
            for (int i = 1; i <= n; i++) {
                listNumber[i - 1] = i;
            }
            for (int i = 0; i < listNumber.length; i++) {
                if (i % 2 == 1) {
                    result += listNumber[i];
                } else {
                    result -= listNumber[i];
                }
            }
            if (result % 2 == 0) {
                System.out.println("black");
            } else {
                System.out.println("grimy");
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
