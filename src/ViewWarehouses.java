import java.sql.*;
import java.util.ArrayList;

public class ViewWarehouses {
    public static void main (String [] args)
    {
        //we need to write dbconnection code here!

        Connection conn = connect();
        ArrayList<ArrayList<Object>> data;

        try {
            String sql = "SELECT Warehouse_ID,Warehouse_Name,Warehouse_Location,Warehouse_AvailableSpace,Warehouse_UsedSpace FROM Warehouses";

            Statement stmt  = conn.createStatement();
            data = new ArrayList<ArrayList<Object>>();

            ResultSet res = stmt.executeQuery(sql);
            {
                // loop through the result set
                while (res.next()) {


                    int wID = res.getInt("Warehouse_ID");
                    String wName = res.getString("Warehouse_Name");
                    String wLocation = res.getString("Warehouse_Location");
                    int wAvailableSpace = res.getInt("Warehouse_AvailableSpace");
                    int wUsedSpace = res.getInt("Warehouse_UsedSpace");

                    ArrayList<Object> rec = new ArrayList<Object>();
                    rec.add(wID);
                    rec.add(wName);
                    rec.add(wLocation);
                    rec.add(wAvailableSpace);
                    rec.add(wUsedSpace);




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
