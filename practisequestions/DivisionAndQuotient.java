package practisequestions;

/**
 Divide m / n and provide reminder and quotient
 */

public class DivisionAndQuotient {

    public void division(float m, float n) {

        float remainder = m % n;
        float quotient = m / n;

        System.out.println("Remainder is : " + remainder + " Quotient is: " + quotient);

    }

    public static void main(String[] args) {
        new DivisionAndQuotient().division(100, 2);
    }

}
