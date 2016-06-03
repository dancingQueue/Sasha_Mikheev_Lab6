package firsttask.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by alexandermiheev on 03.06.16.
 */

@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Cache {
    String cacheName();
}
