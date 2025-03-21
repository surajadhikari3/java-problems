package practisequestions;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Anagram {

    //Anagram strings are those strings that have the same characters, only the order of characters may be different..

    public boolean checkAnagram(String firstString, String secondString) {

        if (firstString.length() != secondString.length()) return false;
        String sortedFirstString = Stream.of(firstString.split(""))
                .sorted()
                .collect(Collectors.joining());

        String sortedSecondString = Stream.of(secondString.split(""))
                .sorted()
                .collect(Collectors.joining());

        for (int i = 0; i < sortedFirstString.length(); i++) {
                if (sortedFirstString.charAt(i) != sortedSecondString.charAt(i)) {
                    return false;
                }
            }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("IsAngaram: " + new Anagram().checkAnagram("poppies", "pppoies"));
        System.out.println("IsAngaram: " + new Anagram().checkAnagram("poppies", "pipoies"));
        System.out.println("IsAngaram: " + new Anagram().checkAnagram("jack", "ackt"));
    }
}
