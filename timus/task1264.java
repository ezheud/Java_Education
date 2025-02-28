package timus;

import java.io.PrintWriter;
import java.util.Scanner;

//Написать программу, которая подсчитает число секунд, которые потребуется Петечкину на написание кода.

public class task1264 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            PrintWriter out = new PrintWriter(System.out);
            System.out.println("Введите число M и N:");
            int number1 = in.nextInt();
            int number2 = in.nextInt();
            out.print(number1 * (number2+1));
            out.flush();
        }
    }