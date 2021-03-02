import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnection {


    public static void main (String [] args)
    {
        //we need to write dbconnection code here!

        Connection conn = connect();


    }


    private static Connection connect(){

        String fileName = "Stage2Database.db";
        String url = "jdbc:sqlite:" + fileName;
        // SQLite connection string
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Db connection successful!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }




}




