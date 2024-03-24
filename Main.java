
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<DataMahasiswa> daftarMahasiswa = new ArrayList<>();

    public static void main(String[] args) {
        Scanner hahaa = new Scanner(System.in);
        int pilihanMenu;
        boolean lanjutMenu = true;

        while (lanjutMenu) {
            while (true) {
                System.out.println("============ Program KHS ============");
                System.out.println("1. Input KHS");
                System.out.println("2. Cetak KHS");
                System.out.println("3. SELESAI");
                System.out.print("Pilihan: ");
                pilihanMenu = hahaa.nextInt();
                hahaa.nextLine();

                switch (pilihanMenu) {
                    case 1:

                        System.out.print("NIM Mahasiswa: ");
                        String nim = hahaa.nextLine();
                        System.out.print("Nama Mahasiswa: ");
                        String nama = hahaa.nextLine();

                        DataMahasiswa mahasiswa = new DataMahasiswa();
                        mahasiswa.setMhs_nim(nim);
                        mahasiswa.setMhs_nama(nama);
                        mahasiswa.setDaftarMataKuliah(new ArrayList<>());

                        daftarMahasiswa.add(mahasiswa);

                        while (true) {
                            // Input data mata kuliah
                            MataKuliah mataKuliah = new MataKuliah();
                            System.out.print("Kode Mata Kuliah: ");
                            String kodeMk = hahaa.nextLine();
                            mataKuliah.setMk_kode(kodeMk);
                            System.out.print("Nama Mata Kuliah: ");
                            String namaMk = hahaa.nextLine();
                            mataKuliah.setMk_nama(namaMk);

                            // Input nilai
                            System.out.print("Nilai (0.0-4.0): ");
                            double nilaiAngka = Double.parseDouble(hahaa.nextLine());
                            if (nilaiAngka < 0.0 || nilaiAngka > 4.0) {
                                System.out.println("Nilai harus dalam rentang 0.0 hingga 4.0.");
                                return;
                            }

                            String nilaiHuruf;
                            if (nilaiAngka >= 3.7) {
                                nilaiHuruf = "A";
                            } else if (nilaiAngka >= 3.2) {
                                nilaiHuruf = "B+";
                            } else if (nilaiAngka >= 2.7) {
                                nilaiHuruf = "B";
                            } else if (nilaiAngka >= 2.2) {
                                nilaiHuruf = "C+";
                            } else if (nilaiAngka >= 1.7) {
                                nilaiHuruf = "C";
                            } else if (nilaiAngka >= 1.2) {
                                nilaiHuruf = "D";
                            } else {
                                nilaiHuruf = "E";
                            }

                            mataKuliah.setMk_nilai(nilaiHuruf);
                            mahasiswa.getDaftarMataKuliah().add(mataKuliah);

                            System.out.print("Tambah mata kuliah lagi? (ya/tdk) ");
                            String opsi = hahaa.nextLine();
                            if (!opsi.equalsIgnoreCase("ya")) {
                                break;
                            }
                        }
                        break;
                    case 2:
                        System.out.print("Masukkan NIM: ");
                        String inputNIM = hahaa.nextLine();
                        boolean nimKetemu = false;
                        for (DataMahasiswa mhs : daftarMahasiswa) {
                            if (mhs.getMhs_nim().equals(inputNIM)) {
                                nimKetemu = true;
                                System.out.println("Kartu Hasil Studi (KHS) untuk Mahasiswa dengan NIM " + inputNIM + ":");
                                System.out.println("Nama Mahasiswa: " + mhs.getMhs_nama());
                                for (MataKuliah mk : mhs.getDaftarMataKuliah()) {
                                    System.out.println("Kode Mata Kuliah: " + mk.getMk_kode());
                                    System.out.println("Nama Mata Kuliah: " + mk.getMk_nama());
                                    System.out.println("Nilai: " + mk.getMk_nilai());
                                    System.out.println();
                                }
                                break;
                            }
                        }
                        if (!nimKetemu) {
                            System.out.println("Mahasiswa dengan NIM " + inputNIM + " tidak ditemukan.");
                        }
                        break;
                    case 3:
                        System.out.println("SELESAI");
                        lanjutMenu = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }

                if (!lanjutMenu) {
                    break;
                }
            }
        }
    }
}
