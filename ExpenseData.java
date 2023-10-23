import com.mysql.cj.xdevapi.AddResult;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Arrays;

public class ExpenseData {


    public static void main(String[] args) {

        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-example", "root", "Qassword!23");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from expense");
            //resultSet

            while (resultSet.next()) {
                 LocalDate Date = resultSet.getDate("date").toLocalDate();
                 String Desc = (resultSet.getString("description"));
                 String Category = (resultSet.getString("category"));
                 Float Amount = resultSet.getFloat("amount");
                 String[] haha = {String.valueOf(Date), Desc, Category, String.valueOf(Amount)};
                System.out.println(Date + " " + Desc + " " + Category + " " + Amount);
                System.out.println(Arrays.toString(haha));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
