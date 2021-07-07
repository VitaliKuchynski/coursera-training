package annotationReflection;

import annotationReflection.annotation.Init;
import annotationReflection.annotation.Service;

@Service(name = "VerySimple")
public class SimpleService {

    @Init
    public void initService(){
        System.out.println("TestSimple");

    }

}
