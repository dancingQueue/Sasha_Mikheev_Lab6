package firsttask;

import firsttask.caches.AlphabetCache;
import firsttask.caches.RandomWordCache;
import firsttask.consumers.*;
import firsttask.injectors.CacheInjector;
import firsttask.providers.CacheProvider;

/**
 * Created by alexandermiheev on 03.06.16.
 */
public class Main {
    public static void main(String[] args) {
        new Run().run();
    }
}
