package firsttask.consumers;

import firsttask.annotations.InjectCache;
import firsttask.interfaces.Cache;

/**
 * Created by alexandermiheev on 05.06.16.
 */
public class ParentConsumer {

    @InjectCache(injectCacheName = "alphabet")
    private Cache parentCache;

    public void parentCacheManipulation() {
        System.out.println("Parent cache: " + parentCache.get(1));
    }

}
