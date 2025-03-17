package practisequestions;

// Find all the factor's of a given number n

public class Factorial {

    public void findFactorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        System.out.println("Factorial of " + n + " is :" + fact);
    }

    public int findFactorialRecursively(int n) {
        // while doing the recursion there should be stopping condn always so the line 16 and 17 is there...
        if (n == 0 | n == 1) {
            return 1;
        }
        return n * findFactorialRecursively(n - 1);
    }

    public static void main(String[] args) {
        new Factorial().findFactorial(10);
//        for (int i = 1; i < 3; i++) {
            System.out.println("Recursively: " + new Factorial().findFactorialRecursively(10));
//        }
    }
}
