/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelhb;

import java.util.Scanner;

/**
 *
 * @author natanael billy
 */
public class LatihanUas {

    static class dataMhs {

        String HM;
        int sks;
    }

    static class data {

        String nim, nama;
        dataMhs matkul[] = new dataMhs[10];
    }
    static data mahasiswa = new data();
    static Scanner s = new Scanner(System.in);

    public static double konversi(String HurufMutu) {
        System.out.println("--------------------------------");
        System.out.println("HurufMutu di function konversi: " + HurufMutu);
        if (HurufMutu.equals("A")) { // bandingin string di Java jangan == tapi pake .equals()
            return 4;
        } else if (HurufMutu.equals("B+")) {
            return 3.5;
        } else if (HurufMutu.equals("B")) {
            return 3;
        } else if (HurufMutu.equals("C+")) {
            return 2.5;
        } else if (HurufMutu.equals("C")) {
            return 2;
        } else if (HurufMutu.equals("D")) {
            return 1;
        } else {
            return 0;
        }
    }

    public static double IPS(int sks, String nilai) {
        double totalNilai = 0;
        totalNilai = (konversi(nilai) * sks);
        return totalNilai;
    }

    public static void main(String[] args) {
        double ipsHasil = 0, totalNilai = 0;
        int totalSKS = 0;
        double nilai = 0.0;

        System.out.println("NIM:");
        mahasiswa.nim = s.next();
        System.out.println("Nama:");
        mahasiswa.nama = s.next();

        for (int i = 0; i < 10; i++) {
            mahasiswa.matkul[i] = new dataMhs();
        }

        for (int j = 0; j < 10; j++) {
            System.out.println("Masukan nilai matkul ke-" + (j + 1));
            mahasiswa.matkul[j].HM = s.next();
            System.out.println("Masukan sks matkul ke-" + (j + 1));
            mahasiswa.matkul[j].sks = s.nextInt();
            System.out.println("=============================================================");

            // print data --> kalau bingung datanya masuk atau engga, print dulu dah
            System.out.println("SKS matkul ke-" + (j + 1) + " = " + mahasiswa.matkul[j].sks);
            System.out.println("Nil matkul ke-" + (j + 1) + " = " + mahasiswa.matkul[j].HM);

            // Konversi nilai
            nilai = konversi(mahasiswa.matkul[j].HM) * mahasiswa.matkul[j].sks;
            totalNilai += nilai;
            System.out.println("Total Nilai di iterasi " + (j + 1) + " = " + totalNilai);

            // Hitung total SKS
            totalSKS += mahasiswa.matkul[j].sks;
            System.out.println("Total SKS  di iterasi " + (j + 1) + " = " + totalSKS);
            System.out.println("=============================================================");

        }
        ipsHasil = totalNilai / totalSKS;
        System.out.println("Ips anda semester ini :" + ipsHasil);
    }
}
