package practisequestions;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
Say each alphabet is assigned a number value , now calculate the numeric value of your name. You cannot
count same alphabet twice if repeated.
**/

public class AlphabetCount {



    public int countAlphabetValue(String input) {
        //sort the input
        String sortedInput = Stream.of(input.split("")).sorted().collect(Collectors.joining());

        ArrayList<Integer> asciValueList = new ArrayList<>();

        //Checks the duplicate with the set and along find the sum
        Set<Character> uniqueElements = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();

        int sum = 0;
        for(Character c : sortedInput.toCharArray()){
            if(uniqueElements.add(c)){
                asciValueList.add((int) c);
                sum += (int) c;
                stringBuilder.append(c);
            }
        }

        System.out.println("String builder: " + stringBuilder);
        System.out.println("arrays: " + asciValueList.toString());
        return sum;
    }

    public static void main(String[] args) {
        AlphabetCount alphabetCount = new AlphabetCount();
        System.out.println("Value of your name is: "+  alphabetCount.countAlphabetValue("suraj"));
        System.out.println("Value of your name is: "+  alphabetCount.countAlphabetValue("ssuraaj"));
        System.out.println("Value of your name is: "+  alphabetCount.countAlphabetValue("surajj"));
    }
}
