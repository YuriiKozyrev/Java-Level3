package Java_Level3.Lesson3;

import java.io.FileInputStream;
import java.io.IOException;

public class Task1 {
    public static void main(String[] args) throws IOException {

        FileInputStream in = new FileInputStream("IOTest/task1.txt");
        int x;
        byte[] arr = new byte[50];
        x = in.read(arr);
        System.out.println(new String(arr, 0, x));

        in.close();
    }
}
