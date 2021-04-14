import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EditProducts {

    public static String Name;
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

    public static String userName() {
        System.out.println("\nPlease enter the name of the product you would like to edit: \n");
        Name = Input.nextLine();
        return Name;
    }

    public static void main (String [] args) {
        userName();
        editProduct();
    }

    public static void editProduct() {

        System.out.println("\nYou are currently editing " + Name + ".\n");
        System.out.println("Edit Products:\n" +
                "Please select a function:\n" +
                "\n" +
                "Press 1: Edit product name\n" +
                "\n" +
                "Press 2: Edit product category\n" +
                "\n" +
                "Press 3: Edit product description\n" +
                "\n" +
                "Press 4: Edit product supplier\n" +
                "\n" +
                "Press 5: Edit product price\n" +
                "\n" +
                "Press 6: Edit product quantity\n" +
                "\n" +
                "Press 7: Edit product status\n" +
                "\n" +
                "Press 8: Edit product location\n" +
                "\n" +
                "Press 9: Return to manage product information\n");

        int choice;
        do {
            choice = Input.nextInt();
            Input.nextLine();
            switch (choice) {
                case 1:
                    productName();
                    break;
                case 2:
                    productCategory();
                    break;
                case 3:
                    productDescription();
                    break;
                case 4:
                    productSupplier();
                    break;
                case 5:
                    productPrice();
                    break;
                case 6:
                    productQuantity();
                    break;
                case 7:
                    productStatus();
                    break;
                case 8:
                    productLocation();
                    break;
                case 9:
                    break;
                default:
                    System.out.println("That was not a valid input please try again\n");
                    editProduct();
            }
        } while(choice < 10);
    }

    public static void productName() {
        Connection conn = connect();

        System.out.println("Please enter a new name: ");
        String pName = Input.nextLine();
        String sql = "UPDATE Products SET Product_Name = ? WHERE Product_Name = ?";
        try
        {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pName);
            pstmt.setString(2, Name);
            pstmt.executeUpdate();
            System.out.println("Update successful!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        Name = pName;
        editProduct();
    }

    public static void productCategory() {
        Connection conn = connect();

        System.out.println("Please enter a new category: ");
        String pCategory = Input.nextLine();
        String sql = "UPDATE Products SET Product_Category = ? WHERE Product_Name = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pCategory);
            pstmt.setString(2, Name);
            pstmt.executeUpdate();
            System.out.println("Update successful!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        editProduct();

    }

    public static void productDescription() {
        Connection conn = connect();

        System.out.println("Please enter a new description: ");
        String pDescription = Input.nextLine();
        String sql = "UPDATE Products SET Product_Description = ? WHERE Product_Name = ?";
        try
        {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pDescription);
            pstmt.setString(2, Name);
            pstmt.executeUpdate();
            System.out.println("Update successful!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        editProduct();

    }

    public static void productSupplier() {
        Connection conn = connect();

        System.out.println("Please enter a new supplier: ");
        String pSupplier = Input.nextLine();
        String sql = "UPDATE Products SET Product_Supplier = ? WHERE Product_Name = ?";
        try
        {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pSupplier);
            pstmt.setString(2, Name);
            pstmt.executeUpdate();
            System.out.println("Update successful!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        editProduct();

    }

    public static void productPrice() {
        Connection conn = connect();

        System.out.println("Please enter a new price: ");
        double pPrice = Input.nextDouble();
        String sql = "UPDATE Products SET Product_Price = ? WHERE Product_Name = ?";
        try
        {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, pPrice);
            pstmt.setString(2, Name);
            pstmt.executeUpdate();
            System.out.println("Update successful!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        editProduct();

    }

    public static void productQuantity() {
        Connection conn = connect();

        System.out.println("Please enter a new quantity: ");
        int pQuantity = Input.nextInt();
        String sql = "UPDATE Products SET Product_Quantity = ? WHERE Product_Name = ?";
        try
        {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, pQuantity);
            pstmt.setString(2, Name);
            pstmt.executeUpdate();
            System.out.println("Update successful!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        editProduct();

    }

    public static void productStatus() {
        Connection conn = connect();

        System.out.println("Please enter a new status: ");
        String pStatus = Input.nextLine();
        String sql = "UPDATE Products SET Product_Status = ? WHERE Product_Name = ?";
        try
        {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pStatus);
            pstmt.setString(2, Name);
            pstmt.executeUpdate();
            System.out.println("Update successful!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        editProduct();

    }

    public static void productLocation() {
        Connection conn = connect();

        System.out.println("Please enter a new location: ");
        String pLocation = Input.nextLine();
        String sql = "UPDATE Products SET Product_Location = ? WHERE Product_Name = ?";
        try
        {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pLocation);
            pstmt.setString(2, Name);
            pstmt.executeUpdate();
            System.out.println("Update successful!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        editProduct();

    }
}