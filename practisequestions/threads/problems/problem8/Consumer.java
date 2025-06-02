package practisequestions.threads.problems.problem8;

import practisequestions.threads.problems.Trade;

import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;

public class Consumer implements Runnable {

    BlockingDeque<Trade> deque;


    public Consumer(LinkedBlockingDeque<Trade> deque) {
        this.deque = deque;
    }

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {
            try {
                while (!this.deque.isEmpty()) { //This while loop is for the eviction
                    Trade trade = this.deque.peekFirst();
                    long current = System.currentTimeMillis();
                    assert trade != null;
                    if (current - trade.getTimeStamp() > 10_000) {
                        this.deque.pollFirst();
                    } else {
                        break;
                    }
                }

                Map<String, Double> tradeVolume = new ConcurrentHashMap<>();
                Map<String, Integer> tradeCount = new ConcurrentHashMap<>();
                Map<String, Double> tradePrice = new ConcurrentHashMap<>();
                Map<String, Double> averagePrice = new ConcurrentHashMap<>();


                //After the eviction logging out all the metrics every time for updating the metrics too......
                for (Trade trade : deque) {
                    tradeVolume.merge(trade.getSymbol(), trade.getPrice() * trade.getQuantity(), Double::sum);
                    //price average per symbol.
                    tradeCount.merge(trade.getSymbol(), trade.getQuantity(), Integer::sum);
                    tradePrice.merge(trade.getSymbol(), trade.getPrice(), Double::sum);
                    averagePrice.put(trade.getSymbol(), tradePrice.get(trade.getSymbol()) / tradeCount.get(trade.getSymbol()));


                    System.out.println("Printing the logs ----------");
                    System.out.println("Trade Count......" + tradeCount);
                    System.out.println("Trade Price......" + tradePrice);
                    System.out.println("Trade Price......" + tradeVolume);
                    System.out.println("Trade Price......" + averagePrice);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }


    }
}
