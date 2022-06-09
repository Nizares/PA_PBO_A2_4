# PA_PBO_A2_4
MENGGUNAKAN GUI, CODING BAGIAN PACKAGE CODINGAN BERGUNA UNTUK CONSTRUCTOR DAN KONEKSI KE SQLITE, karena GUI alangkah baiknya menggunakan penyimpanan dinamis(external)
supaya lebih mudah memanggil data karena multi user.
ALGORITMA CRUD SQLITE JAVA :
  1. Membuat codingan koneksi dari java ke SQL.
  2. mengambil data dengan cara query SQL.
  3. menampung data yang dipanggil pada ArrayList(class object) java.
  4. setelah itu dapat menambah/melihat/memperbarui/menghapus dengan cara OOP/PBO yaitu buat class dari objek tersebut lalu dibuat arraylist dan dipanggil.
  5. menampung data yang ditambah/diperbarui/dihapus menggunakan query sql.
  6. menyimpan datanya pada tabel databasenya.
karena menggunakan SQLITE ini seperti MySQL dapat memanggil data dengan query yang sama, kita buat 3 tabel untuk penampungan data yaitu : User,Pakaian,Keranjang
  User : berisi atribut id_user sebagai primarykey, username, password, dan nama
  Pakaian : berisi atribut id_pakaian sebagai primarykey, tipe pada tipe hanya 2 saja Atasan atau Bawahan, model, harga bertipe integer supaya dapat dihitung, 
    stock juga integer
  Keranjang : berisi atribut id_keranjang sebagai primarykey, id_user sebagai foreginkey atau penghubung pada tabel User, id_pakaian sebagai foreginkey pada tabel Pakaian,
  jumlah bertipe integer.
pada aplikasi ini berjudul Toko Kaos Tiara, diamana ada 2 user yaitu admin dan pelanggan
APA SAJA YANG BISA DILAKUKAN "ADMIN" :
  - Admin hanya ada 1 akun sehingga dibuat variabel saja untuk username dan passwordnya
  - Admin dapat melakukan managemen data / CRUD pada Pakaian, 
APA SAJA YANG BISA DILAKUKAN "USER" :
- User dapat membuat akun (REGISTRASI)
- User dapat login menggunakan username dan password yang telah dibuat pada registrasi
- User dapat managemen data (Create,Delete,Bayar) Keranjang user itu sendiri

Keterangan 
Query/klausa SQL :
  1. SELECT = melihat / mengambil (SELECT * FROM User)
  2. INSERT INTO = menambahkan (INSERT INTO (id_user,username,password,nama) FROM User VALUES (1,Nijares,readme12,Nijar)
  3. UPDATE = memperbarui (UPDATE User SET password = "isekai123" WHERE username = "Nijares")
  4. WHERE = merujuk atribut dimana query akan mengekseuksi 
  5. DELETE = menghapus (DELETE FROM USER WHERE username = "Nijares")
  6. AS = Permisalan untuk menampilkan nama atribut
  7. SUM = menambahkan yang atribut integer (SELECT SUM(harga*stock) AS TOTAL_HARGA from Pakaian)
  8. COUNT = menghitung jumlah data/record (SELECT COUNT(*) AS TOTAL_DATA from User)
  9. MAX = untuk mengambil nilai maksimum (SELECT MAX(id_keranjang) AS maks FROM Keranjang)
  10. JOIN = untuk memanggil atribut yang dari tabel yang bergabung(foreginkey) dengan tabel tersebut(primary) 
      (SELECT SUM(harga * jumlah) AS total FROM Keranjang k INNER JOIN Pakaian p ON p.id_pakaian = k.id_pakaian WHERE k.id_user = 1)
  11. INNER JOIN = memilih data yang nilainya cocok dengan kedua data tersebut.
