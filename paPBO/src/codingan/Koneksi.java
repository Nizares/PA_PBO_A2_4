/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codingan;

/**
 *
 * @author nizar
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.io.File;

public class Koneksi {
    private final String url = "jdbc:sqlite:TokoBaju.db";
    private PreparedStatement pst;
    private Connection koneksi;
    private ResultSet result;
    private Statement stm;
    private String sql;

    public boolean isDatabaseExists(String dbFilePath) {
        File database = new File(dbFilePath);
        return database.exists();
    }

    public Connection getKoneksi() { // ! menghubungkan ke database
        String getFilePath = new File("").getAbsolutePath();
        String fileAbsolutePath = getFilePath.concat("\\TokoBaju.db");
        if (isDatabaseExists(fileAbsolutePath)) {
            try {
                this.koneksi = DriverManager.getConnection(url);
            } catch (SQLException ex) {
                Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("ERROR" + ex);
            }
        }
        return koneksi;
    }
    /// untuk login user
    public ArrayList<User> getDataUser(ArrayList<User> user) {
        try {
            sql = "SELECT * FROM User";
            Connection cn = getKoneksi();
            stm = cn.createStatement();
            result = stm.executeQuery(sql);
            while (result.next()) {
//                user.add(new User(result.getInt(1), result.getString(2), result.getString(3), result.getString(4)));
//                System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getString(3) + "\t" + result.getString(4));
            }
        } catch (SQLException ex) {
            System.out.println("Error : " + ex);
        } finally {
            try {
                result.close();
                stm.close();
            } catch (SQLException ex) {
                System.out.println("Error : " + ex);
            }
        }
        return user;
    }
    
    public void addDataUser(User user) {
        try {
            sql = "INSERT INTO User (username,password,nama) VALUES ('%s','%s','%s')";
            sql = String.format(sql,
                    user.getUsername(), user.getPassword(), user.getNama());
            Connection cn = getKoneksi();
            pst = cn.prepareStatement(sql);
            pst.execute();
            pst.close();
        } catch (SQLException ex) {
            System.out.println("ERROR" + ex);;
        }
    }
    /// untuk pakaian
    public ArrayList<Pakaian> getDataPakaian(ArrayList<Pakaian> pakaian) {
        try {
            sql = "SELECT * FROM Pakaian";
            Connection cn = getKoneksi();
            stm = cn.createStatement();
            result = stm.executeQuery(sql);
            while (result.next()) {
                pakaian.add(new Pakaian(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4), result.getInt(5)));
//                System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getString(3) + "\t" + result.getString(4));
            }
        } catch (SQLException ex) {
            System.out.println("Error : " + ex);
        } finally {
            try {
                result.close();
                stm.close();
            } catch (SQLException ex) {
                System.out.println("Error : " + ex);
            }
        }
        return pakaian;
    }
    
    
    public void addDataAtasan(Atasan atasan) {
        try {
            sql = "INSERT INTO Pakaian (tipe,model,harga,stock) VALUES ('%s','%s','%s','%s')";
            sql = String.format(sql,
                    atasan.getTipe(), atasan.getModel(), atasan.getHarga(), atasan.getStock());
            Connection cn = getKoneksi();
            pst = cn.prepareStatement(sql);
            pst.execute();
            pst.close();
        } catch (SQLException ex) {
            System.out.println("ERROR" + ex);
        }
    }
    public void addDataBawahan(Bawahan bawahan) {
        try {
            sql = "INSERT INTO Pakaian (tipe,model,harga,stock) VALUES ('%s','%s','%s','%s')";
            sql = String.format(sql,
                    bawahan.getTipe(), bawahan.getModel(), bawahan.getHarga(), bawahan.getStock());
            Connection cn = getKoneksi();
            pst = cn.prepareStatement(sql);
            pst.execute();
            pst.close();
        } catch (SQLException ex) {
            System.out.println("ERROR" + ex);
        }
    }
    
    public void updateDataPakaian(Pakaian pakaian) {
        try {
            sql = "UPDATE Pakaian SET tipe=?,model=?,harga=?,stock=? WHERE id_pakaian=?";
            Connection cn = getKoneksi();
            pst = cn.prepareStatement(sql);
            pst.setString(1, pakaian.getTipe());
            pst.setString(2, pakaian.getModel());
            pst.setInt(3, pakaian.getHarga());
            pst.setInt(4, pakaian.getStock());
            pst.setInt(5, pakaian.getId_pakaian());
            pst.execute();
        } catch (SQLException ex) {
            System.out.println("ERROR" + ex);
        } finally {
            try {
                pst.close();
            } catch (SQLException ex) {
                System.out.println("ERROR" + ex);
            }
        }
    }
    public void deleteDataPakaian(int id) {
        try {
            String sql = "DELETE FROM Pakaian WHERE id_pakaian=?";
            Connection cn = getKoneksi();
            pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
        } catch (SQLException ex) {
            System.out.println("ERROR"+ ex);
        }
    }
/// bagian keranjang 
    public ArrayList<DetailKeranjang> getDataDetailKeranjang(ArrayList<DetailKeranjang> detailKeranjang) {
        try {
            sql = "SELECT id_keranjang,Pakaian.tipe,Pakaian.model,Pakaian.harga,jumlah,User.nama FROM Keranjang INNER JOIN Pakaian ON Pakaian.id_pakaian = Keranjang.id_pakaian INNER JOIN User ON User.user_id = Keranjang.id_user";
            Connection cn = getKoneksi();
            stm = cn.createStatement();
            result = stm.executeQuery(sql);
            while (result.next()) {
                detailKeranjang.add(new DetailKeranjang(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4), result.getInt(5), result.getString(6)));
            }
        } catch (SQLException ex) {
            System.out.println("Error : " + ex);
        } finally {
            try {
                result.close();
                stm.close();
            } catch (SQLException ex) {
                System.out.println("Error : " + ex);
            }
        }
        return detailKeranjang;
    }

    public ArrayList<Keranjang> getDataKeranjang(ArrayList<Keranjang> keranjang) {
        try {
            sql = "SELECT * FROM Keranjang";
            Connection cn = getKoneksi();
            stm = cn.createStatement();
            result = stm.executeQuery(sql);
            while (result.next()) {
                keranjang.add(new Keranjang(result.getInt(1), result.getInt(2), result.getInt(3), result.getInt(4)));
//                System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getString(3) + "\t" + result.getString(4));
            }
        } catch (SQLException ex) {
            System.out.println("Error : " + ex);
        } finally {
            try {
                result.close();
                stm.close();
            } catch (SQLException ex) {
                System.out.println("Error : " + ex);
            }
        }
        return keranjang;
    }

    public void addDataKeranjang(Keranjang keranjang) {
        try {
            sql = "INSERT INTO User (id_pakaian,jumlah,id_user) VALUES ('%s','%s','%s')";
            sql = String.format(sql,
                    keranjang.getId_pakaian(), keranjang.getJumlah(), keranjang.getUser_id());
            Connection cn = getKoneksi();
            pst = cn.prepareStatement(sql);
            pst.execute();
            pst.close();
        } catch (SQLException ex) {
            System.out.println("ERROR" + ex);
        }
    }
    public ArrayList<Pakaian> getLihatDataPakaian(ArrayList<Pakaian> pakaian) {
        try {
            sql = "SELECT * FROM Pakaian";
            Connection cn = getKoneksi();
            stm = cn.createStatement();
            result = stm.executeQuery(sql);
            while (result.next()) {
                pakaian.add(new Pakaian(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4), result.getInt(5)));
                System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getString(3) + "\t" + result.getInt(4) + "\t" + result.getInt(5));
            }
        } catch (SQLException ex) {
            System.out.println("Error : " + ex);
        } finally {
            try {
                result.close();
                stm.close();
            } catch (SQLException ex) {
                System.out.println("Error : " + ex);
            }
        }
        return pakaian;
    }
}
