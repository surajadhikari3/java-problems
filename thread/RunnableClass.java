package thread;


// Use Runnable if you don’t need a return value.
public class RunnableClass implements Runnable {
    @Override
    public void run() {
        System.out.println("Executing the task in the Runnable");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableClass());
        thread.start();
    }
}
