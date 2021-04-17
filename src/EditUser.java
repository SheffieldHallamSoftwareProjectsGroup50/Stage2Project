import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EditUser {

    public static String Email;
    static public Scanner Input = new Scanner(System.in);

    public static Connection connect(){

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

    public static String email() {
        System.out.println("\nPlease enter the email of the user you would like to edit: \n");
        Email = Input.nextLine();
        return Email;
    }

    public static void main (String [] args) {
        email();
        editUser();
    }

    public static void editUser() {

        System.out.println("\nYou are currently editing " + Email + ".\n");
        System.out.println("Edit User:\n" +
                "Please select a function:\n" +
                "\n" +
                "Press 1: Edit user's first name\n" +
                "\n" +
                "Press 2: Edit user's last name\n" +
                "\n" +
                "Press 3: Edit user email\n" +
                "\n" +
                "Press 4: Edit user password\n" +
                "\n" +
                "Press 5: Edit user's date of birth\n" +
                "\n" +
                "Press 6: Edit user's phone number\n" +
                "\n" +
                "Press 7: Edit user role\n" +
                "\n" +
                "Press 8: Return to user information\n");

        int choice;
        do {
            choice = Input.nextInt();
            Input.nextLine();
            switch (choice) {
                case 1:
                    userFName();
                    break;
                case 2:
                    userLName();
                    break;
                case 3:
                    userEmail();
                    break;
                case 4:
                    userPassword();
                    break;
                case 5:
                    userDOB();
                    break;
                case 6:
                    userPhoneNumber();
                    break;
                case 7:
                    userRole();
                    break;
                case 8:
                    break;
                default:
                    System.out.println("That was not a valid input please try again\n");
                    editUser();
            }
        } while(choice < 9);
    }

    public static void userFName() {
        Connection conn = connect();

        System.out.println("Please enter a new first name: ");
        String uFName = Input.nextLine();
        String sql = "UPDATE Users SET User_FName = ? WHERE User_Email = ?";
        try
        {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, uFName);
            pstmt.setString(2, Email);
            pstmt.executeUpdate();
            System.out.println("Update successful!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        editUser();
    }

    public static void userLName() {
        Connection conn = connect();

        System.out.println("Please enter a new last name: ");
        String uLName = Input.nextLine();
        String sql = "UPDATE Users SET User_LName = ? WHERE User_Email = ?";
        try
        {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, uLName);
            pstmt.setString(2, Email);
            pstmt.executeUpdate();
            System.out.println("Update successful!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        editUser();
    }

    public static void userEmail() {
        Connection conn = connect();

        System.out.println("Please enter a new email: ");
        String uEmail = Input.nextLine();
        String sql = "UPDATE Users SET User_Email = ? WHERE User_Email = ?";
        try
        {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, uEmail);
            pstmt.setString(2, Email);
            pstmt.executeUpdate();
            System.out.println("Update successful!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        Email = uEmail;
        editUser();
    }

    public static void userPassword() {
        Connection conn = connect();

        System.out.println("Please enter a new password: ");
        String uPassword = Input.nextLine();
        String sql = "UPDATE Users SET User_Password = ? WHERE User_Email = ?";
        try
        {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, uPassword);
            pstmt.setString(2, Email);
            pstmt.executeUpdate();
            System.out.println("Update successful!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        editUser();
    }

    public static void userDOB() {
        Connection conn = connect();

        System.out.println("Please enter a new date of birth (DD/MM/YYYY): ");
        String uDOB = Input.nextLine();
        String sql = "UPDATE Users SET User_DOB = ? WHERE User_Email = ?";
        try
        {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, uDOB);
            pstmt.setString(2, Email);
            pstmt.executeUpdate();
            System.out.println("Update successful!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        editUser();
    }

    public static void userPhoneNumber() {
        Connection conn = connect();

        System.out.println("Please enter a new phone number: ");
        int uPhoneNumber = Input.nextInt();
        String sql = "UPDATE Users SET User_PhoneNumber = ? WHERE User_Email = ?";
        try
        {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, uPhoneNumber);
            pstmt.setString(2, Email);
            pstmt.executeUpdate();
            System.out.println("Update successful!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        editUser();
    }

    public static void userRole() {
        Connection conn = connect();

        System.out.println("Please enter a new role: ");
        String uRole = Input.nextLine();
        String sql = "UPDATE Users SET User_Role = ? WHERE User_Email = ?";
        try
        {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, uRole);
            pstmt.setString(2, Email);
            pstmt.executeUpdate();
            System.out.println("Update successful!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        editUser();
    }
}
