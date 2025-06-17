package timus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task1654 {

    public static void main(String[] args) throws IOException {
        String inputFileName = "timus_task/input.txt";
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
        try {
            BufferedReader bufferedReader =
                    oj ? new BufferedReader(new InputStreamReader(System.in)) :
                            new BufferedReader(new FileReader(inputFileName));
            String str = bufferedReader.readLine();
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < str.length(); i++) {
                char currentChar = str.charAt(i);
                int lastIndex = result.length() - 1;
                if (lastIndex >= 0 && result.charAt(lastIndex) == currentChar) {
                    result.deleteCharAt(lastIndex);
                } else {
                    result.append(currentChar);
                }
            }
            System.out.println(result.toString());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
