package yuksi.Database;

import java.sql.*;

public class Guncelle extends Baglan {

    public Guncelle(Connection con, String sorgu) {
        super(con);
        try {
            Statement durum = con.createStatement();
            durum.execute(sorgu);
            System.out.println("Update işlemi başarılı");
        } catch (Exception e) {
            System.out.println("Update işlemi Hatalı");
        }
    }
}
