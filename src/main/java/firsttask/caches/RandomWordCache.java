package firsttask.caches;

import firsttask.annotations.Cache;
import firsttask.interfaces.CacheInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by alexandermiheev on 03.06.16.
 */
@Cache(cacheName = "random")
public class RandomWordCache implements CacheInterface {

    private static Map<Integer, String> hashMap = new HashMap<Integer, String>();

    public String get(int key) {
        return hashMap.get(key);
    }

    public void put(int key, String value) {
        hashMap.put(key, value);
    }

    public Set<Integer> getKeySet() {
        return hashMap.keySet();
    }
}
