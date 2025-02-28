package timus;

import java.io.PrintWriter;
import java.util.Scanner;

//Напишите программу, которая по количеству монстров выдаст соответствующее этому количеству слово.

public class task1785 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        System.out.println("Введите количество монстров:");
        int number_monsters = in.nextInt();
        if (1 <= number_monsters & number_monsters <= 4) {
            out.print("few");
            out.flush();
        } else if (5 <= number_monsters & number_monsters <= 9) {
            out.print("several");
            out.flush();
        } else if (10 <= number_monsters & number_monsters <= 19) {
            out.print("pack");
            out.flush();
        } else if (20 <= number_monsters & number_monsters <= 49) {
            out.print("lots");
            out.flush();
        } else if (50 <= number_monsters & number_monsters <= 99) {
            out.print("horde");
            out.flush();
        } else if (100 <= number_monsters & number_monsters <= 249) {
            out.print("throng");
            out.flush();
        } else if (250 <= number_monsters & number_monsters <= 499) {
            out.print("swarm");
            out.flush();
        } else if (500 <= number_monsters & number_monsters <= 999) {
            out.print("zounds");
            out.flush();
        } else {
            out.print("legion");
            out.flush();
        }
    }
}