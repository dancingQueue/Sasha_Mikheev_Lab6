package firsttask;

import firsttask.caches.AlphabetCache;
import firsttask.caches.RandomWordCache;
import firsttask.consumers.*;
import firsttask.providers.CacheProvider;

/**
 * Created by alexandermiheev on 03.06.16.
 */
public class Main {

    public void test() {
        ParentConsumer parentConsumer = new ChildConsumer();
        RandomWordCache randomWordCache = new RandomWordCache();
        AlphabetCache alphabetCache = new AlphabetCache();

        CacheProvider.provideAlphabetCache(alphabetCache);
        CacheProvider.provideRandomCache(randomWordCache);

        CacheInjector.inject(parentConsumer);
        parentConsumer.dataManipulation();

        ChildConsumer childConsumer = (ChildConsumer) parentConsumer;

        childConsumer.childDataManipulation();
    }

    public static void main(String[] args) {
        new Run().run();
    }
}
