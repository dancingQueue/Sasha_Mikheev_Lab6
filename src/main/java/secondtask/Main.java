package secondtask;

import secondtask.entities.Person;
import secondtask.entities.Sex;
import secondtask.suppliers.PersonSupplier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by alexandermiheev on 04.06.16.
 */
public class Main {
    public static void main(String[] args) {
        Supplier<Person> personSupplier = PersonSupplier::getPerson;

        Stream<Person> stream = Stream.generate(personSupplier);
        //stream.limit(50).forEach(System.out::println);
        //stream.limit(50).filter(p -> p.getSex() == Sex.FEMALE).forEach(System.out::println);

        //double average = stream.limit(50).mapToInt(Person::getAge).average().getAsDouble();
        //System.out.println(average);

        //stream.limit(50).filter(p -> p.getAge() >= 18).forEach(System.out::println);
        //stream.limit(50).sorted().forEach(System.out::println);

     //   Map<String, Long> result = stream.limit(50).collect(Collectors.groupingBy(Person::getName, Collectors.counting()));

      //  for (String key: result.keySet()) {
      //      System.out.println(key + " " + result.get(key));
      //  }

        stream.limit(50).map(new Function<Person, Person>() {
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
}
