/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codingan;

/**
 *
 * @author nizar
 */
public class User {
    private static int user_id = 2;
    private static String username;
    private static String password;
    private static String nama;
    
   public static int getUser_id() {
        return user_id;
    }

    public static void setUser_id(int new_user_id) {
        user_id = new_user_id;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String new_username) {
        username = new_username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String new_password) {
        password = new_password;
    }

    public static String getNama() {
        return nama;
    }

    public static void setNama(String new_nama) {
        nama = new_nama;
    }
    
    
    
}
