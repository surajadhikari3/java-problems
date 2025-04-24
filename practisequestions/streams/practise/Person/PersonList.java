package practisequestions.streams.practise.Person;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

 /*
Given a person list, fetch the list of names of a person
whose age is greater than 30
name should be unique
names should be in sorted order
*/
//Question no 44
public class PersonList {
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

        //1st approach
        people.stream()
                .filter(person -> person.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.groupingBy(Person::getName))
                .values().stream().filter(d -> d.size() == 1)
                .forEach(System.out::println);

        //2nd approach
        //From set the duplicate element will return atleast once.. .
        //It has shortcome that the set will give the duplicate element atleast once...
        HashSet<String> names = new HashSet<>();
        people.stream()
                .filter(person -> person.getAge() > 30)
                .filter(person -> names.add(person.getName()))
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
    }
}
