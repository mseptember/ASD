import java.util.*;

public class Test {
    static List<List<Wspolrzedna>> listaSciezek = new ArrayList<>();
    static char[][] tab = new char[10][10];//tablica pól
    static int ws = 0, ks = 0, wk = 0, kk = 0;//wiersz s, kolumna s, wiersz k, kolumna k; potrzebne do współrzędnych s i k
    static int ogr = 0;

    public static void main(String[] args) {
        char s = 'S', k = 'K'; //ASCII S=83, K=75
        List<Wspolrzedna> sciezka = new ArrayList<>();

        Random generator = new Random();

        for (int i = 0; i < tab.length; i++) { //utworzenie labiryntu 0 i 1
            for (int j = 0; j < tab[i].length; j++) {
                tab[i][j] = (char) (generator.nextInt(2) + 48); //+48 bo ASCII 0 -> 48 i 1 -> 49
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

        System.out.print("Start: " + wspolS);
        System.out.println(", Koniec: " + wspolK);
        System.out.println();

        listaSciezek.add(sciezka);
        wyborDrogi(sciezka, ws, ks);

        //Collections.sort(listaSciezek);
        //System.out.println(najkrotsza);
        /*for (List<Wspolrzedna> w : listaSciezek) {
            System.out.println(w);
        }*/

        try {
            List<Wspolrzedna> najkrotsza = listaSciezek.get(0);
            System.out.print("Istnieje droga: ");

            for (List<Wspolrzedna> w : listaSciezek) {
                if (najkrotsza.size() > w.size()) {
                    najkrotsza = w;
                }
            }

            for (Wspolrzedna w : najkrotsza) {
                //System.out.print("(" + w.x + "," + w.y + "), ");
                System.out.println(w);
            }
        } catch (Exception ex) {
            System.out.println("Nie ma drogi!");
        }

    }

    public static void sprawdzCzyMozna(List<Wspolrzedna> lista, int x, int y) {
        if (ogr == 0 || ogr > lista.size()) { //nie pamietam do czego byl ten warunek
            if (tab[x][y] != '0') { //czy mogę się tam ruszyć
                List<Wspolrzedna> pomocnicza = new ArrayList<>(lista);
                listaSciezek.add(pomocnicza);

                if (tab[x][y] == 'K') { //jak wejdę na K
                    //zakończ ścieżkę
                    ogr = pomocnicza.size();
                    pomocnicza.add(new Wspolrzedna(x, y));
                }
                else { //jak inna niż K
                    boolean bezPowtorzen = false;

                    for (Wspolrzedna w : pomocnicza) { //dodaję do pomocniczej listy współrzędną
                        if (x == w.x && y == w.y) {
                            bezPowtorzen = true;
                            break;
                        }
                    }
                    if (!bezPowtorzen) {
                        //pomocnicza.add(new Wspolrzedna(x, y));
                        wyborDrogi(pomocnicza, x, y);
                    }
                }
            }
        }
    }

    public static void wyborDrogi(List<Wspolrzedna> lista, int x, int y) {
        lista.add(new Wspolrzedna(x, y));
        //czy nie wychodzi poza tablicę
        if (y + 1 < tab.length && tab[x][y + 1] != '0') { //prawo
            sprawdzCzyMozna(lista, x, y + 1);
        }
        if (x + 1 < tab.length && tab[x + 1][y] != '0') { //dół
            sprawdzCzyMozna(lista, x + 1, y);
        }
        if (y - 1 >= 0 && tab[x][y - 1] != '0') { //lewo
            sprawdzCzyMozna(lista, x, y - 1);
        }
        if (x - 1 >= 0 && tab[x - 1][y] != '0') { //góra
            sprawdzCzyMozna(lista, x - 1, y);
        }
    }
}
