package SemaphoreExmpl;

import java.util.concurrent.Semaphore;

public class Philosopher extends Thread {
    Semaphore sem;
    int num = 0;
    int id;

    public Philosopher(Semaphore sem, int id) {
        this.sem = sem;
        this.id = id;
    }

    public void run(){
        try {
            while (num < 3){
                sem.acquire();
                System.out.println("filosof " + id + " saditsia za stol");
                sleep(500);
                num++;
                System.out.println("filosof " + id + " vihodit iz-za stola");
                sem.release();
                sleep(500);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
