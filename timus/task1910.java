package timus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task1910 {

    public static void main(String[] args) throws IOException {
        String inputFileName = "timus_task/input.txt";
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
        BufferedReader bufferedReader =
                oj ? new BufferedReader(new InputStreamReader(System.in)) :
                        new BufferedReader(new FileReader(inputFileName));
        int sections = Integer.parseInt(bufferedReader.readLine());
        String [] str = bufferedReader.readLine().split(" ");
        int [] strongField = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            strongField[i] = Integer.parseInt(str[i]);
        }
        int firstSection = strongField[0];
        int resultSumTripleStrong = firstSection + strongField[1] + strongField[2];
        int indexMaxElement = 1;
        for (int i = 1; i < strongField.length; i++) {
            int sumFieldTriple = strongField[i-1] + strongField[i] + strongField[i+1];
            if (sumFieldTriple > resultSumTripleStrong) {
                resultSumTripleStrong = sumFieldTriple;
                indexMaxElement = i;
            }
            if (i == strongField.length - 2) {
                break;
            }
        }
        indexMaxElement += 1;
        System.out.println(resultSumTripleStrong + " " + indexMaxElement);
    }
}
