import java.util.*;
import java.sql.*;
public class Product_3 {

    public static void main(String[] args){
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1434;" +
                            "databaseName=Jdbc_db;" +
                            "encrypt=true;" +
                            "trustServerCertificate=true;",
                    "sa",
                    "SqlServer@123"
            );
            Scanner sc = new Scanner(System.in);
            int prod_id = sc.nextInt();
            sc.nextLine();
            String prod_name = sc.nextLine();
            PreparedStatement ps = con.prepareStatement("UPDATE product set prod_name=? where prod_id=?");
            ps.setInt(2, prod_id);
            ps.setString(1, prod_name);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        }
    }

