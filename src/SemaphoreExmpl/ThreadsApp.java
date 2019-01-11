package SemaphoreExmpl;


import java.util.concurrent.Semaphore;

public class ThreadsApp {
    public static void main(String[] args) {
//        Semaphore sem = new Semaphore(1);
//        CommonResources res = new CommonResources();
//        new Thread(new CountThread(res, sem, "CountThread 1")).start();
//        new Thread(new CountThread(res, sem, "CountThread 2")).start();
//        new Thread(new CountThread(res, sem, "CountThread 3")).start();

        Semaphore sem = new Semaphore(2);
        for (int i = 1; i < 6 ; i++) {
            new Philosopher(sem, i).start();
        }

    }
}
