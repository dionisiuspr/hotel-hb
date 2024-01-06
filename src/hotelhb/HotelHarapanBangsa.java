package hotelhb;

import javax.swing.JOptionPane;

/**
 *
 * @author hanschristian
 */
class Cabang {

    String nama;
    String lokasi;
    Kamar[] arrKamar = new Kamar[3];

    // Cabang itu adalah kode untuk.......
    public Cabang(String nama, String lokasi) {
        this.nama = nama;
        this.lokasi = lokasi;
    }

    // jika arrKamar nya ukurannya berbeda-beda untuk setiap initilisasi data
    // new Cabang("Dago", "Jl. Dago no.50", new Kamar[13]),
    public Cabang(String nama, String lokasi, Kamar[] arrKamar) {
        this.nama = nama;
        this.lokasi = lokasi;
        this.arrKamar = arrKamar;
    }

    // sama dengan di atas tapi lebih simplify
    // arrCabang[0] = new Cabang("Dago", "Jl. Dago no.50", 13),
    public Cabang(String nama, String lokasi, int jumlahKamar) {
        this.nama = nama;
        this.lokasi = lokasi;
        this.arrKamar = new Kamar[jumlahKamar];
    }
}

class Kamar {

    String kode;
    int hargaPerMalam;
    int biayaPerawatan;
    int lamaInap;

    Kamar(String kode, int hargaPerMalam, int biayaPerawatan, int lamaInap) {
        this.kode = kode;
        this.hargaPerMalam = hargaPerMalam;
        this.biayaPerawatan = biayaPerawatan;
        this.lamaInap = lamaInap;
    }
}

public class HotelHarapanBangsa {

    static Cabang[] arrCabang = {
        new Cabang("Dago", "Jl. Dago no.50"),
        new Cabang("Sudirman", "Jl. Sudirman no.26"),
        new Cabang("Dipati Ukur", "Jl. Dipati Ukur no.8")
    };

    public static void main(String[] args) {
        boolean menu = true;
        // jelasin code ini untuk apa...
        // pengulangan untuk menu
        while (menu) {
            int inputMenu = Integer.parseInt(JOptionPane.showInputDialog(null, "Hotel Harapan Bangsa"
                    + "\n1. Input Data Kamar"
                    + "\n2. Lihat Data Kamar"
                    + "\n3. Update Data Kamar"
                    + "\n4. Hitung Total Bayar Suatu Kamar"
                    + "\n5. Hitung Keuntungan Total Suatu Cabang"
                    + "\n6. Hitung Keuntungan Total Semua Cabang"
                    + "\n7. Exit", 0));

            switch (inputMenu) {
                case 1:
                    inputDataKamar(true);
                    break;
                case 2:
                    lihatDataKamar();
                    break;
                case 3:
                    inputDataKamar(false);
                    break;
                case 4:
                    menuHitungTotalBayar1Kamar();
                    break;
                case 5:
                    menuHitungKeuntungan1Cabang();
                    break;
                case 6:
                    menuHitungKeuntunganSeluruhCabang();
                    break;
                case 7:
                    menu = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Input Salah!", "Alert", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
    }

    static void inputDataKamar(boolean newData) {
        int inputCabang = Integer.parseInt(JOptionPane.showInputDialog(null, "Pilihan Cabang :"
                + "\n1. Dago"
                + "\n2. Sudirman"
                + "\n3. Dipati Ukur", 0));
        String kodeKamar = JOptionPane.showInputDialog(null, "Input Kode Kamar :", 0);
        int hargaKamar = Integer.parseInt(
                JOptionPane.showInputDialog(null, "Input Harga Kamar per malam :", 0));
        int biayaPerawatan = Integer.parseInt(
                JOptionPane.showInputDialog(null, "Input Biaya Perawatan per malam :", 0));
        int lamaInap = Integer.parseInt(
                JOptionPane.showInputDialog(null, "Lama Menginap :", 0));

        int confirm = JOptionPane.showConfirmDialog(null, "Apakah anda yakin data sudah benar?");
        if (confirm == JOptionPane.YES_OPTION) {
            Cabang selectedCabang = arrCabang[inputCabang - 1];
            if (newData == true) {
                boolean isAdded = false;
                for (int i = 0; i < selectedCabang.arrKamar.length; i++) {
                    // [{null}, {null}, {null}]
                    if (selectedCabang.arrKamar[i] == null) {
                        Kamar newKamar = new Kamar(kodeKamar, hargaKamar, biayaPerawatan, lamaInap);
                        selectedCabang.arrKamar[i] = newKamar;
//                        int total = hitungTotalBayar1Kamar(newKamar);
                        JOptionPane.showMessageDialog(null, "Data kamar baru berhasil disimpan");
                        isAdded = true;
                        break;
                    }
                }
                if (!isAdded) {
                    JOptionPane.showMessageDialog(null, "Data kamar sudah penuh!");
                }
            } else {
                boolean isAdded = false;
                for (int i = 0; i < selectedCabang.arrKamar.length; i++) {
                    // [{Kamar(kode: 123)}, {null}, {Kamar(kode: 345)}]
                    if (selectedCabang.arrKamar[i].kode.equals(kodeKamar)) {
                        selectedCabang.arrKamar[i] = new Kamar(kodeKamar, hargaKamar, biayaPerawatan, lamaInap);
                        JOptionPane.showMessageDialog(null, "Data kamar sudah diperbaharui!");
                        isAdded = true;
                        break;
                    }
                }
                if (!isAdded) {
                    JOptionPane.showMessageDialog(null, "Data kamar tidak ditemukan!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Data kamar tidak disimpan, silahkan input kembali");
            inputDataKamar(true);
        }
    }

    static void lihatDataKamar() {
        int inputCabang = Integer.parseInt(JOptionPane.showInputDialog(null, "Pilihan Cabang :"
                + "\n1. Dago"
                + "\n2. Sudirman"
                + "\n3. Dipati Ukur", 0));
        StringBuilder builder = new StringBuilder();
        for (Kamar kamar : arrCabang[inputCabang - 1].arrKamar) {
            if (kamar != null) {
                builder.append("Kode: " + kamar.kode);
                builder.append(", Harga: " + kamar.hargaPerMalam);
                builder.append(", Biaya: " + kamar.biayaPerawatan);
                builder.append(", Lama Inap: " + kamar.lamaInap);
                builder.append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, builder);
    }

    static void menuHitungTotalBayar1Kamar() {
        int inputCabang = Integer.parseInt(JOptionPane.showInputDialog(null, "Pilihan Cabang :"
                + "\n1. Dago"
                + "\n2. Sudirman"
                + "\n3. Dipati Ukur", 0));
        String kodeKamar = JOptionPane.showInputDialog(null, "Input Kode Kamar :", 0);
        Cabang selectedCabang = arrCabang[inputCabang - 1];
        for (int i = 0; i < selectedCabang.arrKamar.length; i++) {
            if (selectedCabang.arrKamar[i].kode.equals(kodeKamar)) {
                int bayar = hitungTotalBayar1Kamar(selectedCabang.arrKamar[i]);
                JOptionPane.showMessageDialog(null, "Total Bayar Kamar " + kodeKamar + " adalah Rp." + bayar);
                break;
            }
        }
    }

    // Parameter kurang spesifik
    static int hitungTotalBayar1Kamar(Cabang[] cabang, int inputCabang, String kodeKamar) {
        return 0;
    }

    // Parameter kurang spesifik
    static int hitungTotalBayar1Kamar(Cabang cabang, String kodeKamar) {
        return 0;
    }

    // Parameter kurang spesifik
    static int hitungTotalBayar1Kamar(Kamar[] arrKamar, int index) {
        Kamar kamar = arrKamar[index];
        int total = (kamar.hargaPerMalam - kamar.biayaPerawatan) * kamar.lamaInap;
        return 0;
    }

    static int hitungTotalBayar1Kamar(Kamar kamar) {
        int total = (kamar.hargaPerMalam - kamar.biayaPerawatan) * kamar.lamaInap;
        return total;
    }

    // Parameter terlalu spesifik
    static int hitungTotalBayar1Kamar(int hargaPerMalam, int biayaPerawatan, int lamaInap) {
        int total = (hargaPerMalam - biayaPerawatan) * lamaInap;
        return total;
    }

    static void menuHitungKeuntungan1Cabang() {
        int inputCabang = Integer.parseInt(JOptionPane.showInputDialog(null, "Pilihan Cabang :"
                + "\n1. Dago"
                + "\n2. Sudirman"
                + "\n3. Dipati Ukur", 0));
        int total = hitungKeuntungan1Cabang(arrCabang[inputCabang - 1]);
        JOptionPane.showMessageDialog(null, "Total Keuntungan Cabang " + inputCabang + " adalah Rp." + total);
    }

    static int hitungKeuntungan1Cabang(Cabang cabang) {
        int total = 0;
        for (int i = 0; i < cabang.arrKamar.length; i++) {
            if (cabang.arrKamar[i] != null) {
                total += hitungTotalBayar1Kamar(cabang.arrKamar[i]);
            }
        }
        return total;
    }

    static void menuHitungKeuntunganSeluruhCabang() {
        int total = 0;
        for (int i = 0; i < arrCabang.length; i++) {
            total += hitungKeuntungan1Cabang(arrCabang[i]);
        }
        JOptionPane.showMessageDialog(null, "Total Keuntungan Seluruh Cabang adalah Rp." + total);
    }
}
