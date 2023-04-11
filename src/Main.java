import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String filmtombHossz = "";
        int tombHossz = 0;
        do {
            System.out.print("Mennyi film lesz a héten? ");
            filmtombHossz = scanner.nextLine();
        } while (!isNumMethod(filmtombHossz));
        System.out.println(Integer.parseInt(filmtombHossz));
        tombHossz = Integer.parseInt(filmtombHossz);
        Film[] filmek = new Film[tombHossz];
        tombFelToltes(filmek);
    }

    static boolean stringSzame(String szoveg) {
        boolean parsolhato = true;
        boolean[] szam = new boolean[szoveg.length()];
        for (int i = 0; i < szoveg.length(); i++) {
            if (Character.isDigit(szoveg.charAt(i))) {
                szam[i] = true;
            }
        }

        for (boolean elem : szam) {
            if (!elem) {
                parsolhato = false;
            }
        }
        return parsolhato;
    }

    public static boolean isGoodNum(String szoveg) {
        boolean nagyobb = false;
        int szam = 0;
        if (stringSzame(szoveg)) {
            szam = Integer.parseInt(szoveg);
        }
        if (szam > 3) {
            nagyobb = true;
        }
        return nagyobb;
    }

    static boolean isNumMethod(String szoveg) {
        boolean isNum,isGreater = false;
        try {
            Integer.parseInt(szoveg);
            isNum = true;
        } catch (Exception e) {
            isNum = false;
        }
        if(isNum && Integer.parseInt(szoveg)>3){
                isGreater=true;
        }
        return isGreater;
    }

    static void tombFelToltes(Film[] filmek) {
        for (int i = 0; i < filmek.length; i++) {
            Film film = new Film(15, setFilmCimToFilm(), setFeliratToFilm());
            filmek[i] = film;
        }
        System.out.println();
        System.out.println();
        System.out.println();
         lista(filmek);
    }

    static private String setFilmCimToFilm() {
        String cim = "";
        do {
            System.out.print("Adja meg a film címét:");
            cim = scanner.nextLine();
        } while (cim.equals(""));
        return cim;
    }

    private void atlagAr() {

    }

    static private void lista(Film[] filmek) {
        for (Film elem : filmek) {
            System.out.println(elem.getCim()+((elem.isFeliratos())? " feliratos":" szinkronos"));
        }
    }

    static private boolean setFeliratToFilm(){
        boolean feliratosFilm=false;
        char felirat;
        do{
            System.out.print("A film feliratos? (i/n)");
            felirat = scanner.nextLine().charAt(0);

        }while (felirat!='i' &&felirat!='n');
        switch (felirat){
            case 'i'->feliratosFilm=true;
            case 'n' ->feliratosFilm=false;
        }
        return feliratosFilm;
    }

}
