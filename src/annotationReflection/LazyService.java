package annotationReflection;

import annotationReflection.annotation.Init;
import annotationReflection.annotation.Service;

@Service(name = "veryLazy")
public class LazyService {

    @Init
    public void lazyService(){
        System.out.println("Lazy");
       throw  new RuntimeException("Exception !!!!!!!!!!!!!!");
    }
}
