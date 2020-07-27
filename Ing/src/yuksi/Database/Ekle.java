package yuksi.Database;

import java.sql.*;

public class Ekle extends Baglan {

    public Ekle(Connection con, String sorgu) {
        super(con);
        try {
            Statement stm = con.createStatement();
            stm.executeUpdate(sorgu);
        } catch (SQLException ex) {
            System.out.println("Eklemede hata");
        }
        System.out.println("EKLEME BASARILI");
    }
}
