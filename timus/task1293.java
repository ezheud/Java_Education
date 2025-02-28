package timus;

import java.io.PrintWriter;
import java.util.Scanner;

//Всего необходимо обработать N прямоугольных панелей размером A на B метров. Вам необходимо как можно скорее
//подсчитать, сколько всего сульфида необходимо на обработку всех панелей «Энии». И не забудьте,
//что панели требуют обработки с обеих сторон. Выведите вес необходимого для обработки сульфида тория в нанограммах.

public class task1293 {
        public static void main(String[] args) {

            Scanner in = new Scanner(System.in);
            PrintWriter out = new PrintWriter(System.out);
            System.out.println("Введите число N A B:");
            int N = in.nextInt();
            int A = in.nextInt();
            int B = in.nextInt();

            int result = (N * (A*B)) * 2;

            out.println(result);
            out.flush();
        }
    }