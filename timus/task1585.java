package timus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task1585 {

    public static void main(String[] args) throws IOException {
        String inputFileName = "timus_task/input.txt";
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
        try {
            BufferedReader bufferedReader =
                    oj ? new BufferedReader(new InputStreamReader(System.in)) :
                            new BufferedReader(new FileReader(inputFileName));
            String readLine = "";
            int allCount = Integer.parseInt(bufferedReader.readLine());
            int emperor = 0;
            int little = 0;
            int macaroni = 0;
            while ((readLine = bufferedReader.readLine()) != null) {
                if (readLine.equals("Emperor Penguin")) {
                    emperor++;
                } else if (readLine.equals("Little Penguin")) {
                    little++;
                } else if (readLine.equals("Macaroni Penguin")) {
                    macaroni++;
                }

            }

            if (emperor > little && emperor > macaroni) {
                System.out.println("Emperor Penguin");
            } else if (little > emperor && little > macaroni) {
                System.out.println("Little Penguin");
            } else if(macaroni > emperor && macaroni > little) {
                System.out.println("Macaroni Penguin");
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
