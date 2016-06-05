package firsttask.consumers;

import firsttask.annotations.InjectCache;
import firsttask.interfaces.CacheInterface;

/**
 * Created by alexandermiheev on 05.06.16.
 */
public class ChildConsumer extends ParentConsumer {

    @InjectCache(injectCacheName = "random")
    private CacheInterface childCache;

    public ChildConsumer() {
        childCache = null;
    }

    public void childDataManipulation() {
        System.out.println(childCache.get(1));
    }
}
