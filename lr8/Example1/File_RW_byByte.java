package lr8.Example1;

import java.io.*;

public class File_RW_byByte {
    public static void main(String[] args) throws IOException {
        Reader in = null; // Можно сразу записать FileReader in = null;
        Writer out = null; // Можно сразу записать FileWriter out = null;

        try {
            in = new FileReader("E:\\MyFile1.txt"); // Файл для чтения
            out = new FileWriter("E:\\MyFile2.txt", true); // Файл для записи (разрешено добавление)

            // Данные считываются и записываются побайтно, как и для InputStream/OutputStream
            int oneByte; // Переменная, в которую считываются данные
            while ((oneByte = in.read()) != -1) {
                // out.write((char)oneByte); // Запись с уничтожением ранее существующих данных
                out.append((char) oneByte); // Запись с добавлением данных в конец
                System.out.print((char) oneByte);
            }
        } catch (IOException e) {
            System.out.println("Ошибка!!!! " + e);
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}