package udacity;

public class User {

    private String userName;

    private int userID;

    private int balance;

    public User(String userName, int userID, int balance) {
        this.userName = userName;
        this.userID = userID;
        this.balance = balance;
    }

    public User() {
    }

    public void withdraw(int amount){
        System.out.println("Please log in");

        if(balance < amount){
            System.out.println("Please check you balance");
        }

        balance = balance - amount;
        System.out.println("You balance: " + balance);
    }

    public void deposit(int depositAmount){

        balance = balance + depositAmount;
        System.out.println("You balance: " + balance) ;

    }

    public void loginUser(String name, int id){

    }

}
