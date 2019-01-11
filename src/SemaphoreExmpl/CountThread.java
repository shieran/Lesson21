package SemaphoreExmpl;


import java.util.concurrent.Semaphore;

public class CountThread implements Runnable{
    CommonResources res;
    Semaphore sem;
    String name;

    public CountThread(CommonResources res, Semaphore sem, String name) {
        this.res = res;
        this.sem = sem;
        this.name = name;
    }

    public void run(){
        try {
            System.out.println(name + " ozhidaet razreshenie");
            sem.acquire();
            res.x = 1;
            for (int i = 1; i < 5; i++) {
                System.out.println(this.name + ": " + res.x);
                res.x++;
                Thread.sleep(100);
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(name + " osvobozhdaet razreshenie");
        sem.release();
    }
}
