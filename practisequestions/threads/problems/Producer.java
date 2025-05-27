package practisequestions.threads.problems;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.DelayQueue;

public class Producer implements Runnable {

//    protected static final BlockingQueue<Trade> queue = new ArrayBlockingQueue<Trade>(100); //Problem 5
    protected static final DelayQueue<DelayedTrade> queue = new DelayQueue<DelayedTrade>(); //Problem 5
    private final String name;

    public Producer(String name) {
        this.name = name;
    }

    @Override
    public void run() {
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start < 10_000) {
                DelayedTrade trade = DelayedTrade.generateRandomTrade();
                try {
                    queue.put(trade);
                    System.out.println("Produced 1" + trade);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
    }
}
