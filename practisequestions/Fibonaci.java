package practisequestions;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * 8. Find the first 100 numbers in the fibonnci series using regular and recursion approach
 * Find the first 100 numbers in the fibonnci series and provide the sum of all the numbers
 * Find the first 100 numbers in the fibonnci series and provide the sum of all the even numbers in the series
 * Find the first 100 numbers in the fibonnci series and provide the sum of all the odd numbers in the series
 * Find the first 100 numbers in the fibonnci series and provide the sum of all the prime numbers in the series
 * <p>
 * Notes: Fibonacii series grows longer so make sure u use the BIGINTEGER instead of int
 **/

public class Fibonaci {

    //using the memoization (Top-down  approach like similar to cache since the other previous value is prior computed

    private Map<Integer, BigInteger> memo = new HashMap<>();


    public void findFibonaciSeriesRegular(int n) {
        BigInteger firsNumber = BigInteger.ZERO;
        BigInteger secondNumber = BigInteger.ONE;
        BigInteger thirdNumber;


        for (int i = 0; i < n; i++) {
            if (i == 0 || i == 1) {
                System.out.println("Fibonacci Series: " + i);
                continue;
            }
            thirdNumber = firsNumber.add(secondNumber);
            firsNumber = secondNumber;
            secondNumber = thirdNumber;
            System.out.println("Fibonacci Series: " + i + " " + thirdNumber);
        }
    }

    public BigInteger findFibonaciWithRecursion(int n) {

        if (n == 0) return BigInteger.ZERO;
        if (n == 1) return BigInteger.ONE;

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        BigInteger result = findFibonaciWithRecursion(n - 1).add(findFibonaciWithRecursion(n - 2));
        memo.put(n, result);
        return result;
    }

    public static void main(String[] args) {
//        new Fibonaci().findFibonaciSeriesRegular(100);

        for (int i = 0; i < 100; i++) { //For getting the sequence if fibinacii numbers...
            System.out.println("Fibonaaci : " + i + " " + new Fibonaci().findFibonaciWithRecursion(i));
        }

        System.out.println("Fiboo " + new Fibonaci().findFibonaciWithRecursion(10)); //For getting the speicific fibonnaci

    }


}
