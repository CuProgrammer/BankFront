package sample.asteralbank;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

class Users <T extends User> {
    @JsonProperty
    private HashMap<String, T> users;
    private File data;
    private ObjectMapper mapper;

    public Users(File data)
    {
        users = new HashMap<>();
        this.data = data;
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

        if (!data.isFile()) {
            try {
                data.createNewFile();
                deload();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            load();
        }
    }

    public Users(String dataPath)
    {
        this(new File(dataPath));
    }

    public void load()
    {
        try {
            mapper.readerForUpdating(this).readValue(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deload()
    {
        try {
            mapper.writeValue(data, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean add(T user)
    {
        if (users.get(user.getUsername()) != null)
            return false;
        users.put(user.getUsername(), user);
        deload();
        return true;
    }

    public void delete(String username)
    {
        if (users.get(username) == null)
            return;
        users.remove(username);
        deload();
    }

    public void activate(String username)
    {
        users.get(username).setStatus(UserStatus.NORMAL);
        deload();
    }

    public void deactivate(String username)
    {
        users.get(username).setStatus(UserStatus.DEACTIVE);
        deload();
    }

    public User getUser(String username)
    {
        return users.get(username);
    }

    public boolean exists(String username)
    {
        return getUser(username) != null;
    }
}

public class UserManager {
    private Users<Admin> admins;
    private Users<Personnel> personnel;
    private Users<Account> accounts;

    public UserManager(String adminsPath, String personnelPath, String accountsPath)
    {
        admins = new Users<>(adminsPath);
        personnel = new Users<>(personnelPath);
        accounts = new Users<>(accountsPath);
    }

    public boolean exists(String username)
    {
        return admins.exists(username) || personnel.exists(username) || accounts.exists(username);
    }

    private char randomDigit()
    {
        Random random = new Random();
        return (char) random.nextInt('0', '9' + 1);
    }

    private String randomDigits(int n)
    {
        String digits = "";
        for (int i = 0; i < n; i++)
            digits += randomDigit();
        return digits;
    }

    public String addAccount(String password, Person person, double balance)
    {
        String n1, n2, n3, n4;
        do {
            n1 = randomDigits(4);
            n2 = randomDigits(4);
            n3 = randomDigits(4);
            n4 = randomDigits(4);
        } while (exists(n1+n2+n3+n4));
        Account account = new Account(n1+n2+n3+n4, password, person, UserStatus.DEACTIVE, balance);
        accounts.add(account);
        return account.getUsername(); 
    }

    public boolean addPersonnel(String username, String password, Person person)
    {
        return personnel.add(new Personnel(username, password, person, UserStatus.DEACTIVE));
    }

    public boolean makePersonnelAdmin(String username)
    {
        if (!personnel.exists(username))
            return false;
        Admin admin = new Admin(personnel.getUser(username));
        personnel.delete(username);
        admins.add(admin);
        return true;
    }

    public void activateUser(String username)
    {
        switch (getUserType(username)) {
            case "admin" -> {
                admins.activate(username);
            }
            case "personnel" -> {
                personnel.activate(username);
            }
            case "account" -> {
                accounts.activate(username);
            }
        }
    }

    public String getUserType(String username)
    {
        if (admins.exists(username))
            return "admin";
        else if (personnel.exists(username))
            return "personnel";
        else if (accounts.exists(username))
            return "account";
        else
            return "unknown";
    }

    public User login(String username, String password)
    {
        User user = getUser(username);
        if (user == null || !user.confirmPassword(password))
            return null;
        else
            return user;
    }

    private User getUser(String username)
    {
        return switch (getUserType(username)) {
            case "admin" -> admins.getUser(username);
            case "personnel" -> personnel.getUser(username);
            case "account" -> accounts.getUser(username);
            default -> null;
        };
    }
}