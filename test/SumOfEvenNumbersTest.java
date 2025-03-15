package test;

import org.junit.jupiter.api.Test;
import practisequestions.SumOfEvenNumbers;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumOfEvenNumbersTest {

    @Test
    void calculateSumOfEvenNumbers() {
        int[] evenNumbers = {2,4,6,10};
        SumOfEvenNumbers sumOfEvenNumbers = new SumOfEvenNumbers();
        int sum = sumOfEvenNumbers.calculateSumOfEvenNumbers(evenNumbers);
        assertEquals(22, sum);
    }
}