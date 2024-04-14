package sample.asteralbank;

public class Admin extends User {
    public Admin()
    {
        
    }

    public Admin(String username, String password, Person person, UserStatus status)
    {
        super(username, password, person, status);
    }

    public Admin(User src)
    {
        super(src);
    }
}
