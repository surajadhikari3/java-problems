package practisequestions.threads.problems.problem8;

import practisequestions.threads.problems.problem8.Consumer;
import practisequestions.threads.problems.Trade;

import java.util.concurrent.*;

public class MainRunner {
    public static void main(String[] args) {

        LinkedBlockingDeque<Trade> windowTrade = new LinkedBlockingDeque<>();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Producer(windowTrade));
//        executorService.submit(new Producer(windowTrade));
        executorService.submit(new Consumer(windowTrade));

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);


        scheduledExecutorService.schedule(() -> { //Shutdown with the delay............
            System.out.println("shutting down the Thread pool........");
            executorService.shutdown();
            scheduledExecutorService.shutdownNow();
        }, 5, TimeUnit.SECONDS);

        //for ctl+c or docker stop or pod eviction shut dow,n
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            executorService.shutdownNow();
            scheduledExecutorService.shutdownNow();
        }));
    }
}
