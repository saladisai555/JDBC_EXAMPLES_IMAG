import java.util.*;
import java.lang.*;
import java.sql.*;
public class Trans_roll_back {
    public static void main(String[] args)throws Exception{
        Connection con=null;
        try{
            con=DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1434;"+
                            "databaseName=Jdbc_db;"+
                            "encrypt=true;"+
                            "trustServerCertificate=true",
                             "sa",
                              "SqlServer@123"
            );
            con.setAutoCommit(false);
            PreparedStatement ps=con.prepareStatement("update product set price=? where prod_id=?");
            ps.setInt(1,400);
            ps.setInt(2,1);
            ps.executeUpdate();

            PreparedStatement ps1= con.prepareStatement("update product set price=? where prod_id=?");
            ps1.setInt(1,750);
            ps1.setInt(2,103);

            ps1.executeUpdate();

            con.commit();
            System.out.println("Transaction committed");
            ps.close();
        } catch(Exception ex) {
            ex.printStackTrace();
            System.out.println("Error occurred");
            if(con!=null){
                con.rollback();
            }
            System.out.println("transaction rolled back");
        }finally {
            if(con!=null){
                con.close();
            }
        }
    }

}
