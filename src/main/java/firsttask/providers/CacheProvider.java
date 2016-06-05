package firsttask.providers;

import firsttask.interfaces.CacheInterface;

import java.util.Random;

/**
 * Created by alexandermiheev on 04.06.16.
 */
public class CacheProvider {
    private static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static void provideRandomCache(CacheInterface cache) {
        int sizeOfMap = 10;
        int sizeOfWord = 10;
        Random random = new Random();
        for (int key = 0; key < sizeOfMap; key++) {
            String tempData = "";
            for (int i = 0; i < sizeOfWord; i++) {
                tempData += alphabet.charAt(random.nextInt(25));
            }
            cache.put(key, tempData);
        }


    }
    public static void provideAlphabetCache(CacheInterface cache) {
        cache.put(1, alphabet);
    }
}
