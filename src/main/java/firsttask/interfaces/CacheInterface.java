package firsttask.interfaces;

import java.util.Set;

/**
 * Created by alexandermiheev on 03.06.16.
 */
public interface CacheInterface {
    String get(int key);
    void put(int key, String value);
    Set<Integer> getKeySet();
}
