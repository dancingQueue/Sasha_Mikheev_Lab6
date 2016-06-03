package firsttask.caches;

import firsttask.annotations.Cache;
import firsttask.interfaces.CacheInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by alexandermiheev on 03.06.16.
 */
@Cache(cacheName = "dictionary")
public class DictionaryCache implements CacheInterface {

    private static Map<Integer, String> dictionary = new HashMap<Integer, String>();

    public DictionaryCache() {
        //dictionary = new HashMap<Integer, String>();
    }

    public String get(int key) {

        return dictionary.get(key);


    }

    public void put(int key, String value) {

        dictionary.put(key, value);

    }

    public Set<Integer> getKeySet() {
        return dictionary.keySet();
    }
}
