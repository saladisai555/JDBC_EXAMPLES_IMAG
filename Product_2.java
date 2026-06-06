import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Product_2 {

    public static void main(String[] args) throws Exception {

        Connection con = DriverManager.getConnection(
                "jdbc:sqlserver://localhost:1434;" +
                        "databaseName=Jdbc_db;" +
                        "encrypt=true;" +
                        "trustServerCertificate=true;",
                "sa",
                "SqlServer@123"
        );

        // Insert Records
        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO product(prod_id, prod_name) VALUES(?, ?)"
        );

        ps.setInt(1, 101);
        ps.setString(2, "Mouse");
        ps.executeUpdate();

        ps.setInt(1, 102);
        ps.setString(2, "Keyboard");
        ps.executeUpdate();

        // Update Records
        PreparedStatement ps1 = con.prepareStatement(
                "UPDATE product SET prod_name=? WHERE prod_id=?"
        );

        ps1.setString(1, "New Mouse");
        ps1.setInt(2, 101);
        ps1.executeUpdate();

        ps1.setString(1, "New Keyboard");
        ps1.setInt(2, 102);

        int n = ps1.executeUpdate();

        System.out.println(n + " row(s) updated");

        ps.close();
        ps1.close();
        con.close();
    }
}