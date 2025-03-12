/*
 * Fibonaci sequence using the N number of inputs
 * */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Fibonaci {

    public List<Integer> fibonacciByIteration(int n) {
        int numb1 = 0;
        int numb2 = 1;
        List<Integer> fibonaciSeries = new ArrayList<>(List.of(numb1, numb2));
        int nextElement;
        for (int i = 0; i < n; i++) {
            nextElement = numb1 + numb2;
            numb1 = numb2;
            numb2 = nextElement;
            fibonaciSeries.add(nextElement);
        }
        return fibonaciSeries;
    }


    public int fibonacciByRecursion(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciByRecursion(n - 1) + fibonacciByRecursion(n - 2);
    }


    public static void main(String[] args) {
//        System.out.println(new Fibonaci().fibonacciByIteration(10));
        int n = 10;
        Fibonaci fibonaci = new Fibonaci();
        for (int i = 0; i < n; i++) {
            System.out.println("i : " + fibonaci.fibonacciByRecursion(i));
        }
    }

}
