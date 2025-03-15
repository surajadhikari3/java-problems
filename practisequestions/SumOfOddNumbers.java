package practisequestions;

public class SumOfOddNumbers {

   public int calculateSumOfOddNumbers(Integer[] numbers){
       int sum = 0;
            for(int n: numbers) {
                if(n% 2 != 0 ) {
                   sum += n;
                }
            }
            return sum;
    }

    public static void main(String[] args) {
        Integer[] integers = Utility.takeInput(Integer.class);
        System.out.println("Sum is: " + new SumOfOddNumbers().calculateSumOfOddNumbers(integers));
    }

}
