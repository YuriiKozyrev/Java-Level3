package Java_Level3.Lesson5;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {


    public Tunnel(int length, int capacity) {
        this.length = length;
        this.capacity = capacity;

        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            Semaphore smp = new Semaphore(capacity);
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                smp.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                smp.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
