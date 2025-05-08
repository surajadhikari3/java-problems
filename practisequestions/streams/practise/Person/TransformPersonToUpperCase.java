package practisequestions.streams.practise.Person;

import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TransformPersonToUpperCase {
    public static void main(String[] args) {
        Person suraj = new Person("Suraj", 26);
        Person pankaj = new Person("Pankaj", 31);
        Person chang = new Person("chang", 32);
        Person rang = new Person("Rang", 35);
        Person prank = new Person("Rang", 40);

        ArrayList<Person> people = new ArrayList<>();
        people.add(suraj);
        people.add(chang);
        people.add(pankaj);
        people.add(rang);
        people.add(prank);

        String collect = people.stream().map(person -> person.getName().toUpperCase()).collect(Collectors.joining(" | "));
        System.out.println(collect);
    }
}
