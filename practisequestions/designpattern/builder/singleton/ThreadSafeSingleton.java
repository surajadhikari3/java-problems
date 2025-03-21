package practisequestions.designpattern.builder.singleton;

public class ThreadSafeSingleton {

    public static volatile ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {}

    public static ThreadSafeSingleton getInstance() {
        if (instance == null) { // here first checking the instance is null before locking it
            synchronized (Singleton.class) { // if its null then only the lock is gained so it wont block the other thread for created instance  here we use Singleton.class instead of this keyword as it is static
                if (instance == null)
                    instance = new ThreadSafeSingleton();
            }
        }
        return instance;
    }
}
