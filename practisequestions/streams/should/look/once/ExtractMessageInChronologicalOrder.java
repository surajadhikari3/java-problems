package practisequestions.streams.should.look.once;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ExtractMessageInChronologicalOrder {
    public static void main(String[] args) {
        List<String> logs = Arrays.asList(
                "14:30:3:Server started",
                "14:30:1:User logged in",
                "14:29:10:Database connected",
                "14:29:9:Booting up.....",
                "18:32:4:User logged out"
        );

        //it's better to convert to the integer while doing comparison as it get the
        List<String> list = logs.stream().sorted(Comparator.comparing((String log) -> log.split(":")[0]) //HH here when we apply the thenComparing it got converted to the object so we are mapping to the string..
                .thenComparing(log -> log.split(":")[1]) //min
                .thenComparing(log -> Integer.parseInt(log.split(":")[2])) //id here we are only considering the single digit id in the string but for the double and single digit comparison we convert to the int and do the comparison........
        ).map(log -> log.split(":")[3]).toList();

        System.out.println(list);
    }
}
