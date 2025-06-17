package timus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task1607 {

    public static void main(String[] args) throws IOException {
        String inputFileName = "timus_task/input.txt";
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
        try {
            BufferedReader bufferedReader =
                    oj ? new BufferedReader(new InputStreamReader(System.in)) :
                            new BufferedReader(new FileReader(inputFileName));
            String [] str = bufferedReader.readLine().split(" ");
            int pricePetya = Integer.parseInt(str[0]);
            int allowance = Integer.parseInt(str[1]);
            int priceTaxi = Integer.parseInt(str[2]);
            int sale = Integer.parseInt(str[3]);
            int result = 0;
            if (pricePetya > priceTaxi) {
                System.out.println(pricePetya);
            } else {
                while (pricePetya <= priceTaxi) {
                    if (pricePetya + allowance <= priceTaxi) {
                        pricePetya += allowance;
                        result = pricePetya;
                    } else {
                        result = priceTaxi;
                        break;
                    }
                    if (priceTaxi - sale >= pricePetya) {
                        priceTaxi -= sale;
                        result = priceTaxi;
                    } else {
                        result = pricePetya;
                        break;
                    }
                }
                System.out.println(result);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
