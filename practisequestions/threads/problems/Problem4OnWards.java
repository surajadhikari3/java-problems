package practisequestions.threads.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


//Here we can demonstrate two cases
// 1 is producer slow --> Consumer is blocked for taking the trade
// and another is consumer slow --> Producer is filled up and blocked due to array blocking queue max capacity reached...

/**
 Case	                        What it shows	            Key method
 Fast Producer, Slow Consumer	Backpressure on producer	queue.put() blocks
 Slow Producer, Fast Consumer	Backpressure on consumer	queue.take() blocks

 concept is whoever is fast backpressure is on it as they are blocked to produce or consume
* */


public class Problem4OnWards {

    record Trade(long id, String symbol, int quantity, double price, long timeStamp) {
    }

    private static final String[] tickerSymbols = {"AAPL", "GOOG", "TSLA", "CCPL"};


    public static Trade generateRandomTrade() {
        final Random random = new Random();
        long id = random.nextInt(1000);
        String symbol = tickerSymbols[random.nextInt(tickerSymbols.length)];
        int quantity = random.nextInt(100) + 1;
        double price = (random.nextDouble() + 1) * 1000;
        long timeStamp = System.currentTimeMillis();
        return new Trade(id, symbol, quantity, price, timeStamp);
    }

    public static void main(String[] args) {


        BlockingQueue<Trade> queue = new ArrayBlockingQueue<Trade>(10); //Problem 4
        Map<String, Double> batchTotalVolume = new HashMap<>();
        Map<String, Integer> batchTotalCount = new HashMap<>();
        Map<String, Integer> batchTotalQuantity = new HashMap<>();

        Thread producerThread = new Thread(() -> {
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start < 10_000) {
                Trade trade = generateRandomTrade();
                try {
                    System.out.println("Attempting to Produce " + trade);
                    queue.put(trade);
                    System.out.println("Successfully Produced " + trade);
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread consumerThread = new Thread(() -> {
            long start = System.currentTimeMillis();
            long startPrintTime = System.currentTimeMillis();

            while (System.currentTimeMillis() - start < 10_000) {
                try {
                    System.out.println("Trying to Consume");
                    Trade trade = queue.take();
                    System.out.println("Consumed");
                    Thread.sleep(1500); //Making the slow consumer
                    if (System.currentTimeMillis() - trade.timeStamp > 5_000) {
                        System.out.println("Not Consumed For More than 5 sec");
                    } else {
                        batchTotalVolume.merge(trade.symbol, trade.price * trade.quantity, Double::sum); //this will sum and merge for existing state and if it is not present it will put for the first time
                        batchTotalCount.merge(trade.symbol, 1, Integer::sum);
                        batchTotalQuantity.merge(trade.symbol, trade.quantity, Integer::sum);
                        System.out.println("Consumed " + trade);
                    }
                    //Print on every 3 seconds
                    if (System.currentTimeMillis() - startPrintTime >= 3_000) {
                        for (String symbol : tickerSymbols) {
                            Double totalPrice = batchTotalVolume.get(symbol);
                            Integer totalQuantity = batchTotalQuantity.get(symbol);
                            Integer count = batchTotalCount.get(symbol);
                            double average = 0;
                            if (totalPrice != null && count != null) {
                                average = totalPrice / count;
                            }
                            System.out.println("Average price for " + symbol + " " + average);
                            System.out.println("Quantity is " + symbol + " " + totalQuantity);
                        }

                        System.out.println("Aggregated Snapshot");
                        System.out.println(batchTotalVolume);
                        startPrintTime = System.currentTimeMillis(); //have to reset the startPrintTime for logging in every 3 seconds..
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        producerThread.start();
        consumerThread.start();

    }
}
