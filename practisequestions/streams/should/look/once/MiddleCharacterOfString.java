package practisequestions.streams.should.look.once;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**        need to consider even
         there will be two midpoint element
         and odd case
        There will be exactly one element..
        */

public class MiddleCharacterOfString {
    public static void main(String[] args) {

//        String s = "education";
        String s = "trave";
        int length = s.length();
        int midpoint = length/2;

//        String collect = IntStream.range(0, length) //upperbound is the exclusive so doing this
//                .filter(x -> length % 2 == 0 ? (x == midpoint || x == midpoint - 1) : x == midpoint)  //defining here the filter criteria based on the even and odd.....
//                .mapToObj(s::charAt)
//                .map(Object::toString) //converting to the string as the Collectors.joining takes the string not the sequence
//                .collect(Collectors.joining(""));
//        System.out.println(collect);

        String collect = IntStream.range(0, length)
                .filter(x -> length % 2 == 0 ? (x == midpoint || x == midpoint - 1) : x == midpoint)
                .mapToObj(x -> s.charAt(x))
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println(collect);

    }
}
