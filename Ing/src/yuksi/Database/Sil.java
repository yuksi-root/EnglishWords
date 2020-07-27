package yuksi.Database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sil extends Baglan {

    Statement silmeDurumu = null;

    public Sil(Connection con, String sorgu) {
        super(con);
        try {
            silmeDurumu = con.createStatement();
            silmeDurumu.executeUpdate(sorgu);
            System.out.println("Silme işlemi başarıyla Gerçekleşmiştir");
        } catch (SQLException ex) {
            Logger.getLogger(Sil.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Silmede Hata");
        }
    }
}
