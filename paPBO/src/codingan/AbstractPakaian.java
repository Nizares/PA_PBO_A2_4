/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codingan;

/**
 *
 * @author nizar
 */
public abstract class AbstractPakaian {
    protected String model;
    protected int harga, id_pakaian,stock;
    
    protected AbstractPakaian(int id_pakaian, String model, int harga, int stock){
        this.id_pakaian = id_pakaian;
        this.model = model;
        this.harga = harga;
        this.stock = stock;
    }

    public String getModel() {
        return model;
    }

    public int getHarga() {
        return harga;
    }

    public int getId_pakaian() {
        return id_pakaian;
    }

    public int getStock() {
        return stock;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void setId_pakaian(int id_pakaian) {
        this.id_pakaian = id_pakaian;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    abstract void selesai();
}