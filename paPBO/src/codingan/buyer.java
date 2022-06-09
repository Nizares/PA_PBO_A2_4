package codingan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class buyer implements UserBasic {
    ///TIDAK DIPAKAI KARENA MENGGUNAKAN GUI
    private Koneksi koneksi;
    private ArrayList<User> dataUser;
    private ArrayList<DetailKeranjang> dataDetailKeranjang;
    private ArrayList<Pakaian> dataPakaian;
    private ArrayList<Keranjang> dataKeranjang;
    private String username1;
    private int id_pakaian;
    private int id_user1;
    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(isr);

    public buyer() {
        koneksi = new Koneksi();
        dataUser = new ArrayList<>();
        dataPakaian = new ArrayList<>();
        dataKeranjang = new ArrayList<>();
        dataDetailKeranjang = new ArrayList<>();
        koneksi.getDataUser(dataUser);
        koneksi.getDataDetailKeranjang(dataDetailKeranjang);
        koneksi.getDataKeranjang(dataKeranjang);
        koneksi.getDataPakaian(dataPakaian);
    }

    public void LoginBuyer() throws IOException {

        System.out.println("+-----------------------------------------------+");
        System.out.println("|             ===== Login Buyer =====           |");
        System.out.println("+-----------------------------------------------+");
        System.out.println("|   [1] Login                                   |");
        System.out.println("|   [2] Register                                |");
        System.out.println("|   [3] Keluar                                  |");
        System.out.println("+-----------------------------------------------+");
        System.out.print("Masukkan pilihan :");
        int select = Integer.parseInt(input.readLine());
        while (true) {
            if (select == 1) {
                System.out.println("Masukkan Username :");
                username1 = input.readLine();
                System.out.println("Masukkan Password :");
                String password1 = input.readLine();
                for (User user : dataUser) {
                    if (user.getUsername().equals(username1) && user.getPassword().equals(password1)) {
                        menu();
                    }
                }
            } else if (select == 2) {
                // tombol gui dan form untuk inputan
                System.out.println("Masukan Nama :");
                String nama = input.readLine();
                System.out.println("Masukkan Username :");
                String username = input.readLine();
                for (User user : dataUser) {
                    if (user.getUsername().equals(username)) {
                        System.out.println("Username ini udah ada");
                        return;
                    }
                }
                System.out.println("Masukkan Password :");
                String password = input.readLine();
                int UserId = dataUser.get(dataUser.size() - 1).getUser_id();
//                User user = new User(UserId++, username, password, nama);
//                dataUser.add(user);
//                koneksi.addDataUser(user);
                break;
            } else {
                System.out.println("Kembali.....");
                break;
            }
        }
    }

    @Override
    public void menu() throws IOException {
        System.out.println("+-----------------------------------------------+");
        System.out.println("|            ===== Menu Pelanggan =====         |");
        System.out.println("+-----------------------------------------------+");
        System.out.println("|   [1] Tambah Keranjang                        |");
        System.out.println("|   [2] Tampil Keranjang                        |");
        System.out.println("|   [3] Hapus keranjang                         |");
        System.out.println("|   [4] Keluar                                  |");
        System.out.println("+-----------------------------------------------+");
        System.out.println("Masukan Pilihan : ");
        int select = Integer.parseInt(input.readLine());
        while (true){
            if (select == 1){
                tambah();
            }else if (select == 2){
                tampilKeranjang();
            }else if (select == 3){
                hapus();
            }else if (select == 4){
                System.out.println("Berhasil Keluar ");
                break;
            }else{

            }
        }
    }

    @Override
    public void tambah() throws IOException {
        System.out.println("ID" + "\t" + "TIPE" + "\t" + "MODEL" + "\t\t" + "HARGA" + "\t" + "STOCK");
        for (Pakaian pakaian : dataPakaian) {
            koneksi.getLihatDataPakaian(dataPakaian);
        }

        System.out.println("Masukan Model Pakaian : ");
        String inputa = input.readLine();
        for (Pakaian pakaian : dataPakaian) {
            if (pakaian.getModel().equals(inputa)) {
                id_pakaian = pakaian.getId_pakaian();
            }
        }
        System.out.println("Masukan Jumlah Pakaian : ");
        int select1 = Integer.parseInt(input.readLine());
        System.out.println("ID User : ");
        for (User user : dataUser) {
            if (user.getUsername().equals(username1)) {
                id_user1 = user.getUser_id();
                System.out.println(user.getUser_id());
            }
        }
        int KeranjangId = dataKeranjang.get(dataKeranjang.size() - 1).getId_keranjang();
        Keranjang keranjang = new Keranjang(KeranjangId++,id_pakaian,select1,id_user1);

    }

    @Override
    public void hapus() throws IOException {
        System.out.println("BELOM SELESAI");
    }

    @Override
    public void tampilKeranjang() throws IOException {
        for (DetailKeranjang detailKeranjang : dataDetailKeranjang) {
//            koneksi.getLihatDataDetailKeranjang(dataDetailKeranjang);
        }
    }
}
