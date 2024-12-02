import java.util.Scanner;
public class KelompokJobsheet13 {
    static String[][] daftarPrestasi = new String[100][5]; 
    static int jumlahData = 0; 
    static Scanner scanner = new Scanner(System.in);
   
    public static void tambahPrestasi() { //DIKERJAKAN KA ABI MUHAMMAD R.F.
        String tingkat; 
        if (jumlahData >= 100) {
            System.out.println("Data penuh! Tidak dapat menambah data lagi.");
            return;
        }

        System.out.println("=== TAMBAH DATA PRESTASI ===");
        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        System.out.print("NIM: ");
        String nim = scanner.nextLine();
        System.out.print("Masukkan Jenis Prestasi: ");
        String jenis = scanner.nextLine();
        
        while (true) {
            System.out.print("Tingkat (Lokal/Nasional/Internasional): ");
            tingkat = scanner.nextLine();
            if (!(tingkat.equalsIgnoreCase("Lokal") || tingkat.equalsIgnoreCase("Nasional") || tingkat.equalsIgnoreCase("Internasional"))) {
                System.out.println("Tingkat tidak valid");
                continue;  
            }
            break;
        }
        
        int tahun;
        while (true) {
            System.out.print("Tahun: ");
            tahun = scanner.nextInt(); 
            if (tahun < 2010) {
            System.out.println("Tahun tidak valid. Tahun harus >= 2010 Coba lagi.");
        } else {
            break;
        }
    }

        daftarPrestasi[jumlahData][0] = nama;
        daftarPrestasi[jumlahData][1] = nim;
        daftarPrestasi[jumlahData][2] = jenis;
        daftarPrestasi[jumlahData][3] = tingkat;
        daftarPrestasi[jumlahData][4] = Integer.toString (tahun);
        jumlahData++;

        System.out.println("Data berhasil ditambahkan!");
    
    }
    
    public static void tampilkanSemuaPrestasi() { //DIKERJAKAN VANESA MARDIANA PUTRI
        System.out.println("=== DAFTAR SEMUA PRESTASI ===");
        if (jumlahData==0) {
            System.out.println("Belum ada data prestasi");
        } else {
            for (int i = 0; i < jumlahData; i++) {
                for (int j = 0; j < daftarPrestasi[i].length; j++) {
                    if (j == 0) System.out.print("Nama: " + daftarPrestasi[i][j] + " | ");
                    else if (j == 1) System.out.print("NIM: " + daftarPrestasi[i][j] + " | ");
                    else if (j == 2) System.out.print("Jenis: " + daftarPrestasi[i][j] + " | ");
                    else if (j == 3) System.out.print("Tingkat: " + daftarPrestasi[i][j] + " | ");
                    else if (j == 4) System.out.print("Tahun: " + daftarPrestasi[i][j]);
                }
                System.out.println();
            }
        }
    }

    public static void analisisPrestasi() { //DIKERJAKAN WAHYUDI SATRIAWAN HAMID
        System.out.println("=== ANALISIS PRESTASI BERDASARKAN JENIS DAN TAHUN ===");
        if (jumlahData == 0) {
            System.out.println("Belum ada data prestasi.");
            return;
        }

        System.out.print("Masukkan jenis prestasi untuk analisis: ");
        String jenisDicari = scanner.nextLine();
        System.out.print("Masukkan tahun prestasi untuk analisis: ");
        String tahunDicari = scanner.nextLine();
        System.out.println("=========================== ANALISIS PRESTASI ===========================");

        for (int i = 0; i < jumlahData; i++) {
            if (daftarPrestasi[i][2].equalsIgnoreCase(jenisDicari)) {
                if (daftarPrestasi[i][4].equalsIgnoreCase(tahunDicari)) {
                    System.out.println("Nama: " + daftarPrestasi[i][0] + " | NIM: " + daftarPrestasi[i][1] + " | Jenis: " + daftarPrestasi[i][2] + " | Tingkat: " + daftarPrestasi[i][3] + " | Tahun: " + daftarPrestasi[i][4]);
                } else {
                    System.out.println("Tidak ada data prestasi dengan tahun tersebut");
                }
            } else {
                System.out.println("Tidak ada data prestasi dengan jenis tersebut.");
            }
        }
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
                    analisisPrestasi();
                    break;
                case 4:
                    System.out.println("Berhasil keluar!");
                    break;
                default:
                System.out.println("Angka tidak valid, silakan coba lagi!");
            }
        } while (pilihan!=4);
    }
}
