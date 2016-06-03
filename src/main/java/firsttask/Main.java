package firsttask;

import firsttask.caches.DictionaryCache;
import firsttask.consumers.UpperCaseConsumer;

/**
 * Created by alexandermiheev on 03.06.16.
 */
public class Main {
    public static void main(String[] args) {
        DictionaryCache lolz = new DictionaryCache();

        for (int i = 0; i < 5; i++) {
            lolz.put(i, "0");
        }

        UpperCaseConsumer lol = new UpperCaseConsumer();

        CacheInjector.inject(lol);
        lol.printTest();

    }
}
