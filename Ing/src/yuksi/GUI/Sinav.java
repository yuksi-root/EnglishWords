package yuksi.GUI;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Sinav {

    Connection con;
    Main main;
   
    int bildi = 0;
    int bilemedi = 0;
    int soruSayisi = 0;
    int count = 0;
    String cumle, kelime, id = "";
    static int y = 0;

    public Sinav() {
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;database=English;user=root;password=1234");
        } catch (SQLException ex) {
            System.out.println("Bağlantı Hatası MAİN");
        }
    }

    public boolean updateSinav(boolean bildiMi) {
        soruSayisi = getINGid();
        if (bildiMi == true) {
            bildi++;
            System.out.println("bildi++");
        } else {
            bilemedi++;
        }
        count++;

        return (count < soruSayisi);
    }

    public void sinavBasla() {
        try {
            ResultSet rs;
            Statement stmt = con.createStatement();

            rs = stmt.executeQuery("Select Kelime,Cumle from ING where"
                    + " id=" + (getINGid() - y));
            rs.next();
            kelime = (rs.getString(1));
            cumle = (rs.getString(2));
            y++;

        } catch (SQLException ex) {
            System.out.println("Soru Bilgilerini alırken hata oluştu");
        }
    }

    public int getINGid() {
        int x = 0;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select max(id) from ING");
            rs.next();
            x = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println("Listelerken hata oluştu getid");
        }
        return x;
    }

    public int getToplamSınav() {
        int x = 0;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select count(Tarih) from Sınavlar");
            rs.next();
            x = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println("Listelerken hata oluştu getTSınav");
        }
        return x;
    }

    public int getSinavNo() {
        int x = 0;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select max(SınavNo) from Sınavlar");
            rs.next();
            x = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println("Listelerken hata oluştu getSınav");
        }
        return x;
    }

    public int getTopKelime() {
        int x = 0;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select count(Kelime) from ING");
            rs.next();
            x = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println("Listelerken hata oluştu getKelime");
        }
        return x;
    }

    public int getTopCumle() {
        int x = 0;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select count(Cumle) from ING");
            rs.next();
            x = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println("Listelerken hata oluştu getCumle");
        }
        return x;
    }

}
