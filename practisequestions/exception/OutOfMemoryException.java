package practisequestions.exception;

import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryException {
    public static void main(String[] args) {
//        exceptionByThreadCreation();
        exceptionByObjectCreation();
    }

    public static void exceptionByObjectCreation() {
        List<byte[]> list = new ArrayList<>();
        while (true) {
            list.add(new byte[10 * 1024 * 1024]);
        }
    }

    public static void exceptionByThreadCreation() {
        while(true) {
            new Thread(() -> {
                try {
                    Thread.sleep(1000000);
                } catch (InterruptedException e) {
                }
            }).start();
        }
    }
}
