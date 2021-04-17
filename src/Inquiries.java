import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Inquiries {

    public static void main(String[] args) {//throws SQLException {
        Scanner userChoice = new Scanner(System.in);
        String category = "Empty";
        String inq;
        System.out.println("Please Enter What This Inquiry Is About\nPress 1: For Logging In\nPress 2: For Searching Store\nPress 3: For Other\nPress 4: To Exit");
        switch (userChoice.nextInt()) {
            case 1:
                category = "Log In Error";
                break;
            case 2:
                category = "Store Search Error";
                break;
            case 3:
                category = "Other";
                break;
            case 4:
                Main.CustomerMenu();
                break;
            default:
                System.out.println("That was not a valid input please try again");
                Inquiries.main(null);
        }
        System.out.println(category);
        System.out.println("Please Enter Your Inquiry");
        inq = userChoice.nextLine();

        Connection conn = connect();


        try {
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


