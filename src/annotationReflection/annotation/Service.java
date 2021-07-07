package annotationReflection.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Inherited
@Documented
public @interface Service {
    String name();
    boolean lazyLoad() default false;
}
