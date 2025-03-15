package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 In this version, both threads acquire the locks in the same order: lock1 first, then lock2. By following a consistent order
 for acquiring locks, we avoid the circular wait condition, which is the core cause of deadlock.

 **/

public class DeadLockPrevention {

    private static final Lock lock1 = new ReentrantLock();
    private static final Lock lock2 = new ReentrantLock();

    public void preventDeadLock() {
        Thread thread1 = new Thread(() -> {
            try {
                lock1.lock();
                System.out.println("Thread 1: -> Lock 1");
                Thread.sleep(100);
                lock2.lock();
                System.out.println("Thread 1: -> Lock 2");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                lock1.lock();
                System.out.println("Thread 2: -> Lock 1");
                Thread.sleep(100);
                lock2.lock();
                System.out.println("Thread 2: -> Lock 2");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        });

        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) {
        new DeadLockPrevention().preventDeadLock();
    }

}
