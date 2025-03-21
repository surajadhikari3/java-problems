package practisequestions.conceptswithexample;

import java.util.stream.IntStream;

/**
 Concurrency vs. Parallelism: Key Differences
  Feature	Concurrency 🏃	                               Parallelism 🏎️
  Execution	Tasks appear to run together (switching)	Tasks actually run together
  CPU Cores	One core (task switching)	                Multiple cores (simultaneous execution)
  Best for	I/O-heavy tasks, multitasking	             CPU-heavy tasks, number crunching
  Example	Handling 1000 HTTP requests	                 Matrix multiplication using all CPU cores
 */

public class ParallelismAndConcurrency {
        // Threads switch context but may not run at the exact same time.
        public void concurrencyExample(){
            Runnable task = () -> {
                System.out.println(Thread.currentThread().getName() + " is running");
            };
            for (int i = 0; i < 5; i++) {
                new Thread(task).start(); //Multiple threads start but switch execution...
            }
        }

//        ✔ Tasks actually run on multiple cores if available.
        public void parallelismExample(){
            IntStream.range(1,8)
                    .parallel() //Runs the multiple CPU cores
                    .forEach(i -> System.out.println(Thread.currentThread().getName() + "-" + i)); // you will see the execution order is different...
        }

    public static void main(String[] args) {
            new ParallelismAndConcurrency().concurrencyExample();
//        new ParallelismAndConcurrency().parallelismExample();
    }

}
