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


    //Key takeaway is in the map use map.merge to aggregate the value as it takes the additional bi-function for summation and aggregate based for the same key
    //for checking the time initial time should be out of the loop and the System.currentTimeMills() can be in the loop. But if we want to run within every 3 seconds not every loop have to reset the initial print time too..

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

    //Problem 1 to 3 for the problem given in this mssg thread
    // https://chatgpt.com/share/6828c7d4-d38c-8007-917c-f9f609d7b913
    public static void main(String[] args) {

        BlockingQueue<Trade> queue = new ArrayBlockingQueue<Trade>(100);
        Map<String, Double> batchTotalVolume = new HashMap<>();
        Map<String, Integer> batchTotalCount = new HashMap<>();
        Map<String, Integer> batchTotalQuantity = new HashMap<>();

        Thread producerThread = new Thread(() -> {
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start < 10_000) {
                Trade trade = generateRandomTrade();
                try {
                    queue.put(trade);
//                    System.out.println("Produced " + trade);
                    Thread.sleep(100);
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
                    Trade trade = queue.poll(1, TimeUnit.SECONDS); //take is waiting indifiently for getting the mssg wheras poll wait for max definite time if the item is not present after the time is passed it will return the null if nothing is present instead of blocking it indefinitely....
                    if (trade != null) {
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
                                double average = totalPrice / count;
                                System.out.println("Average price for " + symbol + " " + average);
                                System.out.println("Quantity is " + symbol + " " + totalQuantity);
                            }

                            System.out.println("Aggregated Snapshot");
                            System.out.println(batchTotalVolume);
                            startPrintTime = System.currentTimeMillis(); //have to reset the startPrintTime for logging in every 3 seconds..
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

