package firsttask;

import firsttask.caches.AlphabetCache;
import firsttask.caches.RandomWordCache;
import firsttask.consumers.BackwardConsumer;
import firsttask.consumers.Consumer;
import firsttask.consumers.UpperCaseConsumer;
import firsttask.providers.CacheProvider;

/**
 * Created by alexandermiheev on 03.06.16.
 */
public class Main {
    public static void main(String[] args) {
        RandomWordCache lolz = new RandomWordCache();
        AlphabetCache lolzz = new AlphabetCache();
        CacheProvider.provideRandomCache(lolz);
        CacheProvider.provideAlphabetCache(lolzz);
        Consumer lol = new UpperCaseConsumer();
        BackwardConsumer lol2 = new BackwardConsumer();

        CacheInjector.inject(lol);
        CacheInjector.inject(lol2);
        lol.cacheManipulation();
        lol2.cacheManipulation();



    }
}
