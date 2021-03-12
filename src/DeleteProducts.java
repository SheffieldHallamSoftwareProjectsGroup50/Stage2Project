import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteProducts {

    public static void main (String [] args)
    {
        Scanner keyboard = new Scanner(System.in);
        ViewProducts view = new ViewProducts();

        System.out.println("Which product would you like to delete");
        view.main(args);
        System.out.println("Enter the ID: ");
        int deleteID = keyboard.nextInt();


        DeleteProducts delete = new DeleteProducts();
        delete.deleteRecord(deleteID);



    }

    public void deleteRecord(int Product_ID){

        Connection conn = connect();
        String sql = "DELETE FROM Products WHERE Product_ID = ?";



        try {

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, Product_ID);
            pstmt.executeUpdate();
            System.out.println("A record has been deleted");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }





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
}
