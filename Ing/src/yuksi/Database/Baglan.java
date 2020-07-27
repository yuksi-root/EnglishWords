package yuksi.Database;

import java.sql.*;

public class Baglan {

    Connection con;

    public Baglan(Connection con) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.con = con;
            System.out.println("Database Bağlantısı Başarılı...");
        } catch (Exception e) {
            System.out.println("Bağlantıda bir problem oluştu.");
        }
    }

    public void Baglanti(Connection con) {
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;database=Kutuphane;user=root;password=1234");

        } catch (SQLException ex) {
            System.out.println("Bağlantı Hatası");
        }
    }
}
