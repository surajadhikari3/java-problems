package practisequestions.streams.practise.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class PersonSecondTransformation {
    public static void main(String[] args) {
        PersonSecond suraj = new PersonSecond("suraj", "adhikari");
        PersonSecond chris = new PersonSecond("chris", "brown");
        PersonSecond hina = new PersonSecond("hina", "purple");
        List<PersonSecond> people = new ArrayList<>();
        people.add(suraj);
        people.add(chris);
        people.add(hina);

        List<PersonSecond> sorted = people.stream().sorted(Comparator.comparing(PersonSecond::getLastName).thenComparing(PersonSecond::getFirstName)).toList();
        System.out.println(sorted);
    }
}
