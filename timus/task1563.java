package timus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class task1563 {

    public static void main(String[] args) throws IOException {
        String inputFileName = "timus_task/input.txt";
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
        try {
            BufferedReader bufferedReader =
                    oj ? new BufferedReader(new InputStreamReader(System.in)) :
                            new BufferedReader(new FileReader(inputFileName));
            int result = 0;
            String currentShop = "";
            int sizeShop = Integer.parseInt(bufferedReader.readLine());
            List<String> prizma = new ArrayList<>();
            for (int i = 0; i < sizeShop; i++) {
                currentShop = bufferedReader.readLine();
                if (!prizma.contains(currentShop)) {
                    prizma.add(currentShop);
                } else {
                    result++;
                }
            }
            System.out.println(result);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
