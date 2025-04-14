package thread;

import java.util.concurrent.ArrayBlockingQueue;

//Blocking queue for the thread communication...
public class BlockingQueue {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        Runnable producer = () -> {
            try{
                queue.put(1);
                System.out.println("Production 1");
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        };

        Runnable consumer = () -> {
                try {
                    System.out.println("consumer" + queue.take());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        };

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
