package practisequestions.loyalcustomer;

import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LoyalCustomers {

    private static Set<String> findLoyalCustomers(String logFileDay1, String logFileDay2) throws FileNotFoundException {
        Map<String, Set<String>> day1Visits = LogParser.parseLogFiles(logFileDay1);
        Map<String, Set<String>> day2Visits = LogParser.parseLogFiles(logFileDay2);

        HashSet<String> loyalCustomers = new HashSet<>();

        for (String customerId : day1Visits.keySet()) {
            if (day2Visits.containsKey(customerId)) {
                // Check if they visited at least 2 unique pages on both days as it set(Collection which we used inside map) it will be unique page..
                if (day1Visits.get(customerId).size() >= 2 && day2Visits.get(customerId).size() >= 2) {
                    loyalCustomers.add(customerId);
                }
            }
        }
        return loyalCustomers;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Set<String> loyalCustomers = findLoyalCustomers("resources/log_day1.csv", "resources/log_day2.csv");
        loyalCustomers.stream()
                .sorted(Comparator.comparingInt(s -> Integer.parseInt(s.substring(1))))
                .forEach(System.out::println);
    }
}
