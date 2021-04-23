import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EditWarehouse {

    public static String WarehouseName;
    static public Scanner Input = new Scanner(System.in);

    public static Connection connect() {

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

    public static String WarehouseName() {
        System.out.println("\nPlease enter the name of the warehouse you would like to edit: \n");
        WarehouseName = Input.nextLine();
        return WarehouseName;
    }

    public static void main(String[] args) {
        WarehouseName();
        editWarehouse();
    }

    public static void editWarehouse() {

        System.out.println("\nYou are currently editing warehouse " + WarehouseName + ".\n");
        System.out.println("Edit Warehouse:\n" +
                "Please select a function:\n" +
                "\n" +
                "Press 1: Edit warehouse name\n" +
                "\n" +
                "Press 2: Edit warehouse location\n" +
                "\n" +
                "Press 3: Edit warehouse available space\n" +
                "\n" +
                "Press 4: Edit warehouse used space\n" +
                "\n" +
                "Press 5: Return to warehouse information\n");

        int choice;
            choice = Input.nextInt();
            Input.nextLine();
            switch (choice) {
                case 1:
                    warehouseName();
                    break;
                case 2:
                    warehouseLocation();
                    break;
                case 3:
                    warehouseAvailableSpace();
                    break;
                case 4:
                    warehouseUsedSpace();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("That was not a valid input please try again\n");
                    editWarehouse();
            }
    }

    public static void warehouseName() {
        Connection conn = connect();

        System.out.println("Please enter the new warehouse name: ");
        String wName = Input.nextLine();
        String sql = "UPDATE Warehouses SET Warehouse_Name = ? WHERE Warehouse_Name = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, wName);
            pstmt.setString(2, WarehouseName);
            pstmt.executeUpdate();
            System.out.println("Update successful!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        WarehouseName = wName;
        editWarehouse();
    }

    public static void warehouseLocation() {
        Connection conn = connect();

        System.out.println("Please enter the new warehouse location: ");
        String wLocation = Input.nextLine();
        String sql = "UPDATE Warehouses SET Warehouse_Location = ? WHERE Warehouse_Name = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, wLocation);
            pstmt.setString(2, WarehouseName);
            pstmt.executeUpdate();
            System.out.println("Update successful!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        editWarehouse();
    }

    public static void warehouseAvailableSpace() {
        Connection conn = connect();

        System.out.println("Please enter the new warehouse available space: ");
        String wAvailableSpace = Input.nextLine();
        String sql = "UPDATE Warehouses SET Warehouse_AvailableSpace = ? WHERE Warehouse_Name = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, wAvailableSpace);
            pstmt.setString(2, WarehouseName);
            pstmt.executeUpdate();
            System.out.println("Update successful!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        editWarehouse();
    }

    public static void warehouseUsedSpace() {
        Connection conn = connect();

        System.out.println("Please enter the new warehouse used space: ");
        String wUsedSpace = Input.nextLine();
        String sql = "UPDATE Warehouses SET Warehouse_UsedSpace = ? WHERE Warehouse_Name = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, wUsedSpace);
            pstmt.setString(2, WarehouseName);
            pstmt.executeUpdate();
            System.out.println("Update successful!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        editWarehouse();
    }
}
