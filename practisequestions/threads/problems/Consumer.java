package practisequestions.threads.problems;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static practisequestions.threads.problems.Producer.queue;

public class Consumer implements Runnable {
    protected final static Map<String, Double> batchTotalVolume = new ConcurrentHashMap<>();
    protected final static Map<String, Integer> batchTotalCount = new ConcurrentHashMap<>();
    protected final static Map<String, Integer> batchTotalQuantity = new ConcurrentHashMap<>();
    private final String name;

    public Consumer(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < 10_000) {
            try {
                Trade trade = queue.take();
                Thread.sleep(100);
                if (System.currentTimeMillis() - trade.getTimeStamp() > 5_000) {
                    System.out.println(name + " Not Consumed For  More than 5 sec");
                } else {
                    batchTotalVolume.merge(trade.getSymbol(), trade.getPrice() * trade.getQuantity(), Double::sum); //this will sum and merge for existing state and if it is not present it will put for the first time
                    batchTotalCount.merge(trade.getSymbol(), 1, Integer::sum);
                    batchTotalQuantity.merge(trade.getSymbol(), trade.getQuantity(), Integer::sum);
                    System.out.println(name + " " + trade);
                }

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

    }
}
