package Java_Level3.Lesson1.Fruits;

public class Main {
    public static void main(String[] args) {

        Apple apple = new Apple (1.0f);
        Orange orange = new Orange(1.5f);

        Box<Apple> box1 = new Box<>(apple);
        Box<Orange> box2 = new Box<>(orange);
        Box<Apple> box3 = new Box<>(apple);

        box1.addToBox(5, apple);
        box2.addToBox(10, orange);

        System.out.println("Вес коробки: " + box1.boxWeight());

        System.out.println("Сравнение коробок: " + box1.compareBoxes(box2));

        box1.fruitsMigration(box3);

        System.out.println("Вес коробки: " + box1.boxWeight());
        System.out.println("Вес коробки: " + box3.boxWeight());



    }
}
