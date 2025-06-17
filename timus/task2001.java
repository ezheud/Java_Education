package timus;

import java.io.PrintWriter;
import java.util.Scanner;


public class task2001 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int basket_berries_first = in.nextInt();
        int basket_berries_second = in.nextInt();
        int basket_berries_first_two = in.nextInt();
        int basket_second = in.nextInt();
        int basket_first = in.nextInt();
        int basket_berries_second_two = in.nextInt();
        int berries_first = basket_berries_first - basket_first;
        int berries_second = basket_berries_second - basket_second;
        out.printf("%d %d", berries_first, berries_second);
        out.flush();
    }
}
