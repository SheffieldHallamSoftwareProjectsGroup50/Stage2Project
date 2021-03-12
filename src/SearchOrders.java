import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchOrders {

    public static void main (String [] args)
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter Order ID: ");
        String searchID = keyboard.nextLine();


        SearchOrders orderSearch = new SearchOrders();
        orderSearch.queryOrders(searchID);


    }

    public void queryOrders(String Search){

        Connection conn = connect();

        ArrayList<ArrayList<Object>> data;

        try {

            String sql = "SELECT Order_ID,User_ID,Order_Date,Order_Status,Extra_Comments FROM Orders WHERE Order_ID = ?";


            PreparedStatement sqlStatement  = conn.prepareStatement(sql);

            sqlStatement.setString(1,Search);

            data = new ArrayList<ArrayList<Object>>();
            ResultSet res = sqlStatement.executeQuery();
            {

                while (res.next()) {

                    int oId = res.getInt("Order_ID");
                    int uID = res.getInt("User_ID");
                    String oDate = res.getString("Order_Date");
                    String oStatus = res.getString("Order_Status");
                    String eComments = res.getString("Extra_Comments");


                    ArrayList<Object> rec = new ArrayList<Object>();
                    rec.add(oId);
                    rec.add(uID);
                    rec.add(oDate);
                    rec.add(oStatus);
                    rec.add(eComments);


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
