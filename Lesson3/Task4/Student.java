package Java_Level3.Lesson3.Task4;

import java.io.*;

public class Student implements Serializable {
    int id;
    String name;

    public Student(int id, String name){
        this.id = id;
        this.name = name;
    }

    public void info(){
        System.out.println(id + " " + name);
    }
}
