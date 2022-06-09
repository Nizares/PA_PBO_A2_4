/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codingan;

/**
 *
 * @author nizar
 */
public class Keranjang {
    private int id_keranjang,id_pakaian,jumlah,user_id;

    public Keranjang(int id_keranjang, int id_pakaian, int jumlah, int user_id) {
        this.id_keranjang = id_keranjang;
        this.id_pakaian = id_pakaian;
        this.jumlah = jumlah;
        this.user_id = user_id;
    }

    public int getId_keranjang() {
        return id_keranjang;
    }

    public void setId_keranjang(int id_keranjang) {
        this.id_keranjang = id_keranjang;
    }

    public int getId_pakaian() {
        return id_pakaian;
    }

    public void setId_pakaian(int id_pakaian) {
        this.id_pakaian = id_pakaian;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    
}
