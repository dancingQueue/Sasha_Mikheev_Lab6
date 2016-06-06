package firsttask.consumers;

import firsttask.annotations.InjectCache;
import firsttask.interfaces.Cache;

/**
 * Created by alexandermiheev on 06.06.16.
 */
public class WrongConsumer {
    @InjectCache(injectCacheName = "rando")
    private Cache wrongCache;

    public void wrongCacheManipulation() {
        System.out.print(wrongCache.get(1));
    }

}
