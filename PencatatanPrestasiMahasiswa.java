import java.util.Scanner;

public class PencatatanPrestasiMahasiswa {

   
    static String[][] daftarPrestasi = new String[100][5]; 
    static int jumlahData = 0; 
    static Scanner scanner = new Scanner(System.in);

 
    public static void tambahPrestasi() {
        if (jumlahData >= 100) {
            System.out.println("Data penuh! Tidak dapat menambah data lagi.");
            return;
        }

        System.out.println("=== TAMBAH DATA PRESTASI ===");
        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        System.out.print("NIM: ");
        String nim = scanner.nextLine();
        System.out.print("Jenis: ");
        String jenis = scanner.nextLine();
        System.out.print("Tingkat (Lokal/Nasional/Internasional): ");
        String tingkat = scanner.nextLine();
       

        while (true) {
            System.out.print("Tahun: ");
            String tahun = scanner.nextLine(); 
                if (tahun.equalsIgnoreCase ("2010", "2011", "2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023","2024")) {
                    System.out.println("Tahun tidak valid. Tahun harus >= 2010. Coba lagi.");
                } else {
                    break; // Keluar dari loop jika tahun valid
                }
           
        

        daftarPrestasi[jumlahData][0] = nama;
        daftarPrestasi[jumlahData][1] = nim;
        daftarPrestasi[jumlahData][2] = jenis;
        daftarPrestasi[jumlahData][3] = tingkat;
        daftarPrestasi[jumlahData][4] = tahun;
        jumlahData++;

        System.out.println("Data berhasil ditambahkan!");
    }

   
    public static void tampilkanSemuaPrestasi() {
        System.out.println("=== DAFTAR SEMUA PRESTASI ===");
        if (jumlahData == 0) {
            System.out.println("Belum ada data prestasi.");
        } else {
            for (int i = 0; i < jumlahData; i++) {
                System.out.println("Nama: " + daftarPrestasi[i][0] +
                                   " | NIM: " + daftarPrestasi[i][1] +
                                   " | Jenis: " + daftarPrestasi[i][2] +
                                   " | Tingkat: " + daftarPrestasi[i][3] +
                                   " | Tahun: " + daftarPrestasi[i][4]);
            }
        }
    }
    
    public static void analisisPrestasiBerdasarkanJenis() {
        System.out.println("=== ANALISIS PRESTASI BERDASARKAN JENIS ===");
        if (jumlahData == 0) {
            System.out.println("Belum ada data prestasi.");
            return;
        }

        System.out.print("Masukkan jenis prestasi untuk analisis (misalnya: Juara 1): ");
        String jenisDicari = scanner.nextLine();
        int jumlah = 0;

        
        for (int i = 0; i < jumlahData; i++) {
            if (daftarPrestasi[i][2].equalsIgnoreCase(jenisDicari)) {
                jumlah++;
            }
        }

        System.out.println("Jumlah mahasiswa dengan jenis prestasi '" + jenisDicari + "': " + jumlah);
    }

    
    public static void main(String[] args) {
        int pilihan;

        do {
            System.out.println("\n=== PENCAATAN PRESTASI MAHASISWA ===");
            System.out.println("1. Tambah Data Prestasi");
            System.out.println("2. Tampilkan Semua Prestasi");
            System.out.println("3. Analisis Prestasi Berdasarkan Jenis");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    tambahPrestasi();
                    break;
                case 2:
                    tampilkanSemuaPrestasi();
                    break;
                case 3:
                    analisisPrestasiBerdasarkanJenis();
                    break;
                case 4:
                    System.out.println("Keluar dari program...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        } while (pilihan != 4);

        
    }
}