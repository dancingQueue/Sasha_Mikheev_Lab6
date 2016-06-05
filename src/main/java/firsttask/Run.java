package firsttask;

import firsttask.caches.AlphabetCache;
import firsttask.caches.RandomWordCache;
import firsttask.consumers.ChildConsumer;
import firsttask.consumers.ParentConsumer;
import firsttask.providers.CacheProvider;

/**
 * Created by alexandermiheev on 05.06.16.
 */
public class Run {

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

    public void run() {
        test();
    }
}
