package practisequestions.exception;

public class StackOverFlowException {
    public static void main(String[] args) {
        fibonaciWithoutTale(10000);
    }

    public static int fibonaciWithoutTale(int n){
        return  fibonaciWithoutTale(n-1) + fibonaciWithoutTale(n-2);
    }
}
