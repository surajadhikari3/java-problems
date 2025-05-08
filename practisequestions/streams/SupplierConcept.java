package practisequestions.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SupplierConcept {
    public static void main(String[] args) {
        List<String> nameList = Arrays.asList("Suraj", "Bob", "Chris");

        Supplier<Stream<String>> nameListSupplier = nameList::stream;

        Stream<String> stream = nameList.stream();

        nameListSupplier.get().forEach(System.out::println);

        stream.forEach(System.out::println);
//Here we already consume the streams so while we try to consume it again it will throw the exceptions so now instead of using the streams we can use the Supplier..
//        String collect = stream.collect(Collectors.joining(" | ", "[", "]"));
//        System.out.println(collect);
        String collect = nameListSupplier.get().collect(Collectors.joining(" | ", "[", "]"));
        System.out.println(collect);
    }
}
