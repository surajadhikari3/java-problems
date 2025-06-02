package practisequestions.threads.problems;

import java.util.Random;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedTrade extends Trade implements Delayed {
    private final long triggerTime; // absolute time in millis when trade should be released

    public DelayedTrade(long id, String symbol, int quantity, double price, long timeStamp, long delay) {
        super(id, symbol, quantity, price, timeStamp);
        this.triggerTime = System.currentTimeMillis() + delay;
    }

    @Override //returns how much delay time it has to implement it
    public long getDelay(TimeUnit unit) {
        long remainingTime = this.triggerTime - System.currentTimeMillis();
        return unit.convert(remainingTime, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if (o instanceof DelayedTrade) {
            return Long.compare(this.triggerTime, ((DelayedTrade) o).triggerTime);
        }
        return 0;
    }

    public static DelayedTrade generateRandomTrade() {
        final Random random = new Random();
        long id = random.nextInt(1000);
        String symbol = tickerSymbols[random.nextInt(tickerSymbols.length)];
        int quantity = random.nextInt(100) + 1;
        double price = (random.nextDouble() + 1) * 1000;
        long timeStamp = System.currentTimeMillis();
        long delay = random.nextInt(200);
        return new DelayedTrade(id, symbol, quantity, price, timeStamp, 800);
    }

}
