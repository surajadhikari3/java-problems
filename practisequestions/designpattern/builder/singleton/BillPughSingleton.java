package practisequestions.designpattern.builder.singleton;

//this pattern is best and simplest....

/**
 * Key Takeaways
 * ✅ static final ensures INSTANCE is created only once.
 * ✅ JVM class loading is thread-safe, preventing race conditions.
 * ✅ Lazy initialization: Instance is created only when getInstance() is first called as it is inside the static method..
 * ✅ Efficient and fast: No need for synchronization like synchronized blocks.
 */

public class BillPughSingleton {
    private BillPughSingleton(){}

    private static class SingletonHelper{
        private static final BillPughSingleton instance = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance(){
        return SingletonHelper.instance;
    }
}
