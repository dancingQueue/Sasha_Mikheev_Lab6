package firsttask.consumers;

import firsttask.annotations.InjectCache;
import firsttask.interfaces.Cache;

/**
 * Created by alexandermiheev on 05.06.16.
 */
public class BackwardConsumer {
    @InjectCache(injectCacheName = "alphabet")
    private Cache cache;

    public void cacheManipulation() {
        String currentString = cache.get(1);
        int length = currentString.length();

        char[] resultStringCharArray = new char[length];

        for (int i = 0; i < length; i++) {
            resultStringCharArray[i] = currentString.charAt(length - 1 - i);
        }
        String resultString = new String(resultStringCharArray);
        System.out.println(resultString);

    }

}
