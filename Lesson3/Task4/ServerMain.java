package Java_Level3.Lesson3.Task4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

    public final static String FILE_TO_SEND = "stud.ser";

    public static void createStudent () throws IOException {
        Student student = new Student(3,"Вася");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_TO_SEND));
        oos.writeObject(student);
        System.out.println("Объект " + FILE_TO_SEND + " создан");
        oos.close();
    }

    public static void main(String[] args) throws IOException {

        ServerSocket server = null;
        Socket socket = null;
        BufferedInputStream bis = null;
        OutputStream os = null;

        createStudent();

        try {
            server = new ServerSocket(8189);
            System.out.println("Сервер запущен");
            socket = server.accept();

            os = socket.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(FILE_TO_SEND));

            File file = new File(FILE_TO_SEND);
            byte[] bytes = new byte[(int) file.length()];

            bis.read(bytes);
            System.out.println("Передаем " + FILE_TO_SEND + "(" + bytes.length + " байт)");

            os.write(bytes);
            os.flush();
            System.out.println("Передача завершена");


            bis.close();
            os.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
