package practisequestions;


import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Print the count of each characters in the input string
public class CharacterCount {

    public HashMap<Character, Integer> characterCount(String input) {
        String sortedInput = Stream.of(input.split("")).sorted().collect(Collectors.joining());
        HashMap<Character, Integer> countKeeper = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
//            countKeeper.put(input.charAt(i), countKeeper.containsKey(input.charAt(i)) ? countKeeper.get(input.charAt(i)) + 1 : 1);
            countKeeper.put(input.charAt(i), countKeeper.containsKey(input.charAt(i)) ? countKeeper.get(input.charAt(i)) + 1 : 1);
        }

        return countKeeper;
    }

    public static void main(String[] args) {
        HashMap<Character, Integer> countMapper = new CharacterCount().characterCount("joepiieosos");
        System.out.println("Character count: " + countMapper.toString());
    }
}