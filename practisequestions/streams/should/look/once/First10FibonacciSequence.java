package practisequestions.streams.should.look.once;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class First10FibonacciSequence {
    public static void main(String[] args) {
//        IntStream.range(0, 10).map(x-> x)
        //fibonaci number = 0,1,1,2,3,5,8,13....

        //This is normal way to do the fibonaci way
//        int a = 0;
//        int b = 1;
//        List<Integer> fibonaci = new ArrayList<>(List.of(0, 1));
//        for (int i = 0; i < 10; i++) {
//            int sum = a + b;
//            a = b;
//            b = sum;
//            fibonaci.add(sum);
//        }
//
//        System.out.println(fibonaci);

        //Fibonaci from streams..........

        //Here the concept is the 0 and 1 is seed value as it is initial number and first element is the second element b= a and the next element is the sum..
/*        seed: starting value (here: {0, 1})

        unaryOperator: function to generate next value (here: {b, a+b})*/

        //in order to call the loop like recursion we use Stream.iterate for the known pattern and for the terminal operation we use the limit here...
        List<Integer> list = Stream.iterate(new int[]{0, 1}, pair -> new int[]{pair[1], pair[0] + pair[1]})
                .limit(10)
                .map(pair -> pair[0])
                .toList();
        System.out.println(list);


        int a = 0;
        int b= 1;
        List<Integer> integers = new ArrayList<>(List.of(0, 1));
        for (int i = 0; i < 10; i++) {
            int sum = a+ b;
            a = b;
            b = sum;
            integers.add(sum);
        }
        System.out.println(integers);

    }
}
