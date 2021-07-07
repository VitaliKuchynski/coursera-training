package annotationReflection.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Init {
    boolean suppressException() default false;
}
