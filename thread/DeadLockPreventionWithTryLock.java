package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Timeout with Lock Try: Another method to prevent deadlocks is to use tryLock() with a timeout.
 * If a thread cannot acquire the lock within a specified time, it will stop waiting and can try again or handle the situation.
 **/

public class DeadLockPreventionWithTryLock {

    private static final ReentrantLock lock1 = new ReentrantLock();
    private static final ReentrantLock lock2 = new ReentrantLock();

    public void preventDeadLock() {
        Thread thread1 = new Thread(() -> {
            try {
                if (lock1.tryLock() && lock2.tryLock()) {
                    System.out.println("Thread 1: Acquired both locks ");
                } else {
                    System.out.println("Thread 1: Could not acquire locks, retrying...");
                }
            } finally {
                if (lock1.isHeldByCurrentThread()) lock1.unlock();
                if (lock2.isHeldByCurrentThread()) lock2.unlock();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                if (lock2.tryLock() && lock1.tryLock()) {
                    System.out.println("Thread 2: Acquired both locks");
                } else {
                    System.out.println("Thread 2: Could not acquire locks, retrying......");
                }
            } finally {
                if (lock2.isHeldByCurrentThread()) lock2.unlock();
                if (lock1.isHeldByCurrentThread()) lock1.unlock();
            }
        });

        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) {
        new DeadLockPreventionWithTryLock().preventDeadLock();
    }

}
