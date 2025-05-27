package practisequestions.threads.problems;


import java.util.concurrent.*;

import static practisequestions.threads.problems.Trade.tickerSymbols;


public class MultilpleProducerAndConsumer {

    public static void main(String[] args) {
       Thread loggerThread = new Thread(() -> {
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start < 10_000) {
                try {
                    Thread.sleep(3000); //Loger thread runs every 3 seconds..
                    for (String symbol : tickerSymbols) {
                        Double totalPrice = Consumer.batchTotalVolume.get(symbol);
                        Integer totalQuantity = Consumer.batchTotalQuantity.get(symbol);
                        Integer count = Consumer.batchTotalCount.get(symbol);
                        double average = totalPrice / count;
                        System.out.println("--Average price for " + symbol + " " + average);
                        System.out.println("Quantity is " + symbol + " " + totalQuantity);
                    }

                    System.out.println("Aggregated Snapshot");
                    System.out.println(Consumer.batchTotalVolume);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

        });

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(new Producer("producer1"));
        executorService.submit(new Producer("producer2"));
        executorService.submit(new Producer("producer3"));
        executorService.submit(new Consumer("consumer1"));
        executorService.submit(new Consumer("consumer2"));
        executorService.submit(loggerThread);

    }

}
