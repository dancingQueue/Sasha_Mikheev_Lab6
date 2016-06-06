package secondtask;

import secondtask.entities.Person;
import secondtask.entities.Sex;
import secondtask.suppliers.PersonSupplier;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by alexandermiheev on 05.06.16.
 */
public class Run {

    public void findAverageAge() {
        System.out.println("Finding an average age of all people");
        Supplier<Person> personSupplier = PersonSupplier::getPerson;
        Stream<Person> stream = Stream.generate(personSupplier);

        double average = stream.limit(10).map(p -> {
                System.out.println("Before:" + p.toString());
                return p;
            }).mapToInt(Person::getAge).average().getAsDouble();
        System.out.println("Average age is " + average);
    }

    public void sortPeopleByAge() {
        System.out.println("Sort people by age");
        Supplier<Person> personSupplier = PersonSupplier::getPerson;
        Stream<Person> stream = Stream.generate(personSupplier);

        stream.limit(10).map(p -> {
            System.out.println("Before:" + p.toString());
            return p;
        }).sorted((p1, p2) -> (p1.getAge() - p2.getAge())).forEach(p -> System.out.println("After: " + p.toString()));
    }

    public void groupPeopleByNameAndAge() {
        System.out.println("Group people by their names and the size of each name-group");
        Supplier<Person> personSupplier = PersonSupplier::getPerson;
        Stream<Person> stream = Stream.generate(personSupplier);

        Map<String, Long> result = stream.limit(10).map(p -> {
            System.out.println("Before:" + p.toString());
            return p;
        }).collect(Collectors.groupingBy(Person::getName, Collectors.counting()));
        for (String key: result.keySet()) {
                  System.out.println(key + " " + result.get(key));
        }

    }

    public void femaleAgeDecrease() {
        System.out.println("Applying a function, which reduce every women age by ten, or left the same in case if it's non-positive");
        Supplier<Person> personSupplier = PersonSupplier::getPerson;
        Stream<Person> stream = Stream.generate(personSupplier);

        stream.limit(20).map(p -> {
            System.out.println("Before:" + p.toString());
            return p;
        })
                .map(p -> {
                    if (p.getSex() == Sex.valueOf("FEMALE")) {
                        int age = p.getAge();
                        if (age - 10 > 0) {
                            p.setAge(age - 10);
                        }
                    }
                    return p;
                }).forEach(p -> System.out.println("After: " + p.toString()));
    }

    public void adultFilter() {
        System.out.println("Removing from the stream everyone who is younger than 18 years old");
        Supplier<Person> personSupplier = PersonSupplier::getPerson;
        Stream<Person> stream = Stream.generate(personSupplier);
        stream.limit(10).map(p -> {
            System.out.println("Before:" + p.toString());
            return p;
        }).filter(p -> p.getAge() >= 18).forEach(p -> System.out.println("After: " + p.toString()));
    }

    public void run() {
        findAverageAge();
        sortPeopleByAge();
        groupPeopleByNameAndAge();
        femaleAgeDecrease();
        adultFilter();
    }
}
