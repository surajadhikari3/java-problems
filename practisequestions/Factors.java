package practisequestions;

import java.util.ArrayList;
import java.util.Collections;

//Find all the factor's of a given number n
public class Factors {

    public ArrayList<Integer> findFactors(int n){
        ArrayList<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                factors.add(i);
                //factors come in pair so we will find it with the quotient.....
                if (i != n / i) {  // Avoid duplicate when n is a perfect square
                    factors.add(n / i);
                }
            }
        }
       Collections.sort(factors);
        return factors;
    }

    public static void main(String[] args) {
        Factors factors = new Factors();
        System.out.println(factors.findFactors(25).toString());
    }
}
