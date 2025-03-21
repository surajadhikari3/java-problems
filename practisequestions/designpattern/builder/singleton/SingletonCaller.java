package practisequestions.designpattern.builder.singleton;

public class SingletonCaller {

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        instance.displayMessage();
        System.out.println("Are two instance same: "+ instance + " " +  instance1);


        BillPughSingleton billPughSingleton = BillPughSingleton.getInstance();
        BillPughSingleton billPughSingleton1 = BillPughSingleton.getInstance();
        System.out.println("Are two billpugh instance same: "+ billPughSingleton + " " +  billPughSingleton1);
        System.out.println(billPughSingleton == billPughSingleton1);
    }
}

