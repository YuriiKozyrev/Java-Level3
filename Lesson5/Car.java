package Java_Level3.Lesson5;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class Car implements Runnable {

    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }

    private final CyclicBarrier cb;
    private static final AtomicInteger whoIsTheFirstRacer = new AtomicInteger(0);

    private final Race race;
    private final int speed;
    private final String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CyclicBarrier cb) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.cb = cb;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            cb.await();

            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }

            if (whoIsTheFirstRacer.incrementAndGet() == 1) {
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Победитель гонок - " + name);
            }
            cb.await();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
