package practisequestions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Sorting {

    /**
     * for the sort () and sort(Comparable)
     * for the sorted(Comparable.compare(person -> person.getName()).reversed().thenComparing(person -> person.getAge())
     * for the map --> map.entrySet().stream().sorted(Map.Entry.compareByKey(Comparator.reverseOrder()))
     */

    public static void main(String[] args) {
        Map<String, Integer> test = new HashMap<>();
        test.put("john", 2);
        test.put("jack", 3);
        test.put("gagan", 1);
        test.put("aagan", 6);


        test.entrySet()
                .stream()
                .sorted(
                        Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder())
                                .thenComparing(Map.Entry.comparingByKey())

                ).forEach(System.out::println);


        test.entrySet()
                .stream().
                sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);

        test.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);


        //Sorting and collecting
        LinkedHashMap<String, Integer> sortedMap = test.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (a, b) -> a,
                                LinkedHashMap::new
                        ));

    }
}
