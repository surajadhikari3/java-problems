package practisequestions;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * Swap two numbers a and b without using 3rd number
 **/

public class SwapNumbers {

    public void swapWithoutThirdNumber(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("Swapped Values after a: " + b + " b: " + a);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first element");
        int a = scanner.nextInt();

        System.out.println("Enter the Second element");
        int b = scanner.nextInt();

        new SwapNumbers().swapWithoutThirdNumber(a, b);

    }
}
