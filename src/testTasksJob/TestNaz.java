package testTasksJob;


public class TestNaz {

    public TestNaz(){
        this(10);
    }

    public TestNaz(int data){
        this.data = data;
    }

    public void  display(){

        class Decrementer{
            public void decrement(){
                data--;
            }
        }
        Decrementer d = new Decrementer();
        d.decrement();
        System.out.println("data = " +  data);
    }
    private int data;

    public static void main (String [] arg ){
        int data =0;
        TestNaz t = new TestNaz();
        t.display();
        System.out.println("data = " + data);

    }

}
