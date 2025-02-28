package timus;

import java.io.PrintWriter;
import java.util.Scanner;

//Для того чтобы приготовить бифштекс, повар должен прожарить каждую из его сторон на сковороде в течение одной минуты.
//К сожалению, у повара есть только одна сковорода, и на ней можно одновременно жарить не более k бифштексов.
// Определите, сколько минут понадобится повару, чтобы выполнить заказ программистов. Выведите минимальное количество
// минут, за которое повар сможет приготовить n бифштексов.

public class task1820 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        System.out.println("Введите число n и k:");
        int need_steaks = in.nextInt();
        int max_steaks = in.nextInt();
        if (max_steaks >= need_steaks) {
            out.print(2);
        } else {
            if ((need_steaks * 2) % max_steaks == 0) {
                out.print((need_steaks * 2) / max_steaks);
            } else {
                out.print((need_steaks * 2) / max_steaks +1);
            }
        }
        out.flush();
    }
}
