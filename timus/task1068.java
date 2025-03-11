package timus;

import java.io.PrintWriter;
import java.util.Scanner;

//Всё, что от вас требуется — найти сумму всех целых чисел, лежащих между 1 и N включительно.

public class task1068 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int result = 0;
        while (n != 1) {
            result += n;
            if (n > 0) {
                n -= 1;
            } else {
                n += 1;
            }
        }
        out.println(result+1);
        out.flush();
    }
}