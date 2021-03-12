import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertUser {

    public static void main (String [] args)
    {
        Scanner keyboard = new Scanner(System.in);

        Connection conn = connect();

        try {


            String sql = "INSERT INTO Users  (User_Fname,User_LName,User_Email,User_Password,User_DOB,User_PhoneNumber,User_Role) VALUES(?,?,?,?,?,?,?)";

            System.out.println("First Name: ");
            String uFName = keyboard.nextLine();
            System.out.println("Last Name: ");
            String uLName = keyboard.nextLine();
            System.out.println("Email: ");
            String uEmail = keyboard.nextLine();
            System.out.println("Password: ");
            String uPassword = keyboard.nextLine();
            System.out.println("DOB: ");
            String uDOB = keyboard.nextLine();
            System.out.println("Phone Number: ");
            String uPhoneNumber = keyboard.nextLine();
            System.out.println("User Role: ");
            String uRole = keyboard.nextLine();



            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, uFName);
            pstmt.setString(2,uLName);
            pstmt.setString(3,uEmail);
            pstmt.setString(4,uPassword);
            pstmt.setString(5,uDOB);
            pstmt.setString(6,uPhoneNumber);
            pstmt.setString(7,uRole);




            pstmt.executeUpdate();


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






    private static Connection connect(){

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

