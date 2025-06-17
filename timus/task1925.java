package timus;
import java.util.Scanner;

public class task1925 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int sumBminus2 = 0;
            int sumG = 0;
            for (int i = 0; i < n; i++) {
                int b = scanner.nextInt();
                int g = scanner.nextInt();
                sumBminus2 += (b - 2);
                sumG += g;
            }
            int x = (sumBminus2 + (k - 2)) - sumG;
            if (x >= 0) {
                System.out.println(x);
            } else {
                System.out.println("Big Bang!");
            }
        }
}
