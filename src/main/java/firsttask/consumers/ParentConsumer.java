package firsttask.consumers;

import firsttask.annotations.InjectCache;
import firsttask.interfaces.CacheInterface;

/**
 * Created by alexandermiheev on 05.06.16.
 */
public class ParentConsumer {

    @InjectCache(injectCacheName = "alphabet")
    private CacheInterface ParentCache;

    public ParentConsumer() {
        ParentCache = null;
    }

    public void dataManipulation() {
        System.out.println(ParentCache.get(1));
    }

}
