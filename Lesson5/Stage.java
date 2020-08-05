package Java_Level3.Lesson5;

public abstract class Stage {
    protected int length;
    protected int capacity;
    protected String description;

    public String getDescription() {
        return description;
    }

    public abstract void go(Car c);
}
