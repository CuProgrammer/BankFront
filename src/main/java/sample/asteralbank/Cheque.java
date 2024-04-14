package sample.asteralbank;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cheque {
    @JsonProperty
    double amount;
    @JsonProperty
    private User drawer;
    @JsonProperty
    private User payee;
    @JsonProperty
    private LocalDate payDate;
    
    public Cheque() {

    }

    public Cheque(double amount, User drawer, User payee, LocalDate payDate) {
        this.amount = amount;
        this.drawer = drawer;
        this.payee = payee;
        this.payDate = payDate;
    }
    
    public double getAmount() {
        return amount;
    }

    public User getDrawer() {
        return drawer;
    }

    public User getPayee() {
        return payee;
    }

    public LocalDate getPayDate() {
        return payDate;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDrawer(User drawer) {
        this.drawer = drawer;
    }

    public void setPayDate(LocalDate payDate) {
        this.payDate = payDate;
    }

    public void setPayee(User payee) {
        this.payee = payee;
    }
}
