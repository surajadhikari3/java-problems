package practisequestions;

import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * Leaders in an Array. Given a sequence of numbers. Find all leaders in the sequence. An element is called a
 * leader if it is strictly greater than all elements to its right side.
 * Input = arr[] = {12, 22, 39, 9, 4}
 * Output = 4, 9, 39
 */

public class LeadersInArray {
    public static void main(String[] args) {
        int[] input = {12, 22, 39, 9, 4, 5, 2};
        ArrayList<Integer> leaders = new ArrayList<>();


//        1st approach with the time complexity of O(n2)...

//        for (int i = 0; i < input.length; i++) {
//            int referenceElement = input[i];
//            for (int j = i + 1; j < input.length; j++) {
//                if (referenceElement < input[j]) {
//                    break;
//                }
//                if (j == input.length - 1) {
//                    leaders.add(referenceElement);
//                }
//            }
//        }
//
//        System.out.println("Leaders: " + leaders.stream().sorted().toList().toString());

        //2nd approach reduce the complexity to O(n)
//        int maxElement = input[input.length - 1];
//        for (int i = input.length - 2; i >= 0; i--) {
//            if (input[i] > maxElement) {
//                maxElement = input[i];
//                leaders.add(maxElement);
//            }
//        }
//        System.out.println("Leaders: " + leaders.stream().sorted().toList().toString());


        //3rd approach streams api
        final int[] maxElement = {Integer.MIN_VALUE};

        IntStream.range(0, input.length)
                .map(i -> input[input.length-i-1])
                .filter(n -> {
                    if(n > maxElement[0]){
                        maxElement[0] = n;
                        leaders.add(maxElement[0]);
                        return true;
                    }
                    return false;
                })
//                .boxed()
                .forEach(System.out::println);
    }
}
