import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n;

        System.out.println("Podaj liczbę naturalną: ");

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // podana przez użytkowika liczba naturalna

        System.out.println(fun(n));

    }

    public static int fun(int n) { //funkcja wylicza n-ty wyraz ciągu fibonacciego
        int wynik;

        int[][] tab = {{1, 1}, {1, 0}};

        if (n == 0) { //jak 0-owy wyraz to 0
            return 0;
        } else if (n == 1 || n == 2) { //tak samo; jak 1-szy lub 2-gi wyraz to 1
            return 1;
        }

        //jak inny wyraz niż 0 v 1 v 2 to potęgujemy macierz początkową (n-1) razy
        potegowanie(tab, n - 1);

        wynik = tab[0][0];
        return wynik;
    }

    public static void potegowanie(int[][] tab, int wykladnik) { //funkcja do szybkiego potęgowania macierzy
        if (wykladnik == 0 || wykladnik == 1) //do potęgi 0 v 1 wynik t
            return;

        int[][] tmp = {{1, 1}, {1, 0}}; //tablica pomocnicza
        potegowanie(tab, wykladnik / 2); //potęguję macierz do n/2 (bo np tab^n = tab^(n/2)*tab^2 dla n parzystych),
        //a łatwiej jest liczyć mnniejsze potęgi (i szybciej) [algorytm Karacuby]
        mnozenie(tab, tab);

        if (wykladnik % 2 != 0) { //jak wykladnik jest nieparzysty to trzeba pomnożyć jeszcze przez tabelę pierwotną ({1,1}{1,0})
            mnozenie(tab, tmp);
        }
    }

    public static void mnozenie(int[][] tab, int[][] pom) { //funkcja do mnożenia macierzy (wierszTAB*kolumnaPOM itd)
        int h = tab[0][0] * pom[0][0] + tab[0][1] * pom[1][0];
        int j = tab[0][0] * pom[0][1] + tab[0][1] * pom[1][1];
        int k = tab[1][0] * pom[0][0] + tab[1][1] * pom[1][0];
        int l = tab[1][0] * pom[0][1] + tab[1][1] * pom[1][1];

        tab[0][0] = h;
        tab[0][1] = j;
        tab[1][0] = k;
        tab[1][1] = l;
    }
}