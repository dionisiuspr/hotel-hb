/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelhb;

/**
 *
 * @author ASUS
 */
import java.util.*;

class Lagu {

    String judul;
    String penyanyi;
    int durasiLagu;

    public Lagu(String judul, String penyanyi, int durasiLagu) {
        this.judul = judul;
        this.penyanyi = penyanyi;
        this.durasiLagu = durasiLagu;
    }
}

class Playlist {

    String judul;
    String penyanyi;
    int durasiLagu;

    public Playlist(String judul, String penyanyi, int durasiLagu) {
        this.judul = judul;
        this.penyanyi = penyanyi;
        this.durasiLagu = durasiLagu;
    }

    public Playlist(String judul, String penyanyi) {
        this.judul = judul;
        this.penyanyi = penyanyi;
    }
}

public class UAS_ProgramStrukDatAlvin {

    static ArrayList<Lagu> lagu = new ArrayList<Lagu>();
    static ArrayList<Playlist> pl = new ArrayList<Playlist>();
    static Scanner p = new Scanner(System.in);

    public static void main(String[] args) {

        lagu.add(new Lagu("A", "A", 120));
        lagu.add(new Lagu("B", "B", 90));
        lagu.add(new Lagu("C", "C", 200));
        lagu.add(new Lagu("D", "D", 70));
        lagu.add(new Lagu("E", "E", 88));
        int menu;
        do {
            System.out.println("Menu PlaylistHB: "
                    + "\n1.tambah lagu "
                    + "\n2.putar lagu ");
            menu = p.nextInt();
            switch (menu) {
                case 1:
                    AddSong();
                    break;
                case 2:
                    int menu1;
                    do {
                        System.out.println("1.create playlist"
                                + "\n2.playsong");
                        menu1 = p.nextInt();
                        switch (menu1) {
                            case 1:
                                AddPlaylist();
                                break;
                            case 2:
                                PlaySong();
                                break;
                        }
                    } while (menu != 3);
                    PlaySong();
                    break;
            }

        } while (menu != 3);
    }

    static void AddSong() {
        System.out.println("Masukan Judul lagu : ");
        String judulLagu = p.next();
        System.out.println("Masukan nama penyanyi : ");
        String namaPenyanyi = p.next();
        System.out.println("Masukan durasi lagu : ");
        System.out.println("(Dalam Detik)");
        int durasiLagu = p.nextInt();
        for (int i = 0; i < lagu.size(); i++) {
            if (lagu.get(i).judul.equals(judulLagu)) {
                System.out.println("judul lagu sudah didaftarkan!!!");
            } else {
                lagu.add(new Lagu(judulLagu, namaPenyanyi, durasiLagu));
            }
        }
    }

    static void AddPlaylist() {
        boolean Ceklagu = false;
        for (int i = 0; i < lagu.size(); i++) {
            System.out.println("Judul lagu : " + lagu.get(i).judul + "Nama Penyanyi : " + lagu.get(i).penyanyi + "Durasi : " + lagu.get(i).durasiLagu);
        }
        System.out.println("Masukan Judul lagu : ");
        String judulLagu = p.next();
        System.out.println("Masukan nama penyanyi : ");
        String namaPenyanyi = p.next();
        for (int i = 0; i < lagu.size(); i++) {
            if (lagu.get(i).judul.equals(judulLagu)) {
                pl.add(new Playlist(judulLagu, namaPenyanyi, lagu.get(i).durasiLagu));
                Ceklagu = true;
                break;
            }
        }
        if (!Ceklagu) {
            System.out.println("tidak ada di dalam gudang lagu!!!");
        } else {
            System.out.println("berhasil ditambahkan ke playlist!!!");
        }
    }

    static void PlaySong() {
        int y = 0;
        Random r = new Random();
        int x = r.nextInt(pl.size());
        y = x;
        System.out.println("Judul lagu : " + pl.get(x).judul + " \n Penyanyi : " + pl.get(x).penyanyi + "\n Durasi lagu : " + pl.get(x).durasiLagu);
        int menu;
        do {
            System.out.println("1.add song"
                    + "\n2.remove song"
                    + "\n3. play again"
                    + "\n4. prev song "
                    + "\n5.next song "
                    + "\n6.Stop");
            menu = p.nextInt();
            switch (menu) {
                case 1:
                    AddPlaylist();
                    break;
                case 2:
                    RemoveSong();
                    break;
                case 3:
                    System.out.println("Judul lagu : " + pl.get(x).judul + " \n Penyanyi : " + pl.get(x).penyanyi + "\n Durasi lagu : " + pl.get(x).durasiLagu);
                    break;
                case 4:
                    System.out.println("Judul lagu : " + pl.get(y).judul + " \n Penyanyi : " + pl.get(y).penyanyi + "\n Durasi lagu : " + pl.get(y).durasiLagu);
                    break;
                case 5:
                    y = x;
                    x = r.nextInt(pl.size());
                    System.out.println("Judul lagu : " + pl.get(x).judul + " \n Penyanyi : " + pl.get(x).penyanyi + "\n Durasi lagu : " + pl.get(x).durasiLagu);
                    break;
                case 6:

                    break;
            }
        } while (menu != 7);
    }

    static void RemoveSong() {
        for (int i = 0; i < pl.size(); i++) {
            System.out.println(pl.get(i).judul + "  " + pl.get(i).penyanyi + "  " + pl.get(i).durasiLagu);
        }
        String judulLagu;
        int dataKe = 0;
        boolean cekLagu = false;
        System.out.println("Judul lagu apa yang ingin dihapus?");
        judulLagu = p.next();

        for (int i = 0; i < pl.size(); i++) {
            if (pl.get(i).judul.equals(judulLagu)) {
                dataKe = i;
                cekLagu = true;
                break;
            }
            System.out.println(pl.get(i).judul + "  " + pl.get(i).penyanyi + "  " + pl.get(i).durasiLagu);
        }
        if (!cekLagu) {
            System.out.println("Belum terhapus!!!");
        } else {
            pl.remove(dataKe);
        }
    }

}
