package timus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class task1243 {

//Ваша задача — помочь гномам рассчитать долю Белоснежки. Единственная строка содержит число 
  N одинаковых вещей, которые хотят поделить гномы (1 ≤ N ≤ 1050). Единственное число — количество вещей, 
  которые в результате справедливого раздела, перейдут к Белоснежке.
  
    public static void main(String[] args) throws IOException {
        String inputFileName = "timus_task/input.txt";
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
        try {
            BufferedReader bufferedReader =
                    oj ? new BufferedReader(new InputStreamReader(System.in)) :
                            new BufferedReader(new FileReader(inputFileName));
            BigInteger bigIntegerValue = new BigInteger(bufferedReader.readLine());
            BigInteger dwarf = new BigInteger("7");
            System.out.println(bigIntegerValue.mod(dwarf));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
