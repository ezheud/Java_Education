package lr8.Example1;

import java.io.*;
import java.net.URL;

public class InConvertInText {
    public static void readAllByByte(Reader in) throws IOException {
        while (true) {
            int oneByte = in.read(); // Читает 1 байт
            if (oneByte != -1) { // Признак конца файла
                System.out.print((char) oneByte);
            } else {
                System.out.print("\nконец");
                break;
            }
        }
    }

    public static void main(String[] args) {
        try {
            // С потоком связан файл
            InputStream inFile = new FileInputStream("E:\\MyFile1.txt"); // Байтовый поток
            Reader rFile = new InputStreamReader(inFile, "cp1251"); // Символьный поток (русская кодировка)

            readAllByByte(rFile);
            System.out.print("\n\n\n");

            inFile.close();
            rFile.close();

            // С потоком связана интернет-страница
            InputStream inUrl = new URL("http://google.com").openStream(); // Байтовый поток
            Reader rUrl = new InputStreamReader(inUrl, "cp1251"); // Символьный поток

            readAllByByte(rUrl);
            System.out.print("\n\n\n");

            inUrl.close();
            rUrl.close();

            // С потоком связан массив типа byte
            InputStream inArray = new ByteArrayInputStream(new byte[]{5, 8, 3, 9, 11});
            Reader rArray = new InputStreamReader(inArray, "cp1251"); // Символьный поток

            readAllByByte(rArray);
            System.out.print("\n\n\n");

            inArray.close();
            rArray.close();
        } catch (IOException e) {
            System.out.println("Ошибка: " + e);
        }
    }
}