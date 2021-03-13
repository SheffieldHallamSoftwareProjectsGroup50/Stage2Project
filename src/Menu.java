import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Connection conn = connect();
        Scanner mainPageChoice = new Scanner(System.in);
        System.out.println("Hello there, this is an Inventory Management Application.\n" +
                "Please Login using your username and password or create a new account.\n" +
                "\n" +
                "Press 1: To login\n" +
                "Press 2: To sign up");
        switch (mainPageChoice.nextInt()) {
            case 1:
                UserLogin.Login();
                break;
            case 2:
                UserLogin.Register();
                break;
            default:
                System.out.println("That was not a valid input please try again");
                main(null);
        }

    }


    public static void ManagerMenu() {
        Scanner managerChoice = new Scanner(System.in);
        String department = "Manager";
        System.out.println("Manager Home Page:\n" +
                "Please select a function:\n" +
                "\n" +
                "Press 1: To manage Product Information\n" +
                "\n" +
                "Press 2: To manage Warehouse Information\n" +
                "\n" +
                "Press 3: To manage Purchases\n" +
                "\n" +
                "Press 4: To manage Inquiries\n" +
                "\n" +
                "Press 5: To manage Users\n" +
                "\n" +
                "Press 6: To log out\n");
        switch (managerChoice.nextInt()) {
            case 1:
                manageProductInformation(department);
                break;
            case 2:
                manageWarehouseInformation(department);
                break;
            case 3:
                managePurchases(department);
                break;
            case 4:
                manageInquiries(department);
                break;
            case 5:
                manageUserDatabase(department);
                break;
            case 6:
                logOut();
                break;
            default:
                System.out.println("That was not a valid input please try again");
                ManagerMenu();
        }

    }

    public static void ProductionMenu() {
        Scanner productionChoice = new Scanner(System.in);
        String department = "Production";
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
        switch (productionChoice.nextInt()) {
            case 1:
                manageProductInformation(department);
                break;
            case 2:
                manageWarehouseInformation(department);
                break;
            case 3:
                ViewOrders.main(null);
                break;
            case 4:
                contactPurchasing(department);
                break;
            case 5:
                logOut();
                break;
            default:
                System.out.println("That was not a valid input please try again");
                ProductionMenu();
        }

    }

    public static void PurchasingMenu() {
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

    public static void SalesMenu() {
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

    public static void CustomerMenu() {
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

    private static void manageProductInformation(String department) {
        Scanner productChoice = new Scanner(System.in);
        System.out.println("Product Information:\n" +
                "Please select a function:\n" +
                "\n" +
                "Press 1: To add a Product\n" +
                "\n" +
                "Press 2: To search Products\n" +
                "\n" +
                "Press 3: To delete a Product\n" +
                "\n" +
                "Press 4: To View Products\n" +
                "\n" +
                "Press 5: To return Home");
        switch (productChoice.nextInt()) {
            case 1:
                InsertProducts.main(null);
                break;
            case 2:
                SearchProducts.main(null);
                break;
            case 3:
                DeleteProducts.main(null);
            case 4:
                ViewProducts.main(null);
            case 5:
                returnHome(department);
            default:
                System.out.println("That was not a valid input please try again");
                manageProductInformation(department);

        }
    }

        private static void manageWarehouseInformation (String department) {
        Scanner warehouseChoice = new Scanner(System.in);
            System.out.println("Warehouse Information:\n" +
                    "Please select a function:\n" +
                    "\n" +
                    "Press 1: To add a Warehouse\n" +
                    "\n" +
                    "Press 2: To search Warehouses\n" +
                    "\n" +
                    "Press 3: To delete a Warehouse\n" +
                    "\n" +
                    "Press 4: To View Warehouses\n" +
                    "\n" +
                    "Press 5: To return Home");
            switch (warehouseChoice.nextInt()) {
                case 1:
                    InsertWarehouse.main(null);
                    break;
                case 2:
                    SearchWarehouses.main(null);
                    break;
                case 3:
                    DeleteWarehouse.main(null);
                case 4:
                    ViewWarehouses.main(null);
                case 5:
                    returnHome(department);
                default:
                    System.out.println("That was not a valid input please try again");
                    manageWarehouseInformation(department);

            }

        }

        private static void managePurchases (String department) {
        Scanner purchaseChoice = new Scanner(System.in);
            System.out.println("Purchase Information:\n" +
                    "Please select a function:\n" +
                    "\n" +
                    "Press 1: To add a Purchase\n" +
                    "\n" +
                    "Press 2: To search Purchases\n" +
                    "\n" +
                    "Press 3: To delete a Purchase\n" +
                    "\n" +
                    "Press 4: To View Purchases\n" +
                    "\n" +
                    "Press 5: To return Home");
            switch (purchaseChoice.nextInt()) {
                case 1:
                    InsertOrders.main(null);
                    break;
                case 2:
                    SearchOrders.main(null);
                    break;
                case 3:
                    DeleteOrder.main(null);
                case 4:
                    ViewOrders.main(null);
                case 5:
                    returnHome(department);
                default:
                    System.out.println("That was not a valid input please try again");
                    managePurchases(department);
            }

        }

        private static void manageInquiries (String department) {
            System.out.println("Inquiries Page:\n" +
                    "Unread inquiries 10\n" +
                    "Listing inquiries from oldest to newest\n" +
                    "\n" +
                    "\"Hello do you know when the wooden desk with cast \n" +
                    "iron accents will be available to purchase? I noticed it was on the \n" +
                    "pre-order list and wondered when I would be able to buy \n" +
                    "it for my mother.\"\n" +
                    "\n" +
                    "Press 1: To write a reply\n" +
                    "\n" +
                    "Press 2: To ignore (and state reason)\n" +
                    "\n" +
                    "Press 3: To return Home\n");

        }

        private static void manageUserDatabase (String department) {
        Scanner purchaseChoice = new Scanner(System.in);
        System.out.println("User Information:\n" +
                    "Please select a function:\n" +
                    "\n" +
                    "Press 1: To add a User\n" +
                    "\n" +
                    "Press 2: To search Users\n" +
                    "\n" +
                    "Press 3: To delete a User\n" +
                    "\n" +
                    "Press 4: To View Users\n" +
                    "\n" +
                    "Press 5: To return Home");
            switch (purchaseChoice.nextInt()) {
                case 1:
                    InsertUser.main(null);
                    break;
                case 2:
                    SearchUsers.main(null);
                    break;
                case 3:
                    DeleteUsers.main(null);
                case 4:
                    ViewUsers.main(null);
                case 5:
                    returnHome(department);
                default:
                    System.out.println("That was not a valid input please try again");
                    manageUserDatabase(department);
            }

        }

        private static void returnHome(String department){
            if (department.equals("Manager")) {
                ManagerMenu();
            } else if (department.equals("Sales")) {
                SalesMenu();
            } else if (department.equals("Production")) {
                ProductionMenu();
            } else if (department.equals("Purchasing")) {
                ProductionMenu();
            } else {
                main(null);
            }
        }

        private static void contactPurchasing(String department){

        }

        private static void logOut () {

        }

        private static Connection connect () {

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
}



