package sample.asteralbank;

import com.blackbank.bank.*;
public class INFO {
    public static UserManager userManager = new UserManager("admins.txt", "personnel.txt", "accounts.txt");
    public static User user;
    public static ChequeManager chequeManager = new ChequeManager("cheques.txt");
    public static LoanManager loanManager = new LoanManager("loans.txt");
}
