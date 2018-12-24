package udacity;



public class Main {


    public static void main(String[] args){

        User user = new User("Vitali", 1, 1000);

        user.deposit(1000);
        user.withdraw(500);

    }
}
