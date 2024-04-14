package sample.asteralbank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Account.class, name = "account"),
    @JsonSubTypes.Type(value = Personnel.class, name = "personnel"),
    @JsonSubTypes.Type(value = Admin.class, name="admin")
})

public abstract class User {
    @JsonProperty
    private String username;
    @JsonProperty
    private String password;
    @JsonProperty
    private Person person;
    @JsonProperty
    private UserStatus status;

    public User(String username, String password, Person person, UserStatus status)
    {
        this.username = username;
        this.password = password;
        this.person = person;
        this.status = status;
    }

    public User()
    {
        
    }

    public User(User src)
    {
        this(src.username, src.password, src.person, src.status);
    }

    public boolean confirmPassword(String password)
    {
        return password.equals(this.password);
    }

    public String getUsername()
    {
        return this.username;
    }

    public String getPassword() {
        return password;
    }

    public Person getPerson() {
        return person;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
