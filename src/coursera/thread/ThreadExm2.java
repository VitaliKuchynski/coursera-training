package coursera.thread;

import java.util.Comparator;

public class ThreadExm2 {
    public static void main(String[] args) {
        // anonymous class
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Running");
            }
        };
        // Lambda
        Runnable runnableLambda = () -> {
            System.out.println("Running Lambda");
        };

        Comparator<String> comparator = (o1, o2)  -> o1.compareTo(o2);


        System.out.println(comparator.compare("test","D"));

        Thread thread = new Thread(runnableLambda);
        thread.start();

    }
}
