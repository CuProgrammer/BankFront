package sample.asteralbank;

import com.blackbank.bank.UserManager;

public record Units() {
    public static UserManager manager = new UserManager("admin.txt", "personnel.txt", "account.text");
}
