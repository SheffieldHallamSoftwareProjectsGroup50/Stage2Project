import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Inquiries {

    public static void main (String [] args)
    {
        //inquire();
        //viewInquiries();
        //reply();

    }
    public static void inquire() {
        Scanner userChoice = new Scanner(System.in);
        String category = "Empty";

        System.out.println("Please Enter What This Inquiry Is About\nPress 1: Logging In\nPress 2: Searching Store\nPress 3: Other\nPress 4: To Exit");
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
                Inquiries.inquire();
        }
        System.out.println("You have chosen: " + category);
        System.out.println("Please Enter Your Inquiry:");
        userChoice.nextLine();
        String inq = userChoice.nextLine();
        Connection conn = connect();


        try {
            String sqlinsert = "INSERT INTO Inquiries (Category, Inq) VALUES(?,?)";

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



       public static void viewInquiries () {

           Connection conn = connect();
           ArrayList<ArrayList<Object>> data;

           try {
               String sql = "SELECT Category,Inq  FROM Inquiries";

               Statement stmt  = conn.createStatement();
               data = new ArrayList<ArrayList<Object>>();

               ResultSet res = stmt.executeQuery(sql);
               {
                   // loop through the result set
                   while (res.next()) {

                       String Category = res.getString("Category");
                       String Inquiry = res.getString("Inq");

                       ArrayList<Object> rec = new ArrayList<Object>();
                       rec.add(Category);
                       rec.add(Inquiry);



                       data.add(rec);

                   }
               }

               printData(data);

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

    public static void reply () {
        Scanner userChoice = new Scanner(System.in);
        String category = "Empty";

        System.out.println("Please Enter What This Reply Is About\nPress 1: Logging In\nPress 2: Searching Store\nPress 3: Other\nPress 4: To Exit");
        switch (userChoice.nextInt()) {
            case 1:
                category = "Log In Error";
                break;
            case 2:
                category = "Store Search Error";
                break;
            case 3:
                viewInquiries();
                category = "Other";
                break;
            case 4:
                Main.CustomerMenu();
                break;
            default:
                System.out.println("That was not a valid input please try again");
                Inquiries.inquire();
        }
        System.out.println(category);
        System.out.println("Please Enter Your Reply");
        userChoice.nextLine();
        String reply = userChoice.nextLine();
        Connection conn = connect();


        try {
            String sqlinsert = "INSERT INTO Replies (Category, Reply_Text) VALUES(?,?)";

            PreparedStatement prepst = conn.prepareStatement(sqlinsert);
            prepst.setString(1, category);
            prepst.setString(2, reply);

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

    public static void printData (ArrayList<ArrayList<Object>> data)
    {
        for (int i=0; i<data.size(); i++)
        {
            for (int j=0; j<data.get(i).size(); j++)
            {
                System.out.print(data.get(i).get(j));
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    }


