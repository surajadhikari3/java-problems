package practisequestions.threads.problems;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static practisequestions.threads.problems.Consumer.batchAveragePrice;
import static practisequestions.threads.problems.Consumer.batchTotalVolume;
import static practisequestions.threads.problems.Trade.tickerSymbols;

public class Problem7 {

    public static void main(String[] args) {

        Runnable aggregatorLogger = () -> {
//                    Thread.sleep(5_000);
            for (String symbol : tickerSymbols) {
                System.out.println("Total Volume " + batchTotalVolume.get(symbol));
                System.out.println("Average Price " + batchAveragePrice.get(symbol));
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(new Producer("producer1"));
        executorService.submit(new Producer("producer2"));
        executorService.submit(new Producer("producer3"));
        executorService.submit(new Consumer("consumer1"));
        executorService.submit(new Consumer("consumer2"));

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(aggregatorLogger, 5, 5, TimeUnit.SECONDS);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("shutting down the thread...........");
            executorService.shutdown();
            scheduledExecutorService.shutdown();
        }));
    }
}