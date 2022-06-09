/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codingan;

/**
 *
 * @author nizar
 */
public class Atasan extends AbstractPakaian{
    public static final String tipeb = "Atasan";
    private String tipe;
    
    protected Atasan(int Id_pakaian, String tipe,String model, int jumlah, int stock){
        super(Id_pakaian, model,jumlah,stock);
        this.tipe = tipeb;
    }
    
    protected void setTipe(String tipe){
        this.tipe = tipeb;
    }
    protected String getTipe(){
        return tipe;
    }
    
    protected void buat(int jb){
        System.out.println("| membuat " + jb + " baju...");
    }
    
    @Override
    void selesai(){
        System.out.println("| Selesai membuat baju...");
    }
}
