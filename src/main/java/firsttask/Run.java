package firsttask;

import firsttask.caches.AlphabetCache;
import firsttask.caches.RandomWordCache;
import firsttask.consumers.BackwardConsumer;
import firsttask.consumers.ChildConsumer;
import firsttask.consumers.ParentConsumer;
import firsttask.consumers.UpperCaseConsumer;
import firsttask.injectors.CacheInjector;
import firsttask.providers.CacheProvider;

/**
 * Created by alexandermiheev on 05.06.16.
 */
public class Run {

    private void fillingCachesInDifferentFields() {
        System.out.println("Filling caches");
        UpperCaseConsumer upperCaseConsumer = new UpperCaseConsumer();
        BackwardConsumer backwardConsumer = new BackwardConsumer();

        RandomWordCache randomWordCache = new RandomWordCache();
        AlphabetCache alphabetCache = new AlphabetCache();

        CacheProvider.provideAlphabetCache(alphabetCache);
        CacheProvider.provideRandomCache(randomWordCache);

        CacheInjector.inject(upperCaseConsumer);
        CacheInjector.inject(backwardConsumer);

        System.out.println("Upper case consumer caches manipulations: ");
        upperCaseConsumer.cacheManipulation();

        System.out.println("Backward consumer cache manipulations: ");
        backwardConsumer.cacheManipulation();

    }

    private void fillingParentClassFieldsWithCacheProperlyTest() {
        System.out.println("Filling parent private cache field annotated with @Cache");
        ParentConsumer parentConsumer = new ChildConsumer();
        RandomWordCache randomWordCache = new RandomWordCache();
        AlphabetCache alphabetCache = new AlphabetCache();

        CacheProvider.provideAlphabetCache(alphabetCache);
        CacheProvider.provideRandomCache(randomWordCache);

        CacheInjector.inject(parentConsumer);
        parentConsumer.parentCacheManipulation();

        ChildConsumer childConsumer = (ChildConsumer) parentConsumer;
        childConsumer.childCacheManipulation();
    }

    public void run() {
        fillingCachesInDifferentFields();
        fillingParentClassFieldsWithCacheProperlyTest();
    }
}
