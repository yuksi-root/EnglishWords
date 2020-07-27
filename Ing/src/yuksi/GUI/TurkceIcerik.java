package yuksi.GUI;

import yuksi.GUI.Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class TurkceIcerik extends javax.swing.JPanel {

    JFrame frame;
    String id;
    Connection con;
    Main main;
    String res;

    public TurkceIcerik(JFrame frame, String id) {
        initComponents();

        try {
            con = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;database=English;user=root;password=1234");
        } catch (SQLException ex) {
            System.out.println("Bağlantı Hatası MAİN");
        }
        this.id = id;
        this.frame = frame;
        frame.setContentPane(this);
        frame.setSize(1350, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        try {
            ResultSet rs;
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("Select Kelime,Cumle,trKelime,trCumle from ING "
                    + " where id=" + main.kelimeId);
            rs.next();
            ingKelime.setText(rs.getString(1));
            ingCumle.setText(rs.getString(2));
            trKelime.setText(rs.getString(3));
            trCumle.setText(rs.getString(4));
            res = ingKelime.getText();
        } catch (SQLException ex) {
            System.out.println("Icerik Bilgilerini alırken hata oluştu");
        }

        ImageIcon img = new ImageIcon("C:\\Users\\yuksel\\Documents"
                + "\\NetBeansProjects\\Ing\\Ing\\images\\"
                + "" + res + "" + ".png");
        resim.setIcon(img);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ingKelime = new javax.swing.JLabel();
        resim = new javax.swing.JLabel();
        btnGeri = new javax.swing.JButton();
        ingCumle = new javax.swing.JLabel();
        trCumle = new javax.swing.JLabel();
        trKelime = new javax.swing.JLabel();

        setLayout(null);

        ingKelime.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        ingKelime.setForeground(new java.awt.Color(0, 51, 255));
        ingKelime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ingKelime.setText("İNGİLİZCE kelime");
        add(ingKelime);
        ingKelime.setBounds(10, 10, 600, 50);

        resim.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(resim);
        resim.setBounds(0, 60, 1280, 300);

        btnGeri.setText("Geri Dön");
        btnGeri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeriActionPerformed(evt);
            }
        });
        add(btnGeri);
        btnGeri.setBounds(1180, 10, 90, 40);

        ingCumle.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        ingCumle.setForeground(new java.awt.Color(0, 0, 204));
        ingCumle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ingCumle.setText("İNGİLİZCE CÜMLE");
        add(ingCumle);
        ingCumle.setBounds(0, 370, 1280, 100);

        trCumle.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        trCumle.setForeground(new java.awt.Color(153, 0, 153));
        trCumle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        trCumle.setText("TÜRKÇE İÇERİK");
        add(trCumle);
        trCumle.setBounds(0, 500, 1280, 100);

        trKelime.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        trKelime.setForeground(new java.awt.Color(153, 0, 153));
        trKelime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        trKelime.setText("TÜRKÇE KELİME");
        add(trKelime);
        trKelime.setBounds(580, 10, 600, 50);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGeriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeriActionPerformed
        Main ma = new Main(frame);
    }//GEN-LAST:event_btnGeriActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGeri;
    private javax.swing.JLabel ingCumle;
    private javax.swing.JLabel ingKelime;
    private javax.swing.JLabel resim;
    private javax.swing.JLabel trCumle;
    private javax.swing.JLabel trKelime;
    // End of variables declaration//GEN-END:variables
}
