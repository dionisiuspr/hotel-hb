//package hotelhb;
//
///**
// *
// * @author Dionisius
// */
////class Penjualan {
////
////    int totalKaos;
////    int totalKemeja;
////    int totalCelana;
////
////    Penjualan(int kaos, int kemeja, int celana) {
////        this.totalKaos = kaos;
////        this.totalKemeja = kemeja;
////        this.totalCelana = celana;
////    }
////}
////
////class Sales {
////
////    String name;
////    String kodeSalesPerson;
////    Penjualan[] arrJual = new Penjualan[3];
////
////    public Sales(String name, String kode) {
////        this.name = name;
////        this.kodeSalesPerson = kode;
////    }
////}
//
//public class TokoMantap {
//
//    static Sales[] arrSales = {
//        new Sales("Dion", "SA01"),
//        new Sales("Ken", "SA02")
//    };
//
//    public static void main(String[] args) {
//        int hargaKaos = 60000;
//        int hargaKemeja = 120000;
//        int hargaCelana = 65000;
//        
//        // Sales 1 ==========================================================
//        // 00 = sales index 0 (Dion), penjualan bulan ke 0 (Des 20)
//        // 01 = sales index 0 (Dion), penjualan bulan ke 1 (Jan 21)
//        // 02 = sales index 0 (Dion), penjualan bulan ke 2 (Feb 21)
//        int kaos00 = 10;
//        int kemeja00 = 11;
//        int celana00 = 12;
//        arrSales[0].arrJual[0] = new Penjualan(kaos00, kemeja00, celana00);
//        System.out.println(arrSales[0].arrJual[0].totalKaos);
//        System.out.println(arrSales[0].arrJual[0].totalKemeja);
//        System.out.println(arrSales[0].arrJual[0].totalCelana);
//
//        int kaos01 = 21;
//        int kemeja01 = 31;
//        int celana01 = 41;
//        arrSales[0].arrJual[1] = new Penjualan(kaos01, kemeja01, celana01);
//        System.out.println(arrSales[0].arrJual[1].totalKaos);
//        System.out.println(arrSales[0].arrJual[1].totalKemeja);
//        System.out.println(arrSales[0].arrJual[1].totalCelana);
//
//        int kaos02 = 45;
//        int kemeja02 = 25;
//        int celana02 = 11;
//        arrSales[0].arrJual[2] = new Penjualan(kaos02, kemeja02, celana02);
//
//        System.out.println(arrSales[0].arrJual[2].totalKaos);
//        System.out.println(arrSales[0].arrJual[2].totalKemeja);
//        System.out.println(arrSales[0].arrJual[2].totalCelana);
//
//        int sales00 = arrSales[0].arrJual[0].totalCelana * hargaCelana
//                + arrSales[0].arrJual[0].totalKaos * hargaKaos 
//                + arrSales[0].arrJual[0].totalKemeja * hargaKemeja;
//
//        int sales01 = arrSales[0].arrJual[1].totalCelana * hargaCelana
//                + arrSales[0].arrJual[1].totalKaos * hargaKaos 
//                + arrSales[0].arrJual[1].totalKemeja * hargaKemeja;
//
//        int sales02 = arrSales[0].arrJual[2].totalCelana * hargaCelana
//                + arrSales[0].arrJual[2].totalKaos * hargaKaos 
//                + arrSales[0].arrJual[2].totalKemeja * hargaKemeja;
//
//        System.out.println("Sales 00: " + sales00);
//        System.out.println("Sales 01: " + sales01);
//        System.out.println("Sales 02: " + sales02);
//
//        // Sales 1 ==========================================================
//        // 10 = sales index 1 (Ken), penjualan bulan ke 0 (Des 20)
//        // 11 = sales index 1 (Ken), penjualan bulan ke 1 (Jan 21)
//        // 12 = sales index 1 (Ken), penjualan bulan ke 2 (Feb 21)
//        int kaos10 = 1;
//        int kemeja10 = 1;
//        int celana10 = 1;
//        arrSales[1].arrJual[0] = new Penjualan(kaos10, kemeja10, celana10);
//        System.out.println(arrSales[1].arrJual[0].totalKaos);
//        System.out.println(arrSales[1].arrJual[0].totalKemeja);
//        System.out.println(arrSales[1].arrJual[0].totalCelana);
//
//        int kaos11 = 2;
//        int kemeja11 = 3;
//        int celana11 = 4;
//        arrSales[1].arrJual[1] = new Penjualan(kaos11, kemeja11, celana11);
//        System.out.println(arrSales[1].arrJual[1].totalKaos);
//        System.out.println(arrSales[1].arrJual[1].totalKemeja);
//        System.out.println(arrSales[1].arrJual[1].totalCelana);
//
//        int kaos12 = 5;
//        int kemeja12 = 9;
//        int celana12 = 10;
//        arrSales[1].arrJual[2] = new Penjualan(kaos12, kemeja12, celana12);
//
//        System.out.println(arrSales[1].arrJual[2].totalKaos);
//        System.out.println(arrSales[1].arrJual[2].totalKemeja);
//        System.out.println(arrSales[1].arrJual[2].totalCelana);
//
//        int sales10 = arrSales[1].arrJual[0].totalCelana * hargaCelana
//                + arrSales[1].arrJual[0].totalKaos * hargaKaos 
//                + arrSales[1].arrJual[0].totalKemeja * hargaKemeja;
//
//        int sales11 = arrSales[1].arrJual[1].totalCelana * hargaCelana
//                + arrSales[1].arrJual[1].totalKaos * hargaKaos 
//                + arrSales[1].arrJual[1].totalKemeja * hargaKemeja;
//
//        int sales12 = arrSales[1].arrJual[2].totalCelana * hargaCelana
//                + arrSales[1].arrJual[2].totalKaos * hargaKaos 
//                + arrSales[1].arrJual[2].totalKemeja * hargaKemeja;
//
//        System.out.println("Sales 10: " + sales10);
//        System.out.println("Sales 11: " + sales11);
//        System.out.println("Sales 12: " + sales12);
//
////        arrSales[1].arrJual[3] = new Penjualan(kaos12, kemeja12, celana12); --> OUT OF BOUNDS
//
//    }
//
//}