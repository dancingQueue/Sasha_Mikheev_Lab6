package firsttask;

import firsttask.caches.AlphabetCache;
import firsttask.caches.RandomWordCache;
import firsttask.consumers.*;
import firsttask.providers.CacheProvider;

/**
 * Created by alexandermiheev on 03.06.16.
 */
public class Main {
    public static void main(String[] args) {
//        RandomWordCache lolz = new RandomWordCache();
//        AlphabetCache lolzz = new AlphabetCache();
//        CacheProvider.provideRandomCache(lolz);
//        CacheProvider.provideAlphabetCache(lolzz);
//        Consumer lol = new UpperCaseConsumer();
//        BackwardConsumer lol2 = new BackwardConsumer();
//
//        CacheInjector.inject(lol);
//        CacheInjector.inject(lol2);
//        lol.cacheManipulation();
//        lol2.cacheManipulation();

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
}
