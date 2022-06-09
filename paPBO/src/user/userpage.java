/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package user;

import codingan.Koneksi;
import codingan.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import loginadminuser.Home;

public class userpage extends javax.swing.JFrame {

    Connection koneksi = null;
    PreparedStatement pst = null;
    ResultSet result = null;
    Koneksi classKoneksi = null;
    int idSekarang = 1;
    int indeksTerpilih = -1;

    public userpage() {
        initComponents();
        jLabel1.setText(User.getNama());
        classKoneksi = new Koneksi();
        tablePakaianUpdate();
        tableKeranjangUpdate();
        totalharga();
        koneksi = classKoneksi.getKoneksi();
        try {
            pst = koneksi.prepareStatement("SELECT MAX(id_keranjang) AS maks FROM Keranjang");
            result = pst.executeQuery();
            result.next();
            idSekarang = result.getInt("maks") + 1;
            pst.close();
        } catch (Exception e) {
        }
    }

    public final void tablePakaianUpdate() {
        try {
            koneksi = classKoneksi.getKoneksi();
            pst = koneksi.prepareStatement("SELECT * FROM Pakaian WHERE stock > 0");
            result = pst.executeQuery();
            DefaultTableModel dtm = (DefaultTableModel) tabelPakaian.getModel();
            dtm.setRowCount(0);
            while (result.next()) {
                dtm.addRow(new Object[]{
                    result.getString("id_pakaian"),
                    result.getString("tipe"),
                    result.getString("model"),
                    result.getString("harga"),
                    result.getString("stock"),});
            }
            pst.close();
        } catch (Exception e) {

        }
    }

    public final void totalharga() {
        try {
            koneksi = classKoneksi.getKoneksi();
            pst = koneksi.prepareStatement("SELECT SUM(harga * jumlah) AS total FROM Keranjang k INNER JOIN Pakaian p ON p.id_pakaian = k.id_pakaian WHERE k.id_user = ?");
            pst.setInt(1, User.getUser_id());
            result = pst.executeQuery();
            txttotalharga.setText(result.getString("total"));
            pst.close();
        } catch (Exception e) {
        }
    }

    public final void tableKeranjangUpdate() {
        try {
            koneksi = classKoneksi.getKoneksi();
            pst = koneksi.prepareStatement("SELECT k.id_keranjang, p.id_pakaian, p.tipe, p.model, p.harga, k.jumlah FROM Keranjang k JOIN Pakaian p ON p.id_pakaian = k.id_pakaian WHERE id_user = ?");
            pst.setInt(1, User.getUser_id());
            result = pst.executeQuery();
            DefaultTableModel dtm = (DefaultTableModel) tabelKeranjang.getModel();
            dtm.setRowCount(0);
            while (result.next()) {
                dtm.addRow(new Object[]{
                    result.getInt("id_keranjang"),
                    result.getInt("id_pakaian"),
                    result.getString("tipe"),
                    result.getString("model"),
                    result.getInt("harga"),
                    result.getInt("jumlah"),});
            }
            pst.close();
        } catch (Exception e) {

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelPakaian = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtjumlahstok = new javax.swing.JTextField();
        btnkeranjang = new javax.swing.JButton();
        btnhome = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelKeranjang = new javax.swing.JTable();
        btnhapus = new javax.swing.JButton();
        btnbayar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txttotalharga = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BELI PAKAIAN");

        jPanel1.setBackground(new java.awt.Color(236, 199, 112));

        jLabel1.setFont(new java.awt.Font("DFPOP1-W9", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PAKAIAN YANG TERSEDIA");

        tabelPakaian.setAutoCreateRowSorter(true);
        tabelPakaian.setBackground(new java.awt.Color(241, 250, 142));
        tabelPakaian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id_pakaian", "tipe", "model", "harga", "stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelPakaian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPakaianMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelPakaian);

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PILIH BARANG YANG INGIN ANDA BELI");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("MASUKKAN JUMLAH STOK YANG DIBELI");

        txtjumlahstok.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtjumlahstok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjumlahstokActionPerformed(evt);
            }
        });

        btnkeranjang.setBackground(new java.awt.Color(255, 255, 255));
        btnkeranjang.setFont(new java.awt.Font("DFPOP1-W9", 0, 14)); // NOI18N
        btnkeranjang.setForeground(new java.awt.Color(0, 0, 0));
        btnkeranjang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/shopping-chart_1.png"))); // NOI18N
        btnkeranjang.setText("TAMBAH KERANJANG");
        btnkeranjang.setEnabled(false);
        btnkeranjang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnkeranjangMouseClicked(evt);
            }
        });
        btnkeranjang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkeranjangActionPerformed(evt);
            }
        });

        btnhome.setBackground(new java.awt.Color(255, 255, 255));
        btnhome.setFont(new java.awt.Font("DFPOP1-W9", 0, 14)); // NOI18N
        btnhome.setForeground(new java.awt.Color(0, 0, 0));
        btnhome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/home.png"))); // NOI18N
        btnhome.setText("HOME");
        btnhome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhomeActionPerformed(evt);
            }
        });

        tabelKeranjang.setBackground(new java.awt.Color(241, 250, 142));
        tabelKeranjang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id_keranjang", "id_pakaian", "tipe", "model", "harga", "stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelKeranjang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelKeranjangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelKeranjang);
        if (tabelKeranjang.getColumnModel().getColumnCount() > 0) {
            tabelKeranjang.getColumnModel().getColumn(0).setMinWidth(0);
            tabelKeranjang.getColumnModel().getColumn(0).setPreferredWidth(0);
            tabelKeranjang.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        btnhapus.setBackground(new java.awt.Color(255, 255, 255));
        btnhapus.setFont(new java.awt.Font("DFPOP1-W9", 0, 14)); // NOI18N
        btnhapus.setForeground(new java.awt.Color(0, 0, 0));
        btnhapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/bin_1.png"))); // NOI18N
        btnhapus.setText("HAPUS");
        btnhapus.setEnabled(false);
        btnhapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhapusMouseClicked(evt);
            }
        });
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        btnbayar.setBackground(new java.awt.Color(255, 255, 255));
        btnbayar.setFont(new java.awt.Font("DFPOP1-W9", 0, 14)); // NOI18N
        btnbayar.setForeground(new java.awt.Color(0, 0, 0));
        btnbayar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/credit-card.png"))); // NOI18N
        btnbayar.setText("BAYAR");
        btnbayar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnbayarMouseClicked(evt);
            }
        });
        btnbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbayarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("DFPOP1-W9", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("PAKAIAN YANG TERSEDIA");

        jLabel5.setFont(new java.awt.Font("DFPOP1-W9", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("KERANJANG");

        txttotalharga.setEditable(false);
        txttotalharga.setBackground(new java.awt.Color(204, 204, 204));
        txttotalharga.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("TOTAL HARGA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnkeranjang)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtjumlahstok, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(btnhome, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(190, 190, 190)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txttotalharga, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnbayar)
                                    .addComponent(btnhapus))
                                .addGap(30, 30, 30))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtjumlahstok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttotalharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnhapus)
                    .addComponent(btnkeranjang))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnbayar)
                    .addComponent(btnhome))
                .addGap(280, 280, 280))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 627, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnhomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhomeActionPerformed
        Home framehome = new Home();
        framehome.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnhomeActionPerformed

    private void btnkeranjangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnkeranjangMouseClicked

    }//GEN-LAST:event_btnkeranjangMouseClicked

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btnbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnbayarActionPerformed

    private void btnkeranjangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkeranjangActionPerformed
        Keranjang();
    }//GEN-LAST:event_btnkeranjangActionPerformed

    private void tabelPakaianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPakaianMouseClicked
        indeksTerpilih = tabelPakaian.getSelectedRow();
        if (indeksTerpilih >= 0) {
            btnkeranjang.setEnabled(true);
        }
    }//GEN-LAST:event_tabelPakaianMouseClicked

    private void tabelKeranjangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelKeranjangMouseClicked
        indeksTerpilih = tabelKeranjang.getSelectedRow();
        if (indeksTerpilih >= 0) {
            btnhapus.setEnabled(true);
        }
    }//GEN-LAST:event_tabelKeranjangMouseClicked

    private void btnhapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapusMouseClicked
        int dialog = JOptionPane.showConfirmDialog(null, "Yakin Ingin Menghapus?");
        if (dialog != 0) {
            return;
        }
        int jumlahstok;
        try {
            DefaultTableModel dtm = (DefaultTableModel) tabelKeranjang.getModel();
            indeksTerpilih = tabelKeranjang.getSelectedRow();
            int idTerpilih = Integer.parseInt(dtm.getValueAt(indeksTerpilih, 0).toString());
            koneksi = classKoneksi.getKoneksi();
            pst = koneksi.prepareStatement("SELECT jumlah,id_pakaian from Keranjang WHERE id_keranjang = ?");
            pst.setInt(1, idTerpilih);
            result = pst.executeQuery();
            result.next();
            jumlahstok = result.getInt("jumlah");
            int idpakaian = result.getInt("id_pakaian");
            pst.close();
            pst = koneksi.prepareStatement("UPDATE Pakaian SET stock = stock + ? WHERE id_pakaian = ?");
            pst.setInt(1, jumlahstok);
            pst.setInt(2, idpakaian);
            pst.executeUpdate();
            pst.close();
            pst = koneksi.prepareStatement("DELETE from Keranjang WHERE id_keranjang = ?");
            pst.setInt(1, idTerpilih);
            pst.executeUpdate();
            pst.close();
            tablePakaianUpdate();
            tableKeranjangUpdate();
            totalharga();
            btnhapus.setEnabled(false);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnhapusMouseClicked

    private void btnbayarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbayarMouseClicked
        DefaultTableModel dtm = (DefaultTableModel) tabelKeranjang.getModel();
        if (dtm.getRowCount() <= 0) {
            JOptionPane.showMessageDialog(null, "Keranjang Kosong!");
            return;
        }
        
        int dialog = JOptionPane.showConfirmDialog(null, "Lanjutkan Pembayaran?");
        if (dialog != 0) {
            return;
        }

        try {
            pst = koneksi.prepareStatement("DELETE from Keranjang WHERE id_user = ?");
            pst.setInt(1, User.getUser_id());
            pst.executeUpdate();
            pst.close();
            tablePakaianUpdate();
            tableKeranjangUpdate();
            totalharga();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        JOptionPane.showMessageDialog(null, "Berhasil Dibeli!");

    }//GEN-LAST:event_btnbayarMouseClicked

    private void txtjumlahstokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjumlahstokActionPerformed
        Keranjang();
    }//GEN-LAST:event_txtjumlahstokActionPerformed

    /**
     * @param args the command line arguments
     */
    private void Keranjang() {
        int jumlahStok;
        if (txtjumlahstok.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Inputan Tidak Boleh Kosong!");
            return;
        }
        try {
            jumlahStok = Integer.parseInt(txtjumlahstok.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Inputan Tidak Boleh Huruf!");
            return;
        }
        try {
            DefaultTableModel dtm = (DefaultTableModel) tabelPakaian.getModel();
            indeksTerpilih = tabelPakaian.getSelectedRow();
            int idTerpilih = Integer.parseInt(dtm.getValueAt(indeksTerpilih, 0).toString());
            int stokTerpilih = Integer.parseInt(dtm.getValueAt(indeksTerpilih, 4).toString());

            if (jumlahStok > stokTerpilih) {
                JOptionPane.showMessageDialog(null, "Stok Yang Anda Inginkan Kurang");
                return;
            } else if (jumlahStok <= 0) {
                JOptionPane.showMessageDialog(null, "Tidak Dapat Menambahkan Stok (-)");
                return;
            }

            koneksi = classKoneksi.getKoneksi();
            pst = koneksi.prepareStatement("UPDATE Pakaian SET stock = stock - ? WHERE id_pakaian = ?");
            pst.setInt(1, jumlahStok);
            pst.setInt(2, idTerpilih);
            pst.executeUpdate();
            pst.close();

            koneksi = classKoneksi.getKoneksi();
            pst = koneksi.prepareStatement("SELECT COUNT(*) AS total FROM Keranjang WHERE id_user = ? AND id_pakaian = ?");
            pst.setInt(1, User.getUser_id());
            pst.setInt(2, idTerpilih);
            result = pst.executeQuery();
            result.next();
            int adaDiKeranjang = result.getInt("total");
            pst.close();

            if (adaDiKeranjang > 0) {
                pst = koneksi.prepareStatement("UPDATE Keranjang SET jumlah = jumlah + ? WHERE id_user = ? AND id_pakaian = ?");
                pst.setInt(1, jumlahStok);
                pst.setInt(2, User.getUser_id());
                pst.setInt(3, idTerpilih);
                pst.executeUpdate();
                pst.close();
            } else {
                pst = koneksi.prepareStatement("INSERT INTO Keranjang VALUES (?, ?, ?, ?)");
                pst.setInt(1, idSekarang);
                pst.setInt(2, User.getUser_id());
                pst.setInt(3, idTerpilih);
                pst.setInt(4, jumlahStok);
                pst.executeUpdate();
                pst.close();
            }

            tablePakaianUpdate();
            tableKeranjangUpdate();
            totalharga();
            btnkeranjang.setEnabled(false);
            idSekarang++;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userpage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbayar;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnhome;
    private javax.swing.JButton btnkeranjang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelKeranjang;
    private javax.swing.JTable tabelPakaian;
    private javax.swing.JTextField txtjumlahstok;
    private javax.swing.JTextField txttotalharga;
    // End of variables declaration//GEN-END:variables
}
