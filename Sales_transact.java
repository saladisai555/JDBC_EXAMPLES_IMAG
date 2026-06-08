import java.util.*;
import java.sql.*;
import java.lang.*;
public class Sales_transact {
    public static void main(String[] args){
        try{
            Scanner sc=new Scanner(System.in);
            System.out.println("enter input values");
            int trans_id=sc.nextInt();
            int prod_id=sc.nextInt();
            int quantity=sc.nextInt();
            int price=sc.nextInt();

            Connection con=DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1434;"+
                            "databaseName=Jdbc_db;"+
                            "encrypt=true;"+
                            "trustServerCertificate=true;",
                    "sa",
                    "SqlServer@123"
            );
            Statement st=con.createStatement();
            String s="CREATE TABLE Sales(trans_id INT,prod_id INT,quantity INT,price INT)";
            st.executeUpdate(s);

            PreparedStatement ps =con.prepareStatement("INSERT into Sales(trans_id,prod_id,quantity,price) VALUES(?,?,?,?)");
            ps.setInt(1,trans_id);
            ps.setInt(2,prod_id);
            ps.setInt(3,quantity);
            ps.setInt(4,price);
            int n=ps.executeUpdate();

            System.out.println(
                    n +"rows inserted"
            );
            ps.close();
            con.close();
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
