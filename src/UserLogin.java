import java.sql.*;
import java.util.Scanner;

public class UserLogin {


    private static Connection connect(){

        String fileName = "Stage2Database.db";
        String url = "jdbc:sqlite:" + fileName;
        // SQLite connection string
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void Login() {

        Scanner Input = new Scanner(System.in);
        Connection conn = connect();

        String databaseEmail = "";
        String databasePassword = "";
        String databaseRole = "";

        System.out.println("------------------");
        System.out.println("    User Login    ");
        System.out.println("------------------");


        System.out.println("Email: ");
        String email = Input.nextLine();
        System.out.println("Password: ");
        String password = Input.nextLine();

        try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Users WHERE User_Email=(?) AND User_Password=(?)")) {

            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                databaseEmail = rs.getString("User_Email");
                databasePassword = rs.getString("User_Password");
                databaseRole = rs.getString("User_Role");
            }

            if (email.equals(databaseEmail) && password.equals(databasePassword)) {

                  if (databaseRole.equals("Manager")) {
                    conn.close();
                    Main.ManagerMenu();
                } else if (databaseRole.equals("Customer")) {
                    conn.close();
                      Main.CustomerMenu();
                }
                  else if (databaseRole.equals("Sales")) {
                      conn.close();
                      Main.SalesMenu();
                  }
                  else if (databaseRole.equals("Production")) {
                      conn.close();
                      Main.ProductionMenu();
                  }
                  else if (databaseRole.equals("Purchasing")) {
                      conn.close();
                      Main.PurchasingMenu();
                  }
            } else {
                System.out.println("Incorrect Login!");
                Login();
            }
        } catch (SQLException e) {
            System.out.println("Fail!");

        }

    }

        public static void Register() {

        Scanner Input = new Scanner(System.in);
        Connection conn = connect();

        System.out.println("---------------------------");
        System.out.println("    Register an Account    ");
        System.out.println("---------------------------");

        System.out.println("First Name: ");
        String uFName = Input.nextLine();
        System.out.println("Last Name: ");
        String uLName = Input.nextLine();
        System.out.println("Email: ");
        String uEmail = Input.nextLine();
        System.out.println("Password: ");
        String uPassword = Input.nextLine();
        System.out.println("DOB: ");
        String uDOB = Input.nextLine();
        System.out.println("Phone Number: ");
        String uPhoneNumber = Input.nextLine();

        String uRole = "Customer";

        try {
            String sql = "INSERT INTO Users  (User_Fname,User_LName,User_Email,User_Password,User_DOB,User_PhoneNumber,User_Role) VALUES(?,?,?,?,?,?,?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, uFName);
            pstmt.setString(2,uLName);
            pstmt.setString(3,uEmail);
            pstmt.setString(4,uPassword);
            pstmt.setString(5,uDOB);
            pstmt.setString(6,uPhoneNumber);
            pstmt.setString(7,uRole);

            pstmt.executeUpdate();
            Main.CustomerMenu();

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
}





