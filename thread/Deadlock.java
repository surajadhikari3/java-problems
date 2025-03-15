package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Deadlock {
    private static final Lock lock1 = new ReentrantLock();
    private static final Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            try {
                lock1.lock();
                System.out.println("Thread 1: Lock 1 is acquired");

                //Simulate some work is done here so that the thread 2 can acquire the lock on lock2
                Thread.sleep(100);

                //try to acquire the lock on lock2
                lock2.lock();
                System.out.println("Thread 1: Acquired the lock on thread 2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        });

        Thread thread2 = new Thread(() -> {

            try {
                lock2.lock();
                System.out.println("Thread 2: Acquired the lock 2");

                Thread.sleep(100);

                //try to acquire the lock on lock 1

                lock1.lock();
                System.out.println("Thread 2: Acquired the lock 1");
            } catch (InterruptedException e) {
              e.printStackTrace();
            } finally {
                lock2.unlock();
                lock1.unlock();
            }
        });

        thread1.start();
        thread2.start();
    }
}
