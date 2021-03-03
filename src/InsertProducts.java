import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertProducts {

    public static void main (String [] args)
    {
        Scanner keyboard = new Scanner(System.in);
        //we need to write dbconnection code here!

        Connection conn = connect();

        try {
            System.out.println("Enter Name: ");
            String pName = keyboard.nextLine();
            System.out.println("Category: ");
            String pCategory = keyboard.nextLine();
            System.out.println("Description: ");
            String pDescription = keyboard.nextLine();
            System.out.println("Supplier: ");
            String pSupplier = keyboard.nextLine();
            System.out.println("Price: ");
            double pPrice = keyboard.nextDouble();
            System.out.println("Quantity: ");
            int pQuantity = keyboard.nextInt();
            System.out.println("Status: ");
            String pStatus = keyboard.nextLine();
            System.out.println("Location: ");
            String pLocation = keyboard.nextLine();

            String sql = "INSERT INTO Products (Product_Name,Product_Category, Product_Description,Product_Supplier,Product_Price,Product_Quantity,Product_Status,Product_location) VALUES(?,?,?,?,?,?,?,?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
//pstmt.setInt(1,Id); we dont need this as we have defined this field as auto-increment and not null
            pstmt.setString(1, pName);
            pstmt.setString(2, pCategory);
            pstmt.setString(3, pDescription);
            pstmt.setString(4, pSupplier);
            pstmt.setDouble(5, pPrice);
            pstmt.setInt(6, pQuantity);
            pstmt.setString(7, pStatus );
            pstmt.setString(8, pLocation );



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
