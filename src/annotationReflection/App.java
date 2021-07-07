package annotationReflection;

public class App {

    public static void main(String[] args) {
        inspectServ(SimpleService.class);
        inspectServ(LazyService.class);
        inspectServ(String.class);
    }


    static void inspectServ(Class<?> service){


    }

}
