package timus;

import java.io.*;
import java.util.Arrays;

public class task1880 {

    public static void main(String[] args) throws IOException {
        String inputFileName = "timus_task/input.txt";
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
        BufferedReader bufferedReader =
                oj ? new BufferedReader(new InputStreamReader(System.in)) :
                        new BufferedReader(new FileReader(inputFileName));
        int size1 = Integer.parseInt(bufferedReader.readLine());
        String [] stringNumbers1 = bufferedReader.readLine().split(" ");
        int size2 = Integer.parseInt(bufferedReader.readLine());
        String [] stringNumbers2 = bufferedReader.readLine().split(" ");
        int size3 = Integer.parseInt(bufferedReader.readLine());
        String [] stringNumbers3 = bufferedReader.readLine().split(" ");

        int allSize = size1 + size2 + size3;
        String[] stringsAllNumbers = new String[allSize];

        for (int i = 0, x = 0, y = 0; i < allSize; i++) {
            if (i < size1) {
                stringsAllNumbers[i] = stringNumbers1[i];
                continue;
            }
            if (i < (size1 + size2)) {
                stringsAllNumbers[i] = stringNumbers2[x];
                x++;
                continue;
            }
            stringsAllNumbers[i] = stringNumbers3[y];
            y++;
        }
        Arrays.sort(stringsAllNumbers);
        int count = 0;
        for (int i = 1; i < stringsAllNumbers.length - 1; i++) {
            if (stringsAllNumbers[i-1].equals(stringsAllNumbers[i]) && stringsAllNumbers[i].equals(stringsAllNumbers[i+1])) {
                count++;
            }
        }
        System.out.println(count);
    }
}
