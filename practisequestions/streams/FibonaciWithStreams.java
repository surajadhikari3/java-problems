package practisequestions.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FibonaciWithStreams {
    public static void main(String[] args) {
        // 0,1,1,2,3,5, 8, 13 , 21 --> first 10 number

        //1st iteration
        int a = 0;
        int b = 1;
        //  sum = a+ b  --> 1

        //2nd iteration
//        a= b;
//        b = sum;
//        sum = a+b;

        int[] initial = {0, 1};

        int[] array = Stream.iterate(new int[]{0, 1}, part -> new int[]{part[1], part[0] + part[1]})
                .limit(10)
                .mapToInt(x -> x[0])
//                .boxed()
                .toArray();
        System.out.println(Arrays.toString(array));
    }
}
