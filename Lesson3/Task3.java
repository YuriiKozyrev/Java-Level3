package Java_Level3.Lesson3;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) throws IOException {

        int pageVolume = 1800;
        int pageNumber;
        byte[] arr = new byte[pageVolume];

        RandomAccessFile raf = new RandomAccessFile(("IOTest/task3.txt"), "r");
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\nВведите номер требуемой страницы: ");
            System.out.println("Для выхода из режима чтения введите 0");
            pageNumber = sc.nextInt();
            if (pageNumber == 0){
                break;
            } else {
                raf.seek((pageNumber - 1) * pageVolume);
                raf.read(arr);
                System.out.println(new String(arr));
            }
        } while (raf.read(arr) != -1);

        raf.close();
        sc.close();
    }
}