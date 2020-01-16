package Niepotrzebne;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Dodatkowa {

//public class Main {
    //static int[][] odwiedzone = new int[10][10];
    //static List<Wspolrzedna> listaSciezek = new ArrayList<>();
    //static String sciezka;
    //public static void main(String[] args) {
    //char s = 'S', k = 'K'; //ASCII S=83, K=75
    //int ws = 0, ks = 0, wk = 0, kk = 0;//wiersz s, kolumna s, wiersz k, kolumna k; potrzebne do współrzędnych s i k
    //char[][] tab = new char[10][10];//tablica pól
    //int[][] odwiedzone = new int[10][10];
        /*
        0 - brak ścieżki
        1 - ścieżka nieodwiedzona
        2 - ścieżka odwiedzona
        3 - początek
        4 - koniec
        */
    //String sciezka;
    //String[] drogi = new String[30];
    //List<Wspolrzedna> listaSciezek = new ArrayList<Wspolrzedna>();
    //int[] wskaznik = new int[2];
    //Random generator = new Random();
        /*
        for (int i = 0; i < tab.length; i++) { //utworzenie labiryntu 0 i 1
            for (int j = 0; j < tab[i].length; j++) {
                tab[i][j] = (char) (generator.nextInt(2) + 48); //+48 bo ASCII 0 i 1
            }
        }

        tab[generator.nextInt(10)][generator.nextInt(10)] = s;
        tab[generator.nextInt(10)][generator.nextInt(10)] = k;

        for (int i = 0; i < tab.length; i++) { //wyświetlenie całego labiryntu
            for (int j = 0; j < tab[i].length; j++) {
                System.out.print(tab[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < tab.length; i++) { //znajdywanie wspołrzędnych S i K
            for (int j = 0; j < tab[i].length; j++) {
                if (tab[i][j] == s) {
                    ws = i;
                    ks = j;
                } else if (tab[i][j] == k) {
                    wk = i;
                    kk = j;
                }
            }
        }

        Wspolrzedna wspolS = new Wspolrzedna(ws, ks);
        Wspolrzedna wspolK = new Wspolrzedna(wk, kk);
        //sciezka = "(" + ws + "," + ks + "),";
        //sciezka[0] = "(" + ws + "," + ks + ")"; //dodanie Startu do ścieżki
        //int krok = 1; // zmienna potrzebna do dodawania współrzędnych do ścieżki

        //System.out.println("S: (" + ws + "," + ks + "),  K: (" + wk + "," + kk + ")");
        System.out.println(wspolS);
        System.out.println(wspolK);
        System.out.println();

        for (int i = 0; i < odwiedzone.length; i++) {
            for (int j = 0; j < odwiedzone[i].length; j++) {
                if (tab[i][j] == s) {
                    odwiedzone[i][j] = 3; //początek ścieżki
                } else if (tab[i][j] == k) {
                    odwiedzone[i][j] = 4; //koniec ścieżki
                } else if (tab[i][j] == '0') { //ściana labiryntu
                    odwiedzone[i][j] = 0;
                } else if (tab[i][j] == '1') { //droga labiryntu
                    odwiedzone[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < odwiedzone.length; i++) { //wyświetlenie początkowej tablicy odwiedzonych
            for (int j = 0; j < odwiedzone[i].length; j++) {
                System.out.print(odwiedzone[i][j] + " ");
            }
            System.out.println();
        }
        */
        /*
        for (int i = ws; i < odwiedzone.length; i++) { //przejście po ścieżkach od S
            for (int j = ks; j < odwiedzone[i].length; j++) {
                if (i+1 < odwiedzone.length && i-1 >= 0 && j+1 < odwiedzone[i].length && j-1 >= 0) { //jak mi nie wychodzi poza tablicę
                    if (odwiedzone[i + 1][j] == 1) { //po prawej od S
                        wskaznik[0] = i + 1;
                        wskaznik[1] = j;
                        sciezka[krok] = "(" + wskaznik[0] + "," + wskaznik[1] + ")";
                        krok++;
                        odwiedzone[i + 1][j] = 2;

                        if (czyKoniec(i, j, wk, kk)) {
                            break;
                        }


                    } else if (odwiedzone[i][j + 1] == 1) { //dół od startu
                        wskaznik[0] = i;
                        wskaznik[1] = j + 1;
                        sciezka[krok] = "(" + wskaznik[0] + "," + wskaznik[1] + ")";
                        krok++;
                        odwiedzone[i][j + 1] = 2;

                        if (czyKoniec(i, j, wk, kk)) {
                            break;
                        }
                    } else if (odwiedzone[i - 1][j] == 1) { //po lewej od startu
                        wskaznik[0] = i - 1;
                        wskaznik[1] = j;
                        sciezka[krok] = "(" + wskaznik[0] + "," + wskaznik[1] + ")";
                        krok++;
                        odwiedzone[i - 1][j] = 2;

                        if (czyKoniec(i, j, wk, kk)) {
                            break;
                        }
                    } else if (odwiedzone[i][j - 1] == 1) { //góra od startu
                        wskaznik[0] = i;
                        wskaznik[1] = j - 1;
                        sciezka[krok] = "(" + wskaznik[0] + "," + wskaznik[1] + ")";
                        krok++;
                        odwiedzone[i][j - 1] = 2;

                        if (czyKoniec(i, j, wk, kk)) {
                            break;
                        }
                    }
                }

                else {
                    System.out.println("Brak ścieżek z S do K");
                }
            }
            //czy ścieżka/ścieżki jest/są poprawne
            //która z poprawnych ścieżek jest najkrótsza
        }*/

    //int x = ws, y = ks; //zmienne pomocnicze ustawione na S (Start labiryntu)
    //boolean warunek = true;

    //System.out.println(gowno(x, y, wk, kk));

    //System.out.println(sciezka);

        /*
        do {

            if(x == wk && y == kk) {
                System.out.println("Istnieje ścieżka");
                warunek = false;
            }

            if (x + 1 < odwiedzone.length && x - 1 >= 0 && y + 1 < odwiedzone[x].length && y - 1 >= 0) { //jak mi nie wychodzi poza tablicę
                if (odwiedzone[x][y+1] == 1) { //po prawej od S
                    wskaznik[0] = x + 1;
                    wskaznik[1] = y;
                    sciezka = "(" + wskaznik[0] + "," + wskaznik[1] + "), ";
                    odwiedzone[x + 1][y] = 2;
                    x++;
                    y++;
                } else if (odwiedzone[x+1][y] == 1) { //dół od startu
                    wskaznik[0] = x;
                    wskaznik[1] = y + 1;
                    sciezka = "(" + wskaznik[0] + "," + wskaznik[1] + "), ";
                    odwiedzone[x][y + 1] = 2;
                    x++;
                    y++;
                }

                else if (odwiedzone[x][y-1] == 1) { //po lewej od startu
                    wskaznik[0] = x - 1;
                    wskaznik[1] = y;
                    sciezka = "(" + wskaznik[0] + "," + wskaznik[1] + "), ";
                    krok++;
                    odwiedzone[x - 1][y] = 2;
                    x++;
                    y++;
                }

                else if (odwiedzone[x-1][y] == 1) { //góra od startu
                    wskaznik[0] = x;
                    wskaznik[1] = y - 1;
                    sciezka = "(" + wskaznik[0] + "," + wskaznik[1] + "), ";
                    krok++;
                    odwiedzone[x][y - 1] = 2;

                    x++;
                    y++;
                }

                else { //jak S nie ma żadnych "sąsiadów"
                    System.out.println("Brak ścieżki z S");
                    warunek = false;
                }
            }
            //else warunek = false;
        } while (x != wk && y != kk && warunek);
        */


    //}

    /*public static boolean czyKoniec(int w, int k, int wk, int kk) { //metoda zwraca czy dane współrzędne są współrzędnymi końca labiryntu
        if (w == wk && k == kk) {
            return true;
        } else {
            return false;
        }
    }*/

    /*
    public boolean czyPoprawna(String sciezka, int wk, int kk) {
        if (sciezka == )
    }
    */

    /*public static String gowno(int wiersz, int kolumna, int wkonca, int kkonca) {
        if (wiersz == wkonca && kolumna == kkonca) {
            System.out.println("Istnieje ścieżka");
            //warunek = false;
            //zwróć stringa który składa się z tamtych wartości
            return sciezka;
        }

        if (kolumna + 1 < 10) {
            if (odwiedzone[wiersz][kolumna + 1] == 1) { //po prawejsciezka += "(" + wiersz + "," + kolumna + "),";
                sciezka += "(" + wiersz + "," + (kolumna+1) + "),";
                odwiedzone[wiersz][kolumna + 1] = 2;
                gowno(wiersz, kolumna + 1, wkonca, kkonca);
                return sciezka;
            }
        }
        else if (wiersz + 1 < 10) {
            if (odwiedzone[wiersz + 1][kolumna] == 1) { //w dół
                sciezka += "(" + (wiersz+1) + "," + kolumna + "),";
                odwiedzone[wiersz + 1][kolumna] = 2;
                gowno(wiersz + 1, kolumna, wkonca, kkonca);
                return sciezka;
            }
        }
        else if (kolumna - 1 >= 0) {
            if (odwiedzone[wiersz][kolumna - 1] == 1) { //po lewej
                sciezka += "(" + wiersz + "," + (kolumna-1) + "),";
                odwiedzone[wiersz][kolumna - 1] = 1;
                gowno(wiersz, kolumna - 1, wkonca, kkonca);
                return sciezka;
            }
        }
        else if (wiersz - 1 >= 0) {
            if (odwiedzone[wiersz - 1][kolumna] == 1) { //w górę
                sciezka += "(" + (wiersz-1) + "," + kolumna + "),";
                odwiedzone[wiersz - 1][kolumna] = 2;
                gowno(wiersz - 1, kolumna, wkonca, kkonca);
                return sciezka;
            }
        }
        else {
            return "Wyjebało";
        }
        return null;
    }*/
//}

}
