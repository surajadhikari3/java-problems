package practisequestions.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;

public class Concurent {
    public void test(){
        CompletableFuture.supplyAsync(()-> {
            return "hello";
        }).thenApply(result -> {
            return result + "word";
        }).thenAccept((f) -> {
            System.out.println(f);
        });
    }
}
