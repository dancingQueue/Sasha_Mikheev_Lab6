package firsttask.consumers;

import firsttask.interfaces.CacheInterface;

/**
 * Created by alexandermiheev on 05.06.16.
 */
public class Consumer {
    public CacheInterface cache;

    public Consumer() {
        cache = null;
    }

    public void cacheManipulation() {
        System.out.print(cache.get(1));
    }

}
