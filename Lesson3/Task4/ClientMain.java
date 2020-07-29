package Java_Level3.Lesson3.Task4;

import java.io.*;
import java.net.Socket;


public class ClientMain {

    public final static String FILE_TO_RECEIVED = "IOTEst/the_same_stud.ser";

    public static void createStudentFromSer () throws IOException, ClassNotFoundException {

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_TO_RECEIVED));
        Student s2 = (Student)ois.readObject();
        ois.close();
        s2.info();
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        int maxFileSize = 1024;
        Socket socket = null;
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;

        try {
            socket = new Socket("localhost", 8189);
            System.out.println("Клиент запущен");
            byte[] bytes = new byte[maxFileSize];
            InputStream is = socket.getInputStream();
            bos = new BufferedOutputStream(new FileOutputStream(FILE_TO_RECEIVED));

            int bytesRead = is.read(bytes);

            bos.write(bytes, 0, bytesRead);
            bos.flush();
            System.out.println("Файл " + FILE_TO_RECEIVED + " загружен (" + bytesRead + " байт)");

            createStudentFromSer();

            bos.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}