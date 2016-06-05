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

        double average = stream.limit(10).mapToInt(Person::getAge).average().getAsDouble();
        System.out.println(average);
    }

    public void sortPeopleByAge() {
        System.out.println("Sort people by age");
        Supplier<Person> personSupplier = PersonSupplier::getPerson;
        Stream<Person> stream = Stream.generate(personSupplier);

        stream.limit(10).sorted().forEach(System.out::println);
    }

    public void groupPeopleByNameAndAge() {
        System.out.println("Group people by their names and the size of each name-group");
        Supplier<Person> personSupplier = PersonSupplier::getPerson;
        Stream<Person> stream = Stream.generate(personSupplier);

        Map<String, Long> result = stream.limit(10).collect(Collectors.groupingBy(Person::getName, Collectors.counting()));
        for (String key: result.keySet()) {
                  System.out.println(key + " " + result.get(key));
        }

    }

    public void femaleAgeDecrease() {
        System.out.println("Applying a function, which reduce every women age by ten, or left the same in case if it's non-positive");
        Supplier<Person> personSupplier = PersonSupplier::getPerson;
        Stream<Person> stream = Stream.generate(personSupplier);

        stream.limit(20)
                .map(new Function<Person, Person>() {
                    @Override
                    public Person apply(Person person) {
                        System.out.println("Before: " + person.toString());
                        System.out.print("After: ");
                        return person;
                    }
                })
                .map(new Function<Person, Person>() {
                    @Override
                    public Person apply(Person person) {
                        if (person.getSex() == Sex.FEMALE) {
                            int currentAge = person.getAge();

                            if (currentAge > 10) {
                                person.setAge(currentAge - 10);
                            }

                        }
                        return person;
                    }
                }).forEach(System.out::println);
    }

    public void adultFilter() {
        System.out.println("Removing from the stream everyone who is younger than 18 years old");
        Supplier<Person> personSupplier = PersonSupplier::getPerson;
        Stream<Person> stream = Stream.generate(personSupplier);
        stream.limit(10).filter(p -> p.getAge() >= 18).forEach(System.out::println);
    }

    public void run() {
        findAverageAge();
        sortPeopleByAge();
        groupPeopleByNameAndAge();
        femaleAgeDecrease();
        adultFilter();
    }
}
