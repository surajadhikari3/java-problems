package practisequestions;

import java.util.Scanner;

public class Utility {

    public static <T> T[] takeInput(Class<T> type) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements to iterate \n");
        int n = scanner.nextInt();
//        T[] numbers = new T[n];
        T[] array = (T[]) java.lang.reflect.Array.newInstance(type, n);
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the number");


            if (type == Integer.class) {
                array[i] = type.cast(scanner.nextInt());
            } else if (type == String.class) {
                array[i] = type.cast(scanner.next());
            } else if (type == Double.class) {
                array[i] = type.cast(scanner.nextDouble());
            } else {
                System.out.println("Unsupported type");
                return null;
            }
            System.out.println("You have entered: " + array[i]);
        }
        return array;
    }
}

