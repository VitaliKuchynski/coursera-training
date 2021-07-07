package coursera.thread;

public class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Running");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }
}
