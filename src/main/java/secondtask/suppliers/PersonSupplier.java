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

        int sex = random.nextInt(Sex.values().length);
        int currentAge = random.nextInt(40) + 1;

        resultPerson.setAge(currentAge);
        resultPerson.setSex(Sex.values()[sex]);

        if (sex == 0) {
            resultPerson.setName(femaleNames[random.nextInt(femaleNames.length)]);
        } else {
            resultPerson.setName(maleNames[random.nextInt(maleNames.length)]);
        }

        return resultPerson;

    }


}
