package codingan;

public class Pakaian {
    protected String tipe, model;
    protected int harga, id_pakaian,stock;
    
    protected Pakaian(int id_pakaian, String tipe,String model, int harga, int stock){
        this.id_pakaian = id_pakaian;
        this.tipe = tipe;
        this.model = model;
        this.harga = harga;
        this.stock = stock;
    }

    public String getTipe() {
        return tipe;
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

    public void setTipe(String tipe) {
        this.tipe = tipe;
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
}