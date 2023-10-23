import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;

public class DataHandle extends DatabaseConnect {

    private PreparedStatement preparedStatement;
    //private int id;

    private String url = "jdbc:mysql://localhost:3306/jdbc-example";
    private String username = "root";
    private String password = "Qassword!23";

    Connection connection;

    public DataHandle() {

        //Initially created a connection with the database here
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        }catch (Exception e) {
            e.printStackTrace();
        }

        //Created a new class to handle connecting to the database
//        DatabaseConnect connect = new DatabaseConnect();
    }
    public void addData(String date, String desc, String category, Double amount) {
        try {

            String sql = "INSERT INTO expense (date, description, category, amount) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, date);
            preparedStatement.setString(2, desc);
            preparedStatement.setString(3, category);
            preparedStatement.setDouble(4, amount);


            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data added successfully.");
            } else {
                System.out.println("Data not added.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAllData() {

        try {
            String sql = "DELETE FROM expense";
            preparedStatement = connection.prepareStatement(sql);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data cleared successfully.");
            } else {
                System.out.println("Data not cleared.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteData(String id) {

        try {
            String sql = "DELETE FROM expense where id = " + id + ";";
            preparedStatement = connection.prepareStatement(sql);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data id: " + id + " cleared successfully.");
            } else {
                System.out.println("Data not cleared.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
