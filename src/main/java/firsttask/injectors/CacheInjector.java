package firsttask.injectors;

import firsttask.annotations.InjectCache;
import firsttask.interfaces.Cache;
import firsttask.providers.CacheClassesProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by alexandermiheev on 03.06.16.
 */
public class CacheInjector {

    private static Class findCacheProvider(String injectCacheName, List<Class> cacheClasses) throws RuntimeException {
        Class cacheProvider = null;
        for (Class currentClass: cacheClasses) {
            firsttask.annotations.Cache cache = (firsttask.annotations.Cache)
                    currentClass.getAnnotation(firsttask.annotations.Cache.class);
            if (injectCacheName.equals(cache.cacheName())) {
                cacheProvider = currentClass;
            }
        }
        if (cacheProvider == null) {
            throw new RuntimeException("No caches to inject!");
        }
        return cacheProvider;
    }

    private static List<Class> getSuperClassesList(Class currentClass) {
        List<Class> superClasses = new ArrayList<>();
        while (!currentClass.equals(Object.class)) {
            superClasses.add(currentClass);
            currentClass = currentClass.getSuperclass();
        }
        return superClasses;
    }

    private static boolean isFieldAnnotatedWithInjectCache(Field field) {
        boolean result = false;

        for (Annotation annotation: field.getAnnotations()) {
            if (annotation.annotationType().equals(InjectCache.class)) {
                result = true;
            }
        }

        return result;
    }

    private static List<Field> getInjectCacheFields(Class currentClass) {
        List<Field> injectCacheFields = new ArrayList<>();

        for (Field field: currentClass.getDeclaredFields()) {
            field.setAccessible(true);
            if (isFieldAnnotatedWithInjectCache(field)) {
                injectCacheFields.add(field);
            }
        }

        return injectCacheFields;
    }

    private static void injectCacheIntoField(Object instance, Field field) {
        Annotation injectCacheAnnotation = field.getAnnotation(InjectCache.class);
        InjectCache injectCache = (InjectCache) injectCacheAnnotation;

        Class cacheProvider = findCacheProvider(injectCache.injectCacheName(), CacheClassesProvider.getCacheClasses());
        try {
            Cache temp = (Cache) cacheProvider.newInstance();
            field.set(instance, temp);
        } catch (InstantiationException e) {
            System.out.print(e.getMessage());
        } catch (IllegalAccessException e) {
            System.out.print(e.getMessage());
        }

    }

    private static void injectCacheIntoFields(Object instance, List<Field> injectCacheFields) {
        for (Field field: injectCacheFields) {
            injectCacheIntoField(instance, field);
        }
    }


    public static void inject(Object instance) throws RuntimeException {
        List<Class> superClasses = getSuperClassesList(instance.getClass());

        for (Class currentClass: superClasses) {
            List<Field> injectCacheFields = getInjectCacheFields(currentClass);
            injectCacheIntoFields(instance, injectCacheFields);
        }

    }

}
