package sample.asteralbank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Account extends User {
    @JsonProperty
    private double balance;

    public Account(String username, String password, Person person, UserStatus status, double balance)
    {
        super(username, password, person, status);
        this.balance = balance;
    }

    public Account()
    {
        
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
