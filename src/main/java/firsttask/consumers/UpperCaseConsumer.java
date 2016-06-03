package firsttask.consumers;

import firsttask.annotations.Cache;
import firsttask.annotations.InjectCache;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by alexandermiheev on 03.06.16.
 */

public class UpperCaseConsumer {

    @InjectCache(injectCacheName = "dictionary")
    public Set<Integer> test;

    public UpperCaseConsumer() {
        test = new HashSet<Integer>();
    }

    public int getSize() {
        return test.size();
    }
    public void printTest() {
        System.out.println(getSize());
    }
    private HashMap<Integer, String> data;

    public void dataManipulation() {
        // Some stuff to do with cache
        HashMap<Integer, String> newData = new HashMap<Integer, String>();

        for (Integer key: data.keySet()) {
            newData.put(key, data.get(key).toUpperCase());
        }

        data = newData;
    }
}
