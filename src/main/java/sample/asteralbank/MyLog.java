package sample.asteralbank;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

import com.blackbank.bank.User;

public class MyLog {
    private static String path;
    private static User user;

    public static void setUser(User user) {
        MyLog.user = user;
    }

    public static void setPath(String path) {
        MyLog.path = path;
        if (!(new File(path)).isFile()) {
            try {
                (new File(path)).createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void log(String msg) {
        try {
            PrintWriter out = new PrintWriter(new FileWriter(path, true));
            String date = LocalDate.now(ZoneId.of("Asia/Tehran")).toString();
            String hour = LocalTime.now(ZoneId.of("Asia/Tehran")).toString();
            out.println("[" + date + "]" + "{" + hour + "} " + user.getUsername() + "(" +
                            DataRepository.userManager.getUserType(user.getUsername()) + "): " +
                            user.getPerson().getName() + "\n\t" + msg);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
