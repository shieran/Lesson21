package WaitNotify;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Store {

    private int product = 0;
    ReentrantLock locker;
    Condition condition;

    public Store() {
        this.locker = new ReentrantLock();
        this.condition = locker.newCondition();
    }

    public void get() {
        try {
            locker.lock();
            while (product < 1) {
                condition.await();
            }
            product--;
            System.out.println("pokupatel kupil 1 tovar");
            System.out.println("tovarov na sklade " + product);
            condition.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }
    }

    public void put() {
        try {
            locker.lock();
            while (product >= 3) {
                condition.await();
            }
            product++;
            System.out.println("proizvoditel dobavil 1 tovar");
            System.out.println("tovarov na sklade " + product);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }
    }
}
