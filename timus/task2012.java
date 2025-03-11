package timus;

import java.io.PrintWriter;
import java.util.Scanner;

//В единственной строке записано целое число f — сколько задач хочет решить Гриша за первый час соревнования
//(1 ≤ f ≤ 11). Выведите «YES», если Грише в одиночку удастся решить все предложенные задачи, и «NO» в противном случае.

public class task2012 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int task_complete = in.nextInt();
        int all_task = 12;
        int time_min = 240;
        int time_to_make_task = 45;
        int remaining_task = all_task - task_complete;
        int time_remaining_task = remaining_task * time_to_make_task;
        if (time_min > time_remaining_task) {
            out.print("YES");
            out.flush();
        } else {
            out.print("NO");
            out.flush();
        }
    }
}