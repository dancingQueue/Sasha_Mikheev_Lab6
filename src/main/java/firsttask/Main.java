package firsttask;

import firsttask.caches.DictionaryCache;
import firsttask.consumers.UpperCaseConsumer;
import firsttask.providers.CacheProvider;

/**
 * Created by alexandermiheev on 03.06.16.
 */
public class Main {
    public static void main(String[] args) {
        DictionaryCache lolz = new DictionaryCache();

        CacheProvider.provideCache(lolz);

        UpperCaseConsumer lol = new UpperCaseConsumer();

        CacheInjector.inject(lol);
        lol.manipulation();

    }
}
