package firsttask.consumers;

import firsttask.annotations.InjectCache;
import firsttask.interfaces.Cache;

/**
 * Created by alexandermiheev on 05.06.16.
 */
public class ChildConsumer extends ParentConsumer {

    @InjectCache(injectCacheName = "random")
    private Cache childCache;

    public void childCacheManipulation() {
        System.out.println("Child cache: " + childCache.get(1));
    }
}
