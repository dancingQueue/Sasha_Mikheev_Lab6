package firsttask.consumers;

import firsttask.annotations.InjectCache;
import firsttask.interfaces.Cache;

/**
 * Created by alexandermiheev on 03.06.16.
 */

public class UpperCaseConsumer {

    @InjectCache(injectCacheName = "random")
    private Cache randomCache;

    @InjectCache(injectCacheName = "alphabet")
    private Cache alphabetCache;

    public UpperCaseConsumer() {
        randomCache = null;
        alphabetCache = null;
    }

    public void cacheManipulation() {
        System.out.println(randomCache.get(1).toUpperCase());
        System.out.println(alphabetCache.get(1).toUpperCase());
    }
}
