package sample.asteralbank;

public class Personnel extends User {
    public Personnel()
    {

    }

    public Personnel(String username, String password, Person person, UserStatus status)
    {
        super(username, password, person, status);
    }
}
