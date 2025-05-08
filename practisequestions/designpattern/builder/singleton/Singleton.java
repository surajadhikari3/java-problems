package practisequestions.designpattern.builder.singleton;

/**
 Private constructor means the instance creation is within that class level not exposed to other...
 */


public class Singleton {
    private static Singleton instance;

    private Singleton(){}

    public synchronized static Singleton getInstance(){
        if(instance == null){
            return instance = new Singleton();
        }
        return instance;
    }

    public void displayMessage(){
        System.out.println("Single instance is created");
    }


}
