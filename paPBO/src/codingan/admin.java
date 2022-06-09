package codingan;

import java.io.IOException;
import java.util.ArrayList;
import static codingan.main.input;

public class admin implements UserManager {
    ///TIDAK DIPAKAI KARENA MENGGUNAKAN GUI
    private ArrayList<Pakaian> dataPakaian;
    private Koneksi koneksi;
    private int idterakhir = 1;
    public admin(){
        koneksi = new Koneksi();
        dataPakaian = new ArrayList<Pakaian>();
        koneksi.getDataPakaian(dataPakaian);
    }

    public void LoginAdmin() throws IOException {
        admin Admin1 = new admin();
        String UsernameAdmin = "Admin";
        String PasswordAdmin = "mamahtausendiri";
        System.out.println("+-----------------------------------------------+");
        System.out.println("|            ===== Login Admin =====            |");
        System.out.println("+-----------------------------------------------+");
        System.out.println("|   [1] Masuk                                   |");
        System.out.println("|   [2] Kembali                                 |");
        System.out.println("+-----------------------------------------------+");
        System.out.print("Masukan Pilihan : ");
        int select = Integer.valueOf(input.readLine());
        while (true) {
            if (select == 1) {
                System.out.println("Masukkan Username :");
                String username = input.readLine();
                System.out.println("Masukkan Password :");
                String password = input.readLine();
                if (UsernameAdmin.equals(username) && PasswordAdmin.equals(password)) {
                    Admin1.menu();
                    break;
                }
            } else {
                System.out.println("Kembali.....");
                break;
            }
        }
    }

    @Override
    public void menu() throws IOException {
        System.out.println("+-----------------------------------------------+");
        System.out.println("|           ===   ===== MENU =====   ===        |");
        System.out.println("+-----------------------------------------------+");
        System.out.println("|   [1] Tambah Pakaian                          |");
        System.out.println("|   [2] Update Pakaian                          |");
        System.out.println("|   [3] Hapus Pakaian                           |");
        System.out.println("+-----------------------------------------------+");
        String pilihan = input.readLine();
        switch (pilihan) {
            case "1":
                tambah();
                break;
            case "2":
                edit();
                break;
            case "3":
                hapus();
                break;
            default:
                break;
        }
    }

    @Override
    public void tambah() throws IOException {
        dataPakaian = new ArrayList<>();
        ArrayList<Atasan> dataAtasan;
        dataAtasan = new ArrayList<>();
        ArrayList<Bawahan> dataBawahan;
        dataBawahan = new ArrayList<>();
        
        System.out.println("+-----------------------------------------------+");
        System.out.println("|           ===   ===== MENU =====   ===        |");
        System.out.println("+-----------------------------------------------+");
        System.out.println("|   [1] Tambah Atasan                           |");
        System.out.println("|   [2] Tambah Bawahan                          |");
        System.out.println("+-----------------------------------------------+");
        String pilihan = input.readLine();
        switch (pilihan) {
            case "1" -> {
                String tipea = Atasan.tipeb;
                System.out.println("Masukan Model :");
                String model = input.readLine();
                for (Pakaian pakaian : dataPakaian) {
                    if (pakaian.getModel().equals(model)) {
                        System.out.println("Model ini sudah ada");
                        return;
                    }
                }
                System.out.println("Masukkan harga :");
                int harga = Integer.parseInt(input.readLine());
                System.out.println("Masukkan stock :");
                int stock = Integer.parseInt(input.readLine());
                int PakaianId = dataPakaian.get(dataPakaian.size() - 1).getId_pakaian();
                Atasan atasan = new Atasan(PakaianId++, tipea, model, harga, stock);
                dataAtasan.add(atasan);
                koneksi.addDataAtasan(atasan);
                System.out.println("ATASAN BERHASIL DITAMBAHKAN");
            }
            case "2" -> {
                String tipeb = Bawahan.tipea;
                System.out.println("Masukan Model :");
                String model = input.readLine();
                for (Pakaian pakaian : dataPakaian) {
                    if (pakaian.getModel().equals(model)) {
                        System.out.println("Model ini sudah ada");
                        return;
                    }
                }
                System.out.println("Masukkan harga :");
                int harga = Integer.parseInt(input.readLine());
                System.out.println("Masukkan stock :");
                int stock = Integer.parseInt(input.readLine());
                int PakaianId = dataPakaian.get(dataPakaian.size() - 1).getId_pakaian();
                Bawahan bawahan = new Bawahan(PakaianId++, tipeb, model, harga, stock);
                dataBawahan.add(bawahan);
                koneksi.addDataBawahan(bawahan);
                System.out.println("BAWAHAN BERHASIL DITAMBAHKAN");
            }
            default -> {
            }
        }
    }

    @Override
    public void edit() throws IOException {
        try {
            System.out.print("INPUT ID");
            String input1 = input.readLine();
            for (int i = 0; i <= dataPakaian.size(); i -= -1) {
                System.out.println(dataPakaian.get(i).getId_pakaian());
                if (dataPakaian.get(i).getId_pakaian() == Integer.parseInt(input1)) {
                    // ! Update kedalam ArrayList
                    System.out.println("Masukkan tipe :");
                    String tipe1 = input.readLine();
                    dataPakaian.get(i).setTipe(tipe1);
                    System.out.println("Masukkan model :");
                    String model1 = input.readLine();
                    dataPakaian.get(i).setModel(model1);
                    System.out.println("Masukkan harga :");
                    int harga1 = Integer.parseInt(input.readLine());
                    dataPakaian.get(i).setHarga(harga1);
                    System.out.println("Masukkan stock :");
                    int stock1 = Integer.parseInt(input.readLine());
                    dataPakaian.get(i).setStock(stock1);
//                    // ! Update kedalam JTable
//                    tblModel.setValueAt(dataItem.get(i).getPrice(), i, 2);
//                    tblModel.setValueAt(dataItem.get(i).getAmount(), i, 3);
                    // ! Update kedalam database
                    koneksi.updateDataPakaian(dataPakaian.get(i));
                    System.out.println("Update Berhasil");
                    return;
                }
            }
            System.out.println("ERROR 2");
        } catch (NumberFormatException e) {
            System.out.println("ERROR" + 0);
        } catch (NullPointerException e) { // ! jika menekan button cancel
            return;
        }
    }

    @Override
    public void hapus() throws IOException {
        try {
            System.out.print("INPUT ID");
            String input1 = input.readLine();
            for (int i = 0; i <= dataPakaian.size(); i -= -1) {
                if (dataPakaian.get(i).getId_pakaian() == Integer.parseInt(input1)) {
                    // ! Jika data yang dihapus adalah data terakhir
                    if (i == dataPakaian.size() - 1) {
                        this.idterakhir = dataPakaian.get(i).getId_pakaian();
                        // ! Delete kedalam ArrayList
                        dataPakaian.remove(i);
//                        // ! Delete kedalam JTable
//                        tblModel.removeRow(i);
                        // ! Delete kedalam Database
                        koneksi.deleteDataPakaian(dataPakaian.get(i).getId_pakaian());
                    } else {
                        // ! Delete kedalam ArrayList
                        dataPakaian.remove(i);
//                        // ! Delete kedalam JTable
//                        tblModel.removeRow(i);
                        // ! Delete kedalam Database
                        koneksi.deleteDataPakaian(dataPakaian.get(i).getId_pakaian());
                        this.idterakhir = dataPakaian.get(dataPakaian.size() - 1).getId_pakaian();
                    }
                    System.out.println("Berhasil dihapus" + 0);
                    break;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("INPUT ERROR" + 1);
        } catch (NullPointerException e) { // ! jika menekan button cancel
            return;
        }
    }

}
