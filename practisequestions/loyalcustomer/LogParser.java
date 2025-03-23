package practisequestions.loyalcustomer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LogParser {

    public static Map<String, Set<String>> parseLogFiles(String filePath) throws FileNotFoundException {
        Map<String, Set<String>> customerVisits = new HashMap<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        br.readLine(); // skip the header line
        while ((line = br.readLine()) != null){
            String[] parts = line.split(",");
                String pageId = parts[1];
                String customerId = parts[2];
                customerVisits.putIfAbsent(customerId, new HashSet<>());
                customerVisits.get(customerId).add(pageId);
        }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return customerVisits;
    }

}
