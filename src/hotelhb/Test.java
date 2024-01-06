/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelhb;

import javax.swing.JOptionPane;

public class Test {

    public static class Sales {

        String nama, kodeSales;
        dataPenjualan[] arrDataPenjualan = new dataPenjualan[3];

        public Sales(String nama, String kodeSales) {
            this.nama = nama;
            this.kodeSales = kodeSales;
        }
    }

    public static class dataPenjualan {

        int totalPenjualanPerBulan;
        int totalPenjualanKaosPerBulan;
        int totalPenjualanKemejaPerBulan;
        int totalPenjualanCelanaPerBulan;

        public dataPenjualan(int totalPenjualanPerBulan, int totalPenjualanKaosPerBulan, int totalPenjualanKemejaPerBulan, int totalPenjualanCelanaPerBulan) {
            this.totalPenjualanPerBulan = totalPenjualanPerBulan;
            this.totalPenjualanKaosPerBulan = totalPenjualanKaosPerBulan;
            this.totalPenjualanKemejaPerBulan = totalPenjualanKemejaPerBulan;
            this.totalPenjualanCelanaPerBulan = totalPenjualanCelanaPerBulan;
        }
    }

    //data
    static String[] arrBulan = new String[]{"Desember", "Januari", "Februari"};
    static int[] arrHargaPerItem = new int[]{60000, 120000, 65000};

    //sales
    static Sales[] arrSales = {
        new Sales("Adi", "123"),
        new Sales("Budi", "321")
    };

    //menu 1
    static void InputHasilPenjualan() {

        String kodeSales = JOptionPane.showInputDialog("Masukkan kode sales: ");
        int sales = 0;

        for (int i = 0; i < 2; i++) {
            if (kodeSales.equals(arrSales[i].kodeSales)) {
                sales = i;
            }
        }

        for (int i = 0; i < 3; i++) { //langsung input untuk 3 bulan
            arrSales[sales].arrDataPenjualan[i].totalPenjualanKaosPerBulan = Integer.parseInt(JOptionPane.showInputDialog("Welcome " + arrSales[sales].nama + "\nSilahkan masukkan penjualan Kaos " + "\nUntuk Bulan " + arrBulan[i]));
            arrSales[sales].arrDataPenjualan[i].totalPenjualanKemejaPerBulan = Integer.parseInt(JOptionPane.showInputDialog("Welcome " + arrSales[sales].nama + "\nSilahkan masukkan penjualan Kemeja " + "\nUntuk Bulan " + arrBulan[i]));
            arrSales[sales].arrDataPenjualan[i].totalPenjualanCelanaPerBulan = Integer.parseInt(JOptionPane.showInputDialog("Welcome " + arrSales[sales].nama + "\nSilahkan masukkan penjualan Celana " + "\nUntuk Bulan " + arrBulan[i]));
        }
    }

    //menu 2
    static void PrintTotalBarangterjualPerBulanPerSales() {

        String kodeSales = JOptionPane.showInputDialog("Masukkan kode sales: ");
        int sales = 0;

        for (int i = 0; i < 2; i++) {
            if (kodeSales.equals(arrSales[i].kodeSales)) {
                sales = i;
            }
        }

        for (int i = 0; i < 3; i++) { //output per bulan tetapi langsung 3 bulan, tidak memilih bulan
            arrSales[sales].arrDataPenjualan[i].totalPenjualanPerBulan = (arrSales[sales].arrDataPenjualan[i].totalPenjualanKaosPerBulan + arrSales[sales].arrDataPenjualan[i].totalPenjualanKemejaPerBulan + arrSales[sales].arrDataPenjualan[i].totalPenjualanCelanaPerBulan);
            JOptionPane.showMessageDialog(null, "Total Penjualan Sales " + arrSales[sales].nama + " di Bulan " + arrBulan[i] + " adalah: \n" + arrSales[sales].arrDataPenjualan[i].totalPenjualanPerBulan);
        }
    }

    //menu 3
    static void UpdatePenjualanPerBulanPerSales() {
        String kodeSales = JOptionPane.showInputDialog("Masukkan kode sales: ");
        int updateBulan = Integer.parseInt(JOptionPane.showInputDialog("0. Desember\n1. Januari\n2. Febuari\nMasukkan angka Bulan yang ingin diupdate: "));
        int sales = 0;

        for (int i = 0; i < 2; i++) {
            if (kodeSales.equals(arrSales[i].kodeSales)) {
                sales = i;
            }
        }

        if (sales >= 0) {
            arrSales[sales].arrDataPenjualan[updateBulan].totalPenjualanKaosPerBulan = Integer.parseInt(JOptionPane.showInputDialog("Masukkan total penjualan Kaos yang ingin di update pada bulan " + arrBulan[updateBulan]));
            arrSales[sales].arrDataPenjualan[updateBulan].totalPenjualanKemejaPerBulan = Integer.parseInt(JOptionPane.showInputDialog("Masukkan total penjualan Kemeja yang ingin di update pada bulan " + arrBulan[updateBulan]));
            arrSales[sales].arrDataPenjualan[updateBulan].totalPenjualanCelanaPerBulan = Integer.parseInt(JOptionPane.showInputDialog("Masukkan total penjualan Celana yang ingin di update pada bulan " + arrBulan[updateBulan]));
            arrSales[sales].arrDataPenjualan[updateBulan].totalPenjualanPerBulan = (arrSales[sales].arrDataPenjualan[updateBulan].totalPenjualanKaosPerBulan + arrSales[sales].arrDataPenjualan[updateBulan].totalPenjualanKemejaPerBulan + arrSales[sales].arrDataPenjualan[updateBulan].totalPenjualanCelanaPerBulan); //untuk mengubah lagi totalnya

            JOptionPane.showMessageDialog(null, "Data Berhasil diubah! ");
        } else {
            JOptionPane.showMessageDialog(null, "Kode Sales Tidak ditemukkan!", "Alert", JOptionPane.ERROR_MESSAGE);
        }

    }

    //menu 4
    static void PrintHasilPenjualanPadaBulanTertentuDalamRupiah() {
        String kodeSales = JOptionPane.showInputDialog("Masukkan kode sales: ");
        int bulan = Integer.parseInt(JOptionPane.showInputDialog("0. Desember\n1. Januari\n2. Febuari\nMasukkan angka bulan yang ingin dicheck penjualannya: "));

        int sales = 0;

        for (int i = 0; i < 2; i++) {
            if (kodeSales.equals(arrSales[i].kodeSales)) {
                sales = i;
            }
        }

        int total = HitungHasilPenjualanPadaBulanTertentuDalamRupiah(sales, bulan);

        JOptionPane.showMessageDialog(null, "Penjualan oleh sales " + arrSales[sales].nama + " pada Bulan " + arrBulan[bulan] + " adalah\n" + total);
    }

    //menu 5
    static void PrintRataRataPenjualanSeorangSalesDalamRupiah() {
        int total = 0;
        String kodeSales = JOptionPane.showInputDialog("Masukkan kode sales: ");

        int sales = 0;

        for (int i = 0; i < 2; i++) {
            if (kodeSales.equals(arrSales[i].kodeSales)) {
                sales = i;
            }
        }

        for (int i = 0; i < 3; i++) {
            total += HitungHasilPenjualanPadaBulanTertentuDalamRupiah(sales, i);
        }

        int rataRata = total / 3;

        JOptionPane.showMessageDialog(null, "Rata-rata penjualan oleh sales " + arrSales[sales].nama + " dalam 3 bulan adalah\n" + rataRata);
    }

    //function
    static int HitungHasilPenjualanPadaBulanTertentuDalamRupiah(int sales, int bulan) {
        return (arrSales[sales].arrDataPenjualan[bulan].totalPenjualanKaosPerBulan * arrHargaPerItem[0]) + (arrSales[sales].arrDataPenjualan[bulan].totalPenjualanKemejaPerBulan * arrHargaPerItem[1]) + (arrSales[sales].arrDataPenjualan[bulan].totalPenjualanCelanaPerBulan * arrHargaPerItem[2]);
    }

    public static void main(String[] args) {

        //deklarasi
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                arrSales[i].arrDataPenjualan[j] = new dataPenjualan(0, 0, 0, 0);
            }
        }

        int respon = 1;

        while (respon != 6) {

            respon = Integer.parseInt(JOptionPane.showInputDialog("1. Input Hasil Penjualan \n2. Hasil Penjualan per Bulan \n3. Update Penjualan \n4. Hitung Total Penjualan per Bulan (rupiah) \n5. Rata-rata penjualan seluruh barnag \n6. Exit \nMasukkan nomor menu: "));

            switch (respon) {
                case 1:
                    InputHasilPenjualan();
                    break;

                case 2:
                    PrintTotalBarangterjualPerBulanPerSales();
                    break;

                case 3:
                    UpdatePenjualanPerBulanPerSales();
                    break;

                case 4:
                    PrintHasilPenjualanPadaBulanTertentuDalamRupiah();
                    break;

                case 5:
                    PrintRataRataPenjualanSeorangSalesDalamRupiah();
                    break;

                case 6:
                    JOptionPane.showMessageDialog(null, "Thx!");
                    break;

                default:
                    respon = 7;
                    JOptionPane.showMessageDialog(null, "Check kembali input!", "Alert", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}