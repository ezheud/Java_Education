package timus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task1149 {

//Пусть An = sin(1–sin(2+sin(3–sin(4+…sin(n))…)
Обозначим Sn = (…(A1+n)A2+n–1)A3+…+2)An+1
Для заданного N выведите выражение SN
  
    public static void main(String[] args) throws IOException {
        String inputFileName = "timus_task/input.txt";
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
        try {
            BufferedReader bufferedReader =
                    oj ? new BufferedReader(new InputStreamReader(System.in)) :
                            new BufferedReader(new FileReader(inputFileName));
            int length = Integer.parseInt(bufferedReader.readLine());
            System.out.println(buildSn(length));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private static String buildAn(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append("sin(").append(i);
            if (i < n) {
                sb.append(i % 2 == 1 ? "-" : "+");
            }
        }
        for (int i = 0; i < n; i++) {
            sb.append(")");
        }
        return sb.toString();
    }

    private static String buildSn(int N) {
        StringBuilder result = new StringBuilder();
        StringBuilder parentheses = new StringBuilder();
        for (int i = 1; i < N; i++) {
            parentheses.append("(");
        }
        for (int i = 1; i <= N; i++) {
            result.append(buildAn(i));
            if (i < N) {
                result.append("+").append(N - i + 1).append(")");
            } else {
                result.append("+1");
            }
        }
        return parentheses.toString() + result.toString();
    }
}
