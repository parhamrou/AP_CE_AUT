/**
 * This class represents a person. 
 * It has different fields to have information
 * of a store's client.
 */

public class Person {

    private String name;
    private String userName;
    private double balance;
    private Basket basket;

    // constructor
    public Person(String name, String userName, double balance) {
        this.name = name;
        this.userName = userName;
        this.balance = balance;
        this.basket = new Basket();
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    
    public String getUserName() {
        return userName;
    }

    public Basket getBasket() {
        return basket;
    }

    public double getBalance() {
        return balance;
    }
    

    @Override
    public String toString() {
        String string = String.format("%s = '%s'   %s = '%s'   %s = %.2f", "name", name, "username", userName, "balance", balance);
        return string;
    }
}
