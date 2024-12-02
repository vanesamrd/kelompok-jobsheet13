import java.util.Scanner;
public class KelompokJobsheet13 {
    static String[][] daftarPrestasi = new String[100][5]; 
    static int jumlahData = 0; 
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
       
    
    }
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
        int tahun = 0;

        while (true) {
            System.out.print("Tahun: ");
            
            try {
                tahun = Integer.parseInt(scanner.nextLine()); // Mencoba mengonversi input menjadi integer
                if (tahun < 2010) {
                    System.out.println("Tahun tidak valid. Tahun harus >= 2010. Coba lagi.");
                } else {
                    break; // Keluar dari loop jika tahun valid
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tahun tidak valid, harap masukkan angka.");
            }
        }

        daftarPrestasi[jumlahData][0] = nama;
        daftarPrestasi[jumlahData][1] = nim;
        daftarPrestasi[jumlahData][2] = jenis;
        daftarPrestasi[jumlahData][3] = tingkat;
        daftarPrestasi[jumlahData][4] = String.valueOf(tahun);
        jumlahData++;

        System.out.println("Data berhasil ditambahkan!");
    }
    
    public static void tampilkanSemuaPrestasi() {
        System.out.println("=== DAFTAR SEMUA PRESTASI ===");
        if (jumlahData==0) {
            System.out.println("Belum ada data prestasi");
        } else {
            for (int i = 0; i < jumlahData; i++) {
                System.out.println("Nama: " + daftarPrestasi[i][0] + " | NIM: " + daftarPrestasi[i][1] + " | Jenis: " + daftarPrestasi[i][2] + " | Tingkat: " + daftarPrestasi[i][3] +" | Tahun: " + daftarPrestasi[i][4]);
            }
        }
    }

    public static void analisisPrestasi() {
        System.out.println("=== ANALISIS PRESTASI BERDASARKAN JENIS ===");
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
}
