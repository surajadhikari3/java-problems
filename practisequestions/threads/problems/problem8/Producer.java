package practisequestions.threads.problems.problem8;

import practisequestions.threads.problems.Trade;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Producer implements Runnable {

    BlockingDeque<Trade> deque;

    Producer(LinkedBlockingDeque<Trade> deque) {
        this.deque = deque;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Trade trade = Trade.generateRandomTrade();
                this.deque.offer(trade);
                System.out.println("Produced........" + trade);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}