import java.sql.*;
import java.util.ArrayList;

public class ViewProducts {
    public static void main (String [] args)
    {
        //we need to write dbconnection code here!

        Connection conn = connect();
        ArrayList<ArrayList<Object>> data;

        try {
            String sql = "SELECT Product_Id,Product_Name,Product_Category,Product_Description,Product_Supplier,Product_Price,Product_Quantity,Product_Status,Product_Location FROM Products";

            Statement stmt  = conn.createStatement();
            data = new ArrayList<ArrayList<Object>>();

            ResultSet res = stmt.executeQuery(sql);
            {
                // loop through the result set
                while (res.next()) {

                    int pId = res.getInt("Product_Id");
                    String pName = res.getString("Product_Name");
                    String pCategory = res.getString("Product_Category");
                    String pDescription = res.getString("Product_Description");
                    String pSupplier = res.getString("Product_Supplier");
                    double pPrice = res.getDouble("Product_Price");
                    int pQuantity = res.getInt("Product_Quantity");
                    String pStatus = res.getString("Product_Status");
                    String pLocation = res.getString("Product_Location");

                    ArrayList<Object> rec = new ArrayList<Object>();
                    rec.add(pId);
                    rec.add(pName);
                    rec.add(pCategory);
                    rec.add(pDescription);
                    rec.add(pSupplier);
                    rec.add(pPrice);
                    rec.add(pQuantity);
                    rec.add(pStatus);
                    rec.add(pLocation);



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
