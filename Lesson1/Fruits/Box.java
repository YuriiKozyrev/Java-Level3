package Java_Level3.Lesson1.Fruits;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private final T fruit;

    public Box(T fruit){
        this.fruit = fruit;
    }

    ArrayList<T> boxStorage = new ArrayList<>();

    public void addToBox(int fruitQuantity, T fruit){
        for (int i = 0; i < fruitQuantity ; i++) {
            boxStorage.add(fruit);
        }
        System.out.println("В коробку добавлено " + fruitQuantity + " " + fruit.getClass());
    }

    public float boxWeight(){
        return boxStorage.size() * fruit.getWeight();
    }

    public boolean compareBoxes(Box box){
        return boxWeight() == box.boxWeight();
    }

    public void fruitsMigration(Box<T> boxDestination){
        boxDestination.boxStorage.addAll(this.boxStorage);
        this.boxStorage.clear();
        System.out.println("Пересыпали фрукты: ");
    }

}
