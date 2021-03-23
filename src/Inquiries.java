import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Inquiries {

    public static void main(String[] args) throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the field of problem you are encountering e.g. searching products, logging in");
        String category = in.nextLine();
        System.out.println("Please enter the nature of your inquiry when prompted");
        String inq = in.nextLine();

        Connection conn = connect();

        try{
        String sqlinsert = "INSERT INTO Inquiries (category, inq) VALUES(?,?)";

        PreparedStatement prepst = conn.prepareStatement(sqlinsert);
        prepst.setString(1, category);
        prepst.setString(2, inq);

        prepst.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
        public static Connection connect () {

            String fileName = "Stage2Database.db";
            String url = "jdbc:sqlite:" + fileName;
            Connection conn = null;
            try {
                conn = DriverManager.getConnection(url);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return conn;

        }
    }


