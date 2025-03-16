package practisequestions;

import java.util.Scanner;

/**
 * Calculate the sum of prime numbers from 1 to 1000
 **/

public class SumOfPrimeNumbers {

    public boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SumOfPrimeNumbers sumOfPrimeNumbers = new SumOfPrimeNumbers();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the end range to calculate the prime number");
        int number = scanner.nextInt();

        int sum = 0;



        for (int i = 1; i <= number; i++) {
            boolean prime = sumOfPrimeNumbers.isPrime(i);
            sum += i;
            System.out.println("isPrime: " + i + " " + prime);
        }
        System.out.println("Sum is :" + sum);

    }

}
