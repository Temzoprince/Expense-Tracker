import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnect {

    private String url = "jdbc:mysql://localhost:3306/jdbc-example";
    private String username = "root";
    private String password = "Qassword!23";

    Connection connection;

    public DatabaseConnect() {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    //setters to login to the database#
    //these setters will allow you to change the url, username and login -- they will be put as part of a login form on the GUI for the expense data tracker

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
