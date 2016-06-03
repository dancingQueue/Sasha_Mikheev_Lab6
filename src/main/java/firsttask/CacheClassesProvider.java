package firsttask;

import firsttask.annotations.Cache;

import java.io.DataInputStream;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.instrument.Instrumentation;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexandermiheev on 03.06.16.
 */
public class CacheClassesProvider {
    public static ArrayList<Class> getCacheClasses() {
        ArrayList<Class> classes = new ArrayList<Class>();
        try {
            List<Class> currentLoadedClasses =  getClasses();

            for (Class tempClass: currentLoadedClasses) {
                for (Annotation annotation: tempClass.getAnnotations()) {
                    if (annotation.annotationType().equals(Cache.class)) {
                        classes.add(tempClass);
                    }
                }
            }
        } catch (Exception e) {
            System.out.print(e.getMessage() + "Exception");
        }

        return classes;
    }

    public static List<Class> getClasses() {
        List<Class> classes = new ArrayList<Class>();

        ClassLoader classLoader = CacheClassesProvider.class.getClassLoader();
        try {
            Field f = ClassLoader.class.getDeclaredField("classes");
            f.setAccessible(true);
            for (Class tempClass: (List<Class>) f.get(classLoader)) {
                classes.add(tempClass);
            }

        } catch (NoSuchFieldException e) {
            System.out.println(e.getMessage() + "NoSuchFieldException");
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage() + "IllegalAccessException");
        } finally {
            return classes;
        }

    }

}
