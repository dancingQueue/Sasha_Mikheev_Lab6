package firsttask;

import firsttask.annotations.Cache;
import firsttask.annotations.InjectCache;
import firsttask.interfaces.CacheInterface;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Created by alexandermiheev on 03.06.16.
 */
public class CacheInjector {

    private static Class findCacheProvider(String injectCacheName, ArrayList<Class> cacheClasses) {

        Class cacheProvider = null;
        for (Class currentClass: cacheClasses) {
            Cache cache = (Cache) currentClass.getAnnotation(Cache.class);
            if (injectCacheName.equals(cache.cacheName())) {
                cacheProvider = currentClass;
            }
        }
        return cacheProvider;

    }

    public static void inject(Object instance) {
        Class currentInstanceClass = instance.getClass();
        ArrayList<Class> cacheClasses = CacheClassesProvider.getCacheClasses();

        Field[] classFields = currentInstanceClass.getDeclaredFields();

        for (Field field: classFields) {
            field.setAccessible(true);
            for (Annotation annotation: field.getAnnotations()) {
                if (annotation.annotationType().equals(InjectCache.class)) {
                    InjectCache injectCache = (InjectCache) annotation;

                    Class cacheProvider = findCacheProvider(injectCache.injectCacheName(), cacheClasses);

                    try {
                        CacheInterface temp = (CacheInterface) cacheProvider.newInstance();

                        field.set(instance, temp);


                    } catch (InstantiationException e) {
                        System.out.print(e.getMessage() + "InstantiationException");
                    } catch (IllegalAccessException e) {
                        System.out.print(e.getMessage() + "IllegalAccessException 1");
                    }


                }
            }
        }



    }

}
