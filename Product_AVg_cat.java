import java.util.*;
import java.sql.*;

public class Product_AVg_cat {
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
            PreparedStatement ps=con.prepareStatement("select category,avg(price) from product group by category ");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                System.out.println(
                        rs.getString(1)+" "+rs.getDouble(2)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
