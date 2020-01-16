public class Main {
    public static void main(String[] args) {
        int[] ciag = {2,3,3,6,7,1,0,0,3,8,15}; //5;21
        /*{65,87,47,5,12,74,25,32,78,44,40,77,85,4,29,57,55,79,31,63,84,66,62,41,52,
                36,82,86,6,98,63,65,14,57,75,14,74,15,41,88,27,75,6,78,98,78,22,77,68,74,92,47,
                30,44,40,52,70,66,17,60,47,97,34,37,23,69,56,57,3,45,7,76,18,35,24,73,47,77,1,
                84,92,54,18,98,84,36,66,71,92,13,77,28,75,24,46,67,4,63,82,1}; //dla tego wyjście - dł: 4, suma: 253

        dla {8,4,2,3,2} wyjście - dł: 3, suma: 14 (8,4,2)
        dla {1,1,7,3,2,0,0,4,5,5,6,2,1} wyjście - dł: 6, suma: 20 (0,0,4,5,5,6)

        */

        int liczba,
                nastepnaLiczba,
                dlugoscAktualnegoCiagu = 1,
                sumaAktualnegoCiagu = 0,
                sumaDodatkowa = 0,
                dlugoscDodatkowa = 1,
                dlugoscNajdluzszegoCiagu = dlugoscAktualnegoCiagu,
                sumaNajdluzszegoCiagu = 0;

        boolean staly = false,
                nierosnacy = false,
                niemalejacy = false;

        for (int i = 1; i < ciag.length; i++) {//dopoki ciag wejsciowych liczb sie nie skonczy
            liczba = ciag[i - 1];
            nastepnaLiczba = ciag[i];

            if (nastepnaLiczba == liczba) { //podciąg stały
                staly = true;
                //nierosnacy = false;
                //niemalejacy = false;

                if (i == 1) { //jak zaczynamy pętlę to wstawiamy początkowe wartości z tablicy
                    sumaAktualnegoCiagu = liczba + nastepnaLiczba;
                    dlugoscAktualnegoCiagu = 2;
                } else {
                    sumaAktualnegoCiagu += nastepnaLiczba;
                    dlugoscAktualnegoCiagu++;
                }

                //zmienne do doliczania stałych "części" podciągu do długości i sumy
                dlugoscDodatkowa++;
                sumaDodatkowa = dlugoscDodatkowa * nastepnaLiczba;
            }
            else if (nastepnaLiczba > liczba) { //podciąg niemalejący (rosnący lub stały)
                nierosnacy = false;
                if (niemalejacy) { //po prostu "dolicza" do długości i sumy podciągu w takim przypadku (gdy już był rosnący)
                    dlugoscAktualnegoCiagu++;
                    sumaAktualnegoCiagu += nastepnaLiczba;
                    staly = false;
                } else { //jak podciąg rozpoczyna być niemalejący
                    niemalejacy = true;

                    if (dlugoscAktualnegoCiagu > dlugoscNajdluzszegoCiagu) { //jak podciąg był nierosnący to sprawdzam czy ten podciąg był tym najdłuższym
                        dlugoscNajdluzszegoCiagu = dlugoscAktualnegoCiagu;
                        sumaNajdluzszegoCiagu = sumaAktualnegoCiagu;
                    }

                    if (staly) { //jak był stały, to trzeba doliczyć jego dlugoscDodatkowa i sumaDodatkowa
                        staly = false;
                        sumaAktualnegoCiagu = sumaDodatkowa + nastepnaLiczba;
                        dlugoscAktualnegoCiagu = dlugoscDodatkowa + 1;
                        dlugoscDodatkowa = 1;
                        sumaDodatkowa = 0;
                    } else { //jak nie, to zeruję długość, a potem nadaję nowe wartości długości i sumie
                        dlugoscAktualnegoCiagu = 1;
                        dlugoscAktualnegoCiagu++;
                        sumaAktualnegoCiagu = liczba + nastepnaLiczba;
                        sumaDodatkowa = 0;
                        dlugoscDodatkowa = 1;
                    }
                }
            }
            else if (nastepnaLiczba < liczba) { //podciąg nierosnący (malejący lub stały)
                niemalejacy = false;
                if (nierosnacy) { //po prostu "dolicza" do długości i sumy podciągu w takim przypadku (gdy już był rosnący)
                    dlugoscAktualnegoCiagu++;
                    sumaAktualnegoCiagu += nastepnaLiczba;
                    staly = false;
                } else { //jak podciąg rozpoczyna być niemalejący
                    nierosnacy = true;

                    if (dlugoscAktualnegoCiagu > dlugoscNajdluzszegoCiagu) { //jak podciąg był nierosnący to sprawdzam czy ten podciąg był tym najdłuższym
                        dlugoscNajdluzszegoCiagu = dlugoscAktualnegoCiagu;
                        sumaNajdluzszegoCiagu = sumaAktualnegoCiagu;
                    }

                    if (staly) { //jak był stały, to trzeba doliczyć jego dlugoscDodatkowa i sumaDodatkowa
                        staly = false;
                        sumaAktualnegoCiagu = sumaDodatkowa + nastepnaLiczba;
                        dlugoscAktualnegoCiagu = dlugoscDodatkowa + 1;
                        dlugoscDodatkowa = 1;
                        sumaDodatkowa = 0;
                    } else { //jak nie, to zeruję długość, a potem nadaję nowe wartości długości i sumie
                        dlugoscAktualnegoCiagu = 1;
                        dlugoscAktualnegoCiagu++;
                        sumaAktualnegoCiagu = liczba + nastepnaLiczba;
                        sumaDodatkowa = 0;
                        dlugoscDodatkowa = 1;
                    }
                }
            }
        }

        if (dlugoscAktualnegoCiagu > dlugoscNajdluzszegoCiagu) {
            dlugoscNajdluzszegoCiagu = dlugoscAktualnegoCiagu;
            sumaNajdluzszegoCiagu = sumaAktualnegoCiagu;
        }

        System.out.println("Najdłuższy podciąg: " + dlugoscNajdluzszegoCiagu + ", jego suma: " + sumaNajdluzszegoCiagu);
    }
}
