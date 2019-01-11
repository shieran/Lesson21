package WaitNotify.Block;

import java.util.concurrent.locks.ReentrantLock;

public class CountThread implements Runnable {

    CommoResources res;
    ReentrantLock locker;

    public CountThread(CommoResources res, ReentrantLock locker) {
        this.res = res;
        this.locker = locker;
    }

    public void run(){
        try {
            locker.lock();
            res.x = 1;
            for (int i = 1; i < 5 ; i++) {
                System.out.printf("%s %d \n", Thread.currentThread().getName(), res.x);
                res.x++;
                Thread.sleep(100);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            locker.unlock();
        }
    }
}
