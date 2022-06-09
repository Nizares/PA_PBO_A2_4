package codingan;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class main {

    // intinya yg print di ganti GUI
    static InputStreamReader log = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(log);

    public static void main(String[] args) throws IOException {
        ///TIDAK DIPAKAI KARENA MENGGUNAKAN GUI
        admin Admin1 = new admin();
        buyer Pembeli = new buyer();
        System.out.println("HALO PENGGUNA");
        System.out.println("ANDA ADMIN atau PELANGGAN");
        // baru dibawah ini buat tombol yang menuju menu admin / user inisialnya
        System.out.print("Masukan Pilihan : ");
        String pilihan = input.readLine();
        if("Admin".equals(pilihan)){
            // ke menu login admin
            Admin1.LoginAdmin();
        }else if ("Pembeli".equals(pilihan)){
            // ke menu login buyer / user
            Pembeli.LoginBuyer();
        }

        
        }
    }
    
