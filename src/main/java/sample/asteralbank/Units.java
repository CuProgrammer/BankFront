package sample.asteralbank;

public record Units() {
    public static UserManager manager = new UserManager("admin.txt", "personnel.txt", "account.text");
}
