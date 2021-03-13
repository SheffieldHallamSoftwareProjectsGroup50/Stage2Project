import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Connection conn = connect();
        Scanner mainPageChoice = new Scanner(System.in);
        System.out.println("Hello there, this is an Inventory Management Application.\n" +
                "Please Login using your username and password or create a new account.\n" +
                "\n" +
                "Press 1: To login\n" +
                "Press 2: To sign up");
        switch (mainPageChoice.nextInt()) {
            case 1:UserLogin.Login();break;
            case 2:UserLogin.Register();break;
            default:System.out.println("That was not a valid input please try again");main(null);
        }

    }


    private static void ManagerMenu(){
        System.out.println("Manager Home Page:\n" +
                "Please select a function:\n" +
                "\n" +
                "Press 1: To manage Product Information\n" +
                "\n" +
                "Press 2: To manage Warehouse Information\n" +
                "\n" +
                "Press 3: To manage purchases\n" +
                "\n" +
                "Press 4: To manage inquiries\n" +
                "\n" +
                "Press 5: To manage the user database\n" +
                "\n" +
                "Press 6: To log out\n");

    }

    private static void ProductionMenu(){
        System.out.println("Production Home Page:\n" +
                "Please select a function:\n" +
                "\n" +
                "Press 1: To manage Product Information\n" +
                "\n" +
                "Press 2: To manage Warehouse Information\n" +
                "\n" +
                "Press 3: To view purchases\n" +
                "\n" +
                "Press 4: To contact the Purchasing Department\n" +
                "\n" +
                "Press 5: To log out\n");

    }

    private static void PurchasingMenu(){
        System.out.println("Purchasing Home Page:\n" +
                "Please select a function:\n" +
                "\n" +
                "Press 1: To view Product Information\n" +
                "\n" +
                "Press 2: To view Warehouse Information\n" +
                "\n" +
                "Press 3: To manage purchases\n" +
                "\n" +
                "Press 4: To contact the Production Department\n" +
                "\n" +
                "Press 5: To log out\n");

    }

    private static void SalesMenu(){
        System.out.println("Sales Home Page:\n" +
                "Please Select a function:\n" +
                "\n" +
                "Press 1: To manage inquiries\n" +
                "\n" +
                "Press 2: To view Product Information\n" +
                "\n" +
                "Press 3: To view Warehouse Information\n" +
                "\n" +
                "Press 4: To view purchases\n" +
                "\n" +
                "Press 5: To log out\n");

    }

    private static void CustomerMenu(){
        System.out.println("\n" +
                "Welcome to the store:\n" +
                "Please select a function:\n" +
                "\n" +
                "Press 1: To search available products\n" +
                "\n" +
                "Press 2: To search pre-order products\n" +
                "\n" +
                "Press 3: To ask for help from our Sales Team\n" +
                "\n" +
                "Press 4: To view replies to inquiries\n" +
                "\n" +
                "Press 5: To log out");
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
