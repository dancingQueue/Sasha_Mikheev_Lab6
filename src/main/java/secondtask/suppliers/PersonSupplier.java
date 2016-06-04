package secondtask.suppliers;

import secondtask.entities.Person;
import secondtask.entities.Sex;

import java.util.Random;
import java.util.function.Supplier;

/**
 * Created by alexandermiheev on 04.06.16.
 */
public class PersonSupplier {
    private static String[] maleNames = {"Alexander", "Evgeniy", "John", "Benjamin", "Vasiliy", "Vladimir"};
    private static String[] femaleNames = {"Alexandra", "Evgenia", "Anna", "Xenia", "Ekaterina", "Maria"};
    public static Person getPerson() {
        Person resultPerson = new Person();
        Random random = new Random();

        int sex = random.nextInt(2);

        if (sex == 1) {
            resultPerson.setAge(random.nextInt(40) + 1);
            resultPerson.setName(femaleNames[random.nextInt(femaleNames.length)]);
            resultPerson.setSex(Sex.FEMALE);
        } else {
            resultPerson.setAge(random.nextInt(40) + 1);
            resultPerson.setName(maleNames[random.nextInt(maleNames.length)]);
            resultPerson.setSex(Sex.MALE);
        }

        return resultPerson;

    }


}
