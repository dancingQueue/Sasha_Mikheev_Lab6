package firsttask.injectors;

import firsttask.annotations.InjectCache;
import firsttask.interfaces.Cache;
import firsttask.providers.CacheClassesProvider;

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
            firsttask.annotations.Cache cache = (firsttask.annotations.Cache) currentClass.getAnnotation(firsttask.annotations.Cache.class);
            if (injectCacheName.equals(cache.cacheName())) {
                cacheProvider = currentClass;
            }
        }
        return cacheProvider;
    }



    public static void inject(Object instance) {
        Class currentClass = instance.getClass();
        ArrayList<Class> cacheClasses = CacheClassesProvider.getCacheClasses();
        ArrayList<Class> superClasses = new ArrayList<>();

        while (!currentClass.equals(Object.class)) {
            superClasses.add(currentClass);
            currentClass = currentClass.getSuperclass();
        }

        for (Class currentInstanceClass: superClasses) {
            Field[] classFields = currentInstanceClass.getDeclaredFields();

            for (Field field : classFields) {
                field.setAccessible(true);
                for (Annotation annotation : field.getAnnotations()) {
                    if (annotation.annotationType().equals(InjectCache.class)) {
                        InjectCache injectCache = (InjectCache) annotation;
                        Class cacheProvider = findCacheProvider(injectCache.injectCacheName(), cacheClasses);

                        try {
                            Cache temp = (Cache) cacheProvider.newInstance();
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

}
