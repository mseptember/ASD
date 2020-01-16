import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Main {
    static List<List<Wspolrzedna>> listaSciezek; //lista wielu ścieżek
    static char[][] lab = new char[10][10]; //tablica pól labiryntu
    static Wspolrzedna start, koniec;
    static boolean czyIstnieje = false; //czy istnieje ścieżka
    static Random generator = new Random();

    public static void main(String[] args) {
        char s = 'S', k = 'K'; //ASCII S=83, K=75
        List<Wspolrzedna> sciezka; //jedna ścieżka

        while (!czyIstnieje) { //dopóki nie istnieje labirynt z istniejącą ścieżką wykonuje się pętla

            //"zerowanie" zmiennych jeżeli wylosowany labirynt nie miał istniejącej ścieżki
            czyIstnieje = false;
            listaSciezek = new ArrayList<>();
            sciezka = new ArrayList<>();

            for (int i = 0; i < lab.length; i++) { //utworzenie labiryntu 0 i 1
                for (int j = 0; j < lab[i].length; j++) {
                    lab[i][j] = (char) (generator.nextInt(2) + 48); //+48 bo ASCII 0 -> 48 i 1 -> 49
                }
            }

            start = wylosujWspolrzedna(); //losowanie startu
            koniec = wylosujWspolrzedna(); //losowanie końca
            while (koniec.equals(start)) { //pętla na wypadek wylosowania startu i końca w tym samym miejscu
                koniec = wylosujWspolrzedna();
            }

            lab[start.y][start.x] = s;
            lab[koniec.y][koniec.x] = k;

            for (int i = 0; i < lab.length; i++) { //wyświetlenie całego labiryntu
                for (int j = 0; j < lab[i].length; j++) {
                    System.out.print(lab[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();

            System.out.print("Start: " + start); //wypisanie na ekran współrzędnych S
            System.out.println(", Koniec: " + koniec); //wypisanie na ekran współrzędnych K
            System.out.println();

            idzWKierunku(sciezka, start.x, start.y);

        }

        listaSciezek.sort(Comparator.comparingInt(List::size)); //fajne sortowanko

        /*for (List<Wspolrzedna> thisSciezka : listaSciezek) { //cała lista możliwych ścieżek
            System.out.println(thisSciezka);
        }*/

        System.out.println("Istnieje droga: " + listaSciezek.get(0)); //najkrótsza ścieżka

    }

    public static void idzWKierunku(List<Wspolrzedna> lista, int x, int y) { // można zmienić argumenty metody na (List, Wspolrzedna)
        lista.add(new Wspolrzedna(x, y));

        if (lab[y][x] == 'K') { // jak jestem na końcu to dodaję ścieżkę do listy ścieżek
            listaSciezek.add(lista);
            czyIstnieje = true;
            return;
        }

        List<Wspolrzedna> kierunki = new ArrayList<>(); // lista kierunków

        kierunki.add(new Wspolrzedna(x + 1, y)); // góra
        kierunki.add(new Wspolrzedna(x - 1, y)); // dół
        kierunki.add(new Wspolrzedna(x, y + 1)); // prawo
        kierunki.add(new Wspolrzedna(x, y - 1)); // lewo

        List<Wspolrzedna> kopiaListy = new ArrayList<>(lista);
        for (Wspolrzedna kierunek : kierunki) { // w każdym kierunku
            List<Wspolrzedna> thisSciezka;
            if (czyMogeWykonacRuch(lista, kierunek.x, kierunek.y)) {
                thisSciezka = new ArrayList<>(kopiaListy);
                idzWKierunku(thisSciezka, kierunek.x, kierunek.y);
            }
        }

    }

    public static boolean czyMogeWykonacRuch(List<Wspolrzedna> lista, int x, int y) { //To samo co o metodzie wyżej
        if (lista.contains(new Wspolrzedna(x, y))) { // jeżeli lista zawiera Współrzędną (x,y)
            return false;
        }
        if (x >= 10 || y >= 10 || x < 0 || y < 0) { // czy wychodzi poza tablicę
            return false;
        }
        if (lab[y][x] == '0') { // czy jest == 0
            return false;
        }
        return true;
    }

    public static Wspolrzedna wylosujWspolrzedna() { //metoda zwraca wylosowaną współrzędną
        return new Wspolrzedna(generator.nextInt(10), generator.nextInt(10));
    }
}

//TODO
/*
Zrobić jedną listę w której przechowuję jedną, najkrótszą ścieżkę
Jeśli nowa ścieżka jest krótsza od starej to zastępuję starą i mam nową najkrótszą ścieżkę
 */