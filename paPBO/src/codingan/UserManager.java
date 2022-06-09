/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package codingan;

import java.io.IOException;

/**
 *
 * @author nizar
 */
public interface UserManager {
    public void menu() throws IOException;
    public void tambah() throws IOException;
    public void edit() throws IOException;
    public void hapus() throws IOException;
}
