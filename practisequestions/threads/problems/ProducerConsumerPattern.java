package practisequestions.threads.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ProducerConsumerPattern {

    //Records is used for the POJO
//by default constructor and the getter method with the same name field
//you can also write your additional field like totalValue --> which is not supplied in the constructor but it is computed field..

    record Trade(long id, String symbol, int quantity, double price, long timeStamp) {
    }


    public static Trade generateRandoTrade() {
        String[] tickerSymbols = {"AAPL", "GOOG", "TSLA", "CCPL"};
        final Random random = new Random();
        long id = random.nextInt(1000);
        String symbol = tickerSymbols[random.nextInt(tickerSymbols.length)];
        int quantity = random.nextInt(100) + 1;
        double price = (random.nextDouble() + 1) * 1000;
        long timeStamp = System.currentTimeMillis();
        return new Trade(id, symbol, quantity, price, timeStamp);
    }

    public static void main(String[] args) {

        BlockingQueue<Trade> queue = new ArrayBlockingQueue<Trade>(100);
        Map<String, Double> aggregation = new HashMap<>();

        Thread producerThread = new Thread(() -> {
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start < 10_000) {
                Trade trade = generateRandoTrade();
                try {
                    queue.put(trade);
                    System.out.println("Produced " + trade);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread consumerThread = new Thread(() -> {
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start < 10_000) {
                try {
                    Trade trade = queue.poll(1, TimeUnit.SECONDS); //take is waiting indifiently for getting the mssg wheras poll wait for max definite time if the item is not present after the time is passed it will return the null if nothing is present instead of blocking it indefinitely....
                    if (trade != null) {
                        try {
                            aggregation.put(trade.symbol, trade.price * trade.quantity);
                            System.out.println(aggregation);
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                        if (System.currentTimeMillis() - trade.timeStamp > 5_000) {
                            System.out.println("Not Consumed For More than 5 sec");
                        } else {
                            System.out.println("Consumed " + trade);

                        }
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

