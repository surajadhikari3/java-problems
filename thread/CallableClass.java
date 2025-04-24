package thread;

import java.util.concurrent.*;

public class CallableClass implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "Executing from the callable";
    }

    // Use Callable when you need a result or exception handling.
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(new CallableClass());

        System.out.println(future.get());
        executorService.shutdown();
    }
}
