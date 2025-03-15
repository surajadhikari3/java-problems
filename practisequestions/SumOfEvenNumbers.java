package practisequestions;

import java.util.Scanner;

public class SumOfEvenNumbers {

    public int calculateSumOfEvenNumbers(int[] numbers){
        int sum = 0;
        for (int n: numbers) {
            if(n % 2 == 0) {
                sum += n;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements you want to find the sum \n");
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the number");
            int number = scanner.nextInt();
            System.out.println("You have entered: " + number);
            numbers[i] = number;
        }

        System.out.println("Sum is :" +  new SumOfEvenNumbers().calculateSumOfEvenNumbers(numbers));

    }
}
