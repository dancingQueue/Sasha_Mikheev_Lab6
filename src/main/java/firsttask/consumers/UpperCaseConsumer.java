package firsttask.consumers;

import firsttask.annotations.Cache;
import firsttask.annotations.InjectCache;
import firsttask.interfaces.CacheInterface;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by alexandermiheev on 03.06.16.
 */

public class UpperCaseConsumer extends Consumer {

    @InjectCache(injectCacheName = "random")
    private CacheInterface cache;

    public UpperCaseConsumer() {
        cache = null;
    }

    public void cacheManipulation() {
        System.out.println(cache.get(1).toUpperCase());
    }
}
