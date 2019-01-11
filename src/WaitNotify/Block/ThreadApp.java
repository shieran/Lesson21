//package WaitNotify.Block;
//
//import java.util.concurrent.locks.ReentrantLock;
//
//public class ThreadApp {
//    public static void main(String[] args) {
//        CommoResources commoResources = new CommoResources();
//        ReentrantLock locker = new ReentrantLock();
//        for (int i = 1; i < 6; i++) {
//            Thread t = new Thread(new CountThread(commoResources, locker));
//            t.setName("potok" + i);
//            t.start();
//        }
//    }
//}
