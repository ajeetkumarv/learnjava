package collections;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapOperations {
    public static void main(String[] args) {
        //example 1
        // key should be group of 5-10,11-15 and list of Person as value
        // https://www.baeldung.com/java-spliterator
        // individual age is easy right
        Map<Integer, List<Person>> map = getPeople()
                .stream()
                .collect(Collectors.groupingBy(Person::getAge));

        Map<String, Person> map2 = getPeople()
                .stream()
                //.collect(Collectors.toMap(Person::getName, p -> p, (p1,p2) -> p1.getAge() < p2.getAge() ? p1 : p2));
                .collect(Collectors.toMap(Person::getName, p -> p, MapOperations::getYounger));
                //.collect(Collectors.toUnmodifiableMap(Person::getName, p -> p, MapOperations::getYounger));

        /*
            This will generate error if using toUnmodifiableMap
         */
        //map2.put("N",new Person("H", 1));

        String csvNames = getPeople()
                .stream()
                .filter(p -> p.getAge() > 10)
                .map(Person::getName)
                .map(String::toUpperCase)
                .distinct()
                .collect(Collectors.joining(", "));

        System.out.println("CSV Names: " + csvNames);

        Map<Boolean, List<Person>> evenOddAges = getPeople()
                .stream()
                .collect(Collectors.partitioningBy(p -> p.getAge() % 2 ==0));

    }

    private static Person getYounger(Person p1, Person p2) {
        return p1.getAge() < p2.getAge() ? p1 : p2 ;
    }

    private static List<Person> getPeople() {
        List<Person> people = List.of(
                new Person("A", 1),
                new Person("B", 2),
                new Person("C", 5),
                new Person("D", 6),
                new Person("E", 8),
                new Person("F", 11),
                new Person("G", 12),
                new Person("H", 12),
                new Person("I", 15),
                new Person("J", 15),
                new Person("J", 25)
        );
        return people;
    }

}
