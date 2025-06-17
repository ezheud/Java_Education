package timus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class task1496 {
	
    public static void main(String[] args) throws IOException {
        String inputFileName = "timus_task/input.txt";
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
        try {
            BufferedReader bufferedReader =
                    oj ? new BufferedReader(new InputStreamReader(System.in)) :
                            new BufferedReader(new FileReader(inputFileName));
            String readLine = "";
            int size = Integer.parseInt(bufferedReader.readLine());
            int index = 0;
            String [] commands = new String[size];
            List<String> foundSpammers = new ArrayList<>();
            while ((readLine = bufferedReader.readLine()) != null) {
                commands[index] = readLine;
                index++;
            }
            for (int i = 0; i < commands.length; i++) {
                if (foundSpammers.contains(commands[i])) {
                    continue;
                }
                for (int g = i+1; g < commands.length; g++) {
                    if (commands[i].equals(commands[g])) {
                        foundSpammers.add(commands[i]);
                        break;
                    }
                }
            }
            for (int i = 0; i < foundSpammers.size(); i++) {
                System.out.println(foundSpammers.get(i));
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
