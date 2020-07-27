package yuksi.GUI;


import yuksi.Database.Ekle;
import yuksi.Database.Guncelle;
import yuksi.Database.Sil;
import yuksi.Database.VerileriGoster;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Main extends javax.swing.JPanel {

    Connection con;
    Sinav sinav;
    JFrame frame;
    String soruKelime, soruCumle, ad, soyad, sonEkleme, id;
    VerileriGoster vg;
    DefaultTableModel modelING, modelSinavlarz, modelIST;
    boolean guncelle = false;
    static int kelimeId;
    static boolean geri = false;
    boolean bildiMi;

    public Main(JFrame frame) {
        initComponents();
        this.id = id;
       
        this.frame =frame;
        frame.setContentPane(this);
        frame.setSize(1350, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        mainKisaltma();
        sinav = new Sinav();
        vg = new VerileriGoster(con);
        modelING = vg.getTable("ING", (DefaultTableModel) ING.getModel());
        modelSinavlarz = vg.getTable("Sınavlar", (DefaultTableModel) Sinavlar.getModel());
        modelIST = vg.getTable("İstatistikler", (DefaultTableModel) IST.getModel());
        UpdateIstatistik();
        bilgi.setVisible(false);
        evet.setVisible(false);
        hayir.setVisible(false);
        ipucu.setVisible(false);

    }

  
    public void update(boolean bildiMi) {
        int x = 0;
        if (sinav.updateSinav(bildiMi) == true) {
            sinav.sinavBasla();
            System.out.println("next" + x++);
            soru.setText(sinav.kelime);
        } else {
            System.out.println("Bitti" + x++);
            SinavBitti();
        }
    }

    public void SinavBitti() {
        String sorgu = "INSERT INTO Sınavlar (SınavNo,DoğruSayısı,YanlışSayısı,SoruSayısı,Tarih)"
                + " VALUES (" + (sinav.getSinavNo() + 1) + "," + sinav.bildi + "," + sinav.bilemedi
                + "," + sinav.soruSayisi + ",getdate()" + ")";

        Ekle exz = new Ekle(con, sorgu);
        for (int i = modelSinavlarz.getRowCount() - 1; i >= 0; i--) {
            modelSinavlarz.removeRow(i);
        }
        modelSinavlarz = vg.getTable("Sınavlar", (DefaultTableModel) Sinavlar.getModel());
        cumlex.setText("Bilinen Kelime : " + sinav.bildi);
        bilgi.setText("Bilinemeyen Kelime :" + sinav.bilemedi);
        basla.setVisible(false);
        evet.setVisible(false);
        hayir.setVisible(false);
        ipucu.setVisible(false);

    }

    private void mainKisaltma() {
        ImageIcon img = new ImageIcon("C:\\Users\\yuksel\\Documents\\NetBeansProjects\\Ing\\Ing\\images\\ss.png");
        resim.setIcon(img);
        if (geri == true) {
            MainPane.setSelectedIndex(1);
            geri = false;
        } else {
            MainPane.setSelectedIndex(0);
        }
        ING.getColumnModel().getColumn(0).setPreferredWidth(2);
        ING.getColumnModel().getColumn(1).setPreferredWidth(175);
        ING.getColumnModel().getColumn(2).setPreferredWidth(800);
        ING.getColumnModel().getColumn(3).setPreferredWidth(50);
        ING.setRowHeight(20);
        ING.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

      
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;database=English;user=root;password=1234");
        } catch (SQLException ex) {
            System.out.println("Bağlantı Hatası MAİN");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPane = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        resim = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        trCumle = new javax.swing.JTextField();
        btnSil = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        trKelime = new javax.swing.JTextField();
        btnEkle = new javax.swing.JButton();
        btnDuzenle = new javax.swing.JButton();
        boxAra = new javax.swing.JTextField();
        btnAra = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ING = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        boxKelime = new javax.swing.JTextField();
        boxCumle = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        soru = new javax.swing.JLabel();
        evet = new javax.swing.JButton();
        hayir = new javax.swing.JButton();
        cumlex = new javax.swing.JLabel();
        ipucu = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        bilgi = new javax.swing.JLabel();
        basla = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        IST = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Sinavlar = new javax.swing.JTable();

        setLayout(null);

        MainPane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        resim.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(resim);
        resim.setBounds(20, 70, 1210, 390);

        jLabel16.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 51, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("HOŞGELDİNİZ");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(440, 10, 360, 40);

        MainPane.addTab("Anasayfa", jPanel2);

        jPanel1.setBackground(new java.awt.Color(204, 153, 0));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(139, 69, 0));
        jLabel2.setText("TR:CÜMLE");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 120, 110, 30);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SUBJECT + AUXVERB + OBJECT + ADJECTIVE + PLACE + TİME");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(620, 10, 570, 30);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(139, 69, 0));
        jLabel3.setText("CÜMLE YAPISI");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 10, 150, 30);

        trCumle.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(trCumle);
        trCumle.setBounds(110, 120, 1110, 30);

        btnSil.setText("Sil");
        btnSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSilActionPerformed(evt);
            }
        });
        jPanel1.add(btnSil);
        btnSil.setBounds(1140, 40, 70, 30);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(139, 69, 0));
        jLabel8.setText("TR:KELİME");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(10, 160, 110, 30);

        trKelime.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(trKelime);
        trKelime.setBounds(120, 160, 580, 30);

        btnEkle.setText("Ekle");
        btnEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEkleActionPerformed(evt);
            }
        });
        jPanel1.add(btnEkle);
        btnEkle.setBounds(960, 40, 70, 30);

        btnDuzenle.setText("Düzenle");
        btnDuzenle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDuzenleActionPerformed(evt);
            }
        });
        jPanel1.add(btnDuzenle);
        btnDuzenle.setBounds(1040, 40, 90, 30);
        jPanel1.add(boxAra);
        boxAra.setBounds(760, 160, 370, 30);

        btnAra.setText("Ara");
        btnAra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAraActionPerformed(evt);
            }
        });
        jPanel1.add(btnAra);
        btnAra.setBounds(1140, 160, 70, 30);

        ING.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ING.setForeground(new java.awt.Color(0, 51, 204));
        ING.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Kelime", "Cümle", "Tarih"
            }
        ));
        ING.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                INGMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ING);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(2, 200, 1220, 250);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ÖZNE +  Y.FİİL + NESNE + SIFAT + YER + ZAMAN");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(170, 10, 430, 30);

        boxKelime.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(boxKelime);
        boxKelime.setBounds(110, 40, 590, 30);

        boxCumle.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(boxCumle);
        boxCumle.setBounds(110, 80, 1110, 30);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(139, 69, 0));
        jLabel9.setText("KELİME");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(10, 40, 110, 30);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(139, 69, 0));
        jLabel10.setText("CÜMLE");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(10, 80, 110, 30);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1245, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                .addContainerGap())
        );

        MainPane.addTab("Ekle", jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(204, 153, 0));
        jPanel3.setLayout(null);

        soru.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        soru.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        soru.setText("QUİZ");
        jPanel3.add(soru);
        soru.setBounds(0, 10, 1250, 100);

        evet.setText("Evet");
        evet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                evetActionPerformed(evt);
            }
        });
        jPanel3.add(evet);
        evet.setBounds(290, 370, 150, 70);

        hayir.setText("Hayır");
        hayir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hayirActionPerformed(evt);
            }
        });
        jPanel3.add(hayir);
        hayir.setBounds(500, 370, 160, 70);

        cumlex.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        cumlex.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(cumlex);
        cumlex.setBounds(0, 150, 1250, 90);

        ipucu.setText("Cümle");
        ipucu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ipucuActionPerformed(evt);
            }
        });
        jPanel3.add(ipucu);
        ipucu.setBounds(730, 370, 170, 70);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel3.add(jLabel7);
        jLabel7.setBounds(20, 50, 300, 20);

        bilgi.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        bilgi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bilgi.setText("Biliyor Musun  ?");
        jPanel3.add(bilgi);
        bilgi.setBounds(0, 250, 1250, 90);

        basla.setText("BAŞLA");
        basla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baslaActionPerformed(evt);
            }
        });
        jPanel3.add(basla);
        basla.setBounds(70, 370, 160, 70);

        jPanel6.add(jPanel3);
        jPanel3.setBounds(0, 10, 1250, 450);

        MainPane.addTab("Sınav", jPanel6);

        jPanel4.setBackground(new java.awt.Color(204, 153, 0));
        jPanel4.setLayout(null);

        IST.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Toplam Kelime", "Toplam Cümle", "Toplam Sınav", "Tarih"
            }
        ));
        jScrollPane2.setViewportView(IST);

        jPanel4.add(jScrollPane2);
        jScrollPane2.setBounds(10, 100, 1210, 370);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("MEVCUT İSTATİSTİKLER");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(190, 30, 870, 50);

        MainPane.addTab("İstatistikler", jPanel4);

        jPanel7.setLayout(null);

        Sinavlar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SınavNo", "Doğru Sayısı", "Yanlış Sayısı", "Soru Sayısı", "Tarih"
            }
        ));
        jScrollPane3.setViewportView(Sinavlar);

        jPanel7.add(jScrollPane3);
        jScrollPane3.setBounds(15, 10, 1230, 450);

        MainPane.addTab("Sınavlar", jPanel7);

        add(MainPane);
        MainPane.setBounds(0, 0, 1260, 500);
    }// </editor-fold>//GEN-END:initComponents

    private void ipucuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ipucuActionPerformed
        cumlex.setVisible(true);
        cumlex.setText(sinav.cumle);
    }//GEN-LAST:event_ipucuActionPerformed

    private void hayirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hayirActionPerformed
        update(false);
    }//GEN-LAST:event_hayirActionPerformed

    private void evetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_evetActionPerformed
        update(true);
    }//GEN-LAST:event_evetActionPerformed

    private void btnAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAraActionPerformed
        String sorgu = "SELECT * FROM ING "
                + "WHERE Kelime='" + boxAra.getText() + "'";
        int konum = getArananRow(boxAra.getText());
        ING.setRowSelectionInterval(konum, konum);
        ING.scrollRectToVisible(ING.getCellRect(konum, 0, true));
    }//GEN-LAST:event_btnAraActionPerformed

    private void btnDuzenleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDuzenleActionPerformed
        if (ING.getSelectedRow() != -1) {
            guncelle = !guncelle;
            if (guncelle == true) {
                JOptionPane.showMessageDialog(this, "Guncelleme yapılıyor.");
                try {
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("Select Kelime, Cumle, trKelime, trCumle from ING "
                            + " where id=" + modelING.getValueAt(ING.getSelectedRow(), 0));
                    rs.next();
                    boxKelime.setText(rs.getString(1));
                    boxCumle.setText(rs.getString(2));
                    trKelime.setText(rs.getString(3));
                    trCumle.setText(rs.getString(4));
                } catch (SQLException ex) {
                    System.out.println("Kelime bilgilerini alırken hata oluştu");
                }
            } else {
                trCumle.setText("");
                trKelime.setText("");
                boxKelime.setText("");
                boxCumle.setText("");
                JOptionPane.showMessageDialog(this, "Guncelleme islemi iptal edildi.");
            }
        }
    }//GEN-LAST:event_btnDuzenleActionPerformed

    private void btnEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEkleActionPerformed
        if (guncelle == true) {
            if (!trCumle.getText().equals("") && !trKelime.getText().equals("")) {
                String sorgu = "update ING set Kelime='" + boxKelime.getText()
                        + "' ,Cumle='" + boxCumle.getText() + "' ,trKelime='" + trKelime.getText()
                        + "' ,trCumle='" + trCumle.getText() + "'"
                        + " where id=" + modelING.getValueAt(ING.getSelectedRow(), 0);
                Guncelle g = new Guncelle(con, sorgu);
                for (int i = modelING.getRowCount() - 1; i >= 0; i--) {
                    modelING.removeRow(i);
                }
                modelING = vg.getTable("ING", (DefaultTableModel) ING.getModel());
                trKelime.setText("");
                trCumle.setText("");
                boxKelime.setText("");
                boxCumle.setText("");
                guncelle = false;
            } else {
                JOptionPane.showMessageDialog(this, "Bütün Alanları Doldurun");
            }
        } else {
            if (!trCumle.getText().equals("") && !trKelime.getText().equals("")) {
                String sorgu1 = "INSERT INTO ING (id,Kelime,Cumle,Tarih,trKelime,trCumle)"
                        + " VALUES (" + (sinav.getINGid() + 1) + ",'" + boxKelime.getText() + "','" + boxCumle.getText()
                        + "',getdate()" + ",'" + trKelime.getText() + "','" + trCumle.getText() + "'"
                        + ")";
                Ekle e1 = new Ekle(con, sorgu1);
                for (int i = modelING.getRowCount() - 1; i >= 0; i--) {
                    modelING.removeRow(i);
                }
                modelING = vg.getTable("ING", (DefaultTableModel) ING.getModel());
                UpdateIstatistik();
                trKelime.setText("");
                trCumle.setText("");
                boxKelime.setText("");
                boxCumle.setText("");

            } else {
                JOptionPane.showMessageDialog(this, "Bütün Alanları Doldurun");
            }
        }
    }//GEN-LAST:event_btnEkleActionPerformed

    private void btnSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSilActionPerformed

        String sorgu = "DELETE  ING WHERE id="
                + modelING.getValueAt(ING.getSelectedRow(), 0);
        Sil sil = new Sil(con, sorgu);
        for (int i = modelING.getRowCount() - 1; i >= 0; i--) {
            modelING.removeRow(i);
        }
        modelING = vg.getTable("ING", (DefaultTableModel) ING.getModel());
        UpdateIstatistik();
    }//GEN-LAST:event_btnSilActionPerformed
    private int getKelimeId() {
        int x = 0;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select id from ING "
                    + " where id=" + modelING.getValueAt(ING.getSelectedRow(), 0));
            rs.next();
            x = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println("kelimeId hata oluştu");
        }
        return x;
    }
    private void INGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_INGMouseClicked
        if (ING.getSelectedColumn() == 2) {
            kelimeId = getKelimeId();
            TurkceIcerik ti;
            ti = new TurkceIcerik(frame, id);
            geri = true;
        }
    }//GEN-LAST:event_INGMouseClicked

    private void baslaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baslaActionPerformed
        sinav.sinavBasla();
        soru.setText(sinav.kelime);
        evet.setVisible(true);
        hayir.setVisible(true);
        ipucu.setVisible(true);
        bilgi.setVisible(true);
    }//GEN-LAST:event_baslaActionPerformed
    public void UpdateIstatistik() {
        InsertIstatistik();
        String SorguT2 = " update İstatistikler set ToplamKelime=" + (sinav.getTopKelime());
        SorguT2 += " update İstatistikler set ToplamCumle=" + (sinav.getTopCumle());
        SorguT2 += " update İstatistikler set ToplamSinav=" + (sinav.getToplamSınav());
        SorguT2 += " update İstatistikler set Tarih=getdate()";
        SorguT2 += " update Kullanici set sonGiris=getdate() where id=" + id;
        Guncelle g1 = new Guncelle(con, SorguT2);
        for (int i = modelIST.getRowCount() - 1; i >= 0; i--) {
            modelIST.removeRow(i);
        }
        modelIST = vg.getTable("İstatistikler", (DefaultTableModel) IST.getModel());
    }

    public void InsertIstatistik() {
        String sorguT1 = "INSERT INTO İstatistikler (ToplamKelime,ToplamCumle,ToplamSinav,Tarih)"
                + " VALUES(" + (sinav.getTopKelime()) + "," + (sinav.getTopCumle()) + ","
                + (sinav.getToplamSınav()) + ",getdate())";
        Ekle ez = new Ekle(con, sorguT1);
        for (int i = modelIST.getRowCount() - 1; i >= 0; i--) {
            modelIST.removeRow(i);
        }
    }

    private int getArananRow(String aranan) {
        for (int i = 0; i < ING.getRowCount(); i++) {
            if (ING.getModel().getValueAt(i, 1).equals(aranan)) {
                return i;
            }
        }
        return 0;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ING;
    private javax.swing.JTable IST;
    private javax.swing.JTabbedPane MainPane;
    private javax.swing.JTable Sinavlar;
    private javax.swing.JButton basla;
    private javax.swing.JLabel bilgi;
    private javax.swing.JTextField boxAra;
    private javax.swing.JTextField boxCumle;
    private javax.swing.JTextField boxKelime;
    private javax.swing.JButton btnAra;
    private javax.swing.JButton btnDuzenle;
    private javax.swing.JButton btnEkle;
    private javax.swing.JButton btnSil;
    private javax.swing.JLabel cumlex;
    private javax.swing.JButton evet;
    private javax.swing.JButton hayir;
    private javax.swing.JButton ipucu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel resim;
    private javax.swing.JLabel soru;
    private javax.swing.JTextField trCumle;
    private javax.swing.JTextField trKelime;
    // End of variables declaration//GEN-END:variables
}
