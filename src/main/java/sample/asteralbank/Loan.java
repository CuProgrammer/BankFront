package sample.asteralbank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Loan {
    @JsonProperty
    private User recipient;
    @JsonProperty
    private double amount;
    @JsonProperty
    boolean active;

    public Loan() {

    }

    public Loan(User recipient, double amount, boolean active) {
        this.recipient = recipient;
        this.amount = amount;
        this.active = active;
    }

    public double getAmount() {
        return amount;
    }

    public User getRecipient() {
        return recipient;
    }
    
    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }
}
