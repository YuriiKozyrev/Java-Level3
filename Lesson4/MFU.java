package Java_Level3.Lesson4;

import java.util.concurrent.TimeUnit;

public class MFU {

    static final Object printingModule = new Object();

    public void printing(int i) throws InterruptedException {
        int delay = 1;
        for (int j = 0; j < 3; j++) {
            System.out.println("Печатаю Документ " + i + " - лист " + j + "......." );
            TimeUnit.SECONDS.sleep(delay);
        }
        System.out.println("Документ " + i + " напечатан!");
    }
    public void scanning(int i) throws InterruptedException {
        int delay = 1;
        for (int j = 0; j < 5; j++) {
            System.out.println("Сканирую Документ " + i + " - рисунок " + j + "......." );
            TimeUnit.SECONDS.sleep(delay);
        }
        System.out.println("Документ " + i + " отсканирован!");
    }
    public void copying(int i) throws InterruptedException {
        int delay = 1;
        for (int j = 0; j < 3; j++) {
            System.out.println("Копирую Документ " + i + " - копия " + j + "......." );
            TimeUnit.SECONDS.sleep(delay);
        }
        System.out.println("Документ " + i + " скопирован!");
    }

    public static void main(String[] args) {

        MFU mfu = new MFU();

        final int usersInPrintingQuery = 1;
        final int usersInScanningQuery = 1;
        final int usersInCopyingQuery = 1;

        Thread print = new Thread(() -> {
            synchronized (printingModule) {
                System.out.println("Печатный модуль захвачен потоком печати");
                for (int i = 0; i < usersInPrintingQuery; i++) {
                    try {
                        mfu.printing(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread scan = new Thread(() -> {
            for (int i = 0; i < usersInScanningQuery; i++) {
                try {
                    mfu.scanning(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread copy = new Thread(() -> {
            synchronized (printingModule){
                System.out.println("Печатный модуль захвачен потоком копирования");
                for (int i = 0; i < usersInCopyingQuery; i++) {
                    try {
                        mfu.copying(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        print.start();
        scan.start();
        copy.start();

    }
}
