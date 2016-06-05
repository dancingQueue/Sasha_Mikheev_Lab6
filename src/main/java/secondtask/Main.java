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
        new Run().run();
    }
}
