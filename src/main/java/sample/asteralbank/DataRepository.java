package sample.asteralbank;

import com.blackbank.bank.ChequeManager;
import com.blackbank.bank.LoanManager;
import com.blackbank.bank.User;
import com.blackbank.bank.UserManager;

public class DataRepository {
    public static UserManager userManager = new UserManager("admins.txt", "personnel.txt", "accounts.txt");
    public static User user;
    public static ChequeManager chequeManager = new ChequeManager("cheques.txt");
    public static LoanManager loanManager = new LoanManager("loans.txt");
}
