package yuksi.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class VerileriGoster extends Baglan {

    public VerileriGoster(Connection con) {
        super(con);
    }

    String makeColor(String cumle, String kelime) {
        if (cumle.contains(kelime)) {
            String bas;
            String son;

            bas = cumle.substring(0, cumle.indexOf(kelime));
            son = cumle.substring(cumle.indexOf(kelime) + kelime.length());

            bas = bas.concat("<font color=\"red\">" + kelime + "</font>" + son + "</html>");

            return "<html>" + bas;
        }
        return cumle;
    }

    public DefaultTableModel getTable(String tablo, DefaultTableModel getModel) {
        int colmnCount = getColumnCount(tablo);
        Object[] objeler = new Object[colmnCount];
        for (int k = 0; k < colmnCount; k++) {
            objeler[k] = new Object();
        }
        for (int k = 0; k < getKullaniciSayisi(tablo); k++) {
            for (int j = 0; j < colmnCount; j++) {
                if (tablo.equals("ING")) {
                    switch (j) {
                        case 1:
                            objeler[j] = "<html><font color=\"red\">" + getInfo(tablo, j + 1, k + 1)
                                    + "</font></html>";
                            break;
                        case 2:
                            objeler[j] = makeColor(getInfo(tablo, j + 1, k + 1), getInfo(tablo, j, k + 1));
                            break;
                        default:
                            objeler[j] = getInfo(tablo, j + 1, k + 1);
                            break;
                    }
                } else {
                    objeler[j] = getInfo(tablo, j + 1, k + 1);
                }
            }
            getModel.insertRow(getModel.getRowCount(), objeler);
        }
        return getModel;
    }

    private int getKullaniciSayisi(String tablo) {
        int x = 0;
        try {
            Statement durum = con.createStatement();
            ResultSet result = durum.executeQuery("select * from " + tablo);
            while (result.next()) {
                x++;
            }
        } catch (SQLException ex) {
            System.out.println("kullanıcı sayısı Gösterirken Hata");
        }
        return x;
    }

    private int getColumnCount(String tablo) {
        int x = 0;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from " + tablo);
            ResultSetMetaData rsmd = rs.getMetaData();
            x = rsmd.getColumnCount();

        } catch (SQLException ex) {
            System.out.println("kolon sayısı çağırılırken hata(getColumnCount) oluştu");
        }
        return x;
    }

    private String getInfo(String tablo, int row, int x) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from " + tablo);
            for (int k = 0; k < x; k++) {
                rs.next();
            }
            return rs.getString(row);

        } catch (SQLException ex) {
            System.out.println("Bilgi  çağırırken hata (getInfo)oluştu");
        }
        return "HATA(getInfo)";
    }
}
