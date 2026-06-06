import java.util.*;
import java.sql.*;

public class Product_1 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            int id = sc.nextInt();
            String name = sc.nextLine();
            String cat = sc.nextLine();
            int price = sc.nextInt();

            Connection con = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1434;" +
                            "databaseName=Jdbc_db;" +
                            "encrypt=true;" +
                            "trustServerCertificate=true;",
                    "sa",
                    "SqlServer@123"
            );

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO product(prod_id, prod_name, category, price) VALUES (?, ?, ?, ?)"
            );

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, cat);
            ps.setInt(4, price);  // ✅ fixed

            int n = ps.executeUpdate();
            System.out.println(n + " row(s) inserted");

            ps.close();
            con.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
