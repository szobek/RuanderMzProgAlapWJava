import java.util.Random;
import java.util.Scanner;

public class Main {

    /*
    A program funkciói
1. A program indulás után kérdezze meg, hány filmet játszik a mozi a héten. A
számot ellenőrzött módon kérje be. Ez a szám legyen egy Film struktúra típussal korábban
deklarált tömb elemszáma.
. Az ellenőrzés formai (szám-e) és logikai (3-nál nagyobb) legyen!
2. Kérje be az egyes filmek adatait, szintén ellenőrzötten, ameddig megfelelő adatot nem kap.
A helyes adatokat töltse be a tömbbe.
. A film címe nem lehet üres (legalább 2 karakter).
. A szinkronizált filmeket true, míg a feliratosakat false értékkel kell eltárolni.
. Az ár minimuma 1000, maximuma 3500 Ft lehet.
3. A program írja ki a konzolra, hogy hány filmnek az ára van 2200 Ft alatt.
4. Írja ki a konzolra az első, 2500 Ft-nál drágább árú film minden adatát. Ha nincs ilyen, akkor
arról is küldjön üzenetet.
5. Listázza ki először a szinkronos, majd a feliratos filmek adatait. Mind a két esetben a filmcím
és zárójelben az ár jelenjen meg,” Ft” felirattal ellátva.
6. Írja ki, milyen átlagárra számítson az, aki minden filmet meg akar nézni!
     */
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        String filmtombHossz = "";
        int tombHossz = 0;
        do {
            System.out.print("Mennyi film lesz a héten? ");
            filmtombHossz = scanner.nextLine();
        } while (!isGoodNum(filmtombHossz,3,2500000));
        System.out.println(Integer.parseInt(filmtombHossz));
        tombHossz = Integer.parseInt(filmtombHossz);
        Film[] filmek = new Film[tombHossz];
        tombFelToltes(filmek);
        lista(filmek);
        System.out.println();
        System.out.println();
        System.out.println();
        olcsoFilmek(filmek);
        System.out.println();
        System.out.println();
        System.out.println();
        elsoDraga(filmek);
        System.out.println();
        System.out.println();
        System.out.println("szinkronos fimek:");
        szinkronSzerintiLista(filmek,true);
        System.out.println();
        System.out.println("Feliratos filmek");
        szinkronSzerintiLista(filmek,false);
        System.out.println();
        System.out.println();
        System.out.println();
        atlagAr(filmek);
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

    public static boolean isGoodNum(String szoveg,int min,int max) {
        boolean nagyobb = false;
        int szam = 0;
        if (stringSzame(szoveg)) {
            szam = Integer.parseInt(szoveg);
        }
        if (szam >= min && szam<=max) {
            nagyobb = true;
        }
        return nagyobb;
    }


    static void tombFelToltes(Film[] filmek) {
        for (int i = 0; i < filmek.length; i++) {
            Film film = new Film(setArToFilm(), setFilmCimToFilm(), setFeliratToFilm());
            filmek[i] = film;
        }

    }

    static private String setFilmCimToFilm() {
//        String cim = "asfer lki"+random.nextInt(1,2000)+random.nextInt(1,3000);
        /*
        do {
            System.out.print("Adja meg a film címét:");
            cim = scanner.nextLine();
        } while (cim.equals(""));

         */
        return randomCim();
    }

    private static void atlagAr(Film[] filmek) {
double osszes = 0,atlag;
        for (Film elem : filmek) {
            osszes += elem.getAr();
        }
        atlag=osszes/filmek.length;
        System.out.println("Az átlagár: "+atlag);


    }

    static private void lista(Film[] filmek) {
        for (Film elem : filmek) {
            System.out.println(elem.getCim()+((elem.isFeliratos())? " feliratos ":" szinkronos ")+elem.getAr()+"ft");
        }
    }

    static private boolean setFeliratToFilm(){
        boolean feliratosFilm;
        /*
        char felirat;
        do{
            System.out.print("A film feliratos? (i/n)");
            felirat = scanner.nextLine().charAt(0);

        }while (felirat!='i' &&felirat!='n');
        switch (felirat){
            case 'i'->feliratosFilm=true;
            case 'n' ->feliratosFilm=false;
            default -> feliratosFilm=false;
        }

         */
        return random.nextBoolean();
    }

    static private int setArToFilm(){
        String filmAra;
        int ar;
        /*
        do{
            System.out.print("A film ára? (1000-3500)");
filmAra=scanner.nextLine();
        }while (!isGoodNum(filmAra,1000,3500));
        ar=Integer.parseInt(filmAra);
         */

ar = random.nextInt(1001,3500);
        return ar;
    }

    static private void olcsoFilmek(Film[] filmek){
        int osszesOlcso = 0;
        for (Film elem : filmek) {
            if(elem.getAr()<2200){
                osszesOlcso++;
            }
        }
        System.out.println("A 2200 alatti filmek száma: "+osszesOlcso);
    }

    static private void elsoDraga(Film[] filmek){
        int i=0;
        String filmAdat = "aa";
        System.out.println(" az első 2500-nál drágább film: ");
        while (i<filmek.length&&filmek[i].getAr()<2500){

            i++;
        }
        filmAdat+=filmek[i].getCim()+((filmek[i].isFeliratos())? " feliratos ":" szinkronos ")+filmek[i].getAr()+"ft";
        if(i<filmek.length){
            System.out.println(filmAdat);
        }else {
            System.out.println("nincs a keresett film!");
        }

    }

    static private void szinkronSzerintiLista(Film[] filmek, boolean szinkron){
        for (Film elem : filmek) {
            if((szinkron&&!elem.isFeliratos()) || (!szinkron&&elem.isFeliratos())) {
                System.out.println(elem.getCim() + ((elem.isFeliratos()) ? " feliratos " : " szinkronos ") + elem.getAr() + "ft");
            }
        }

    }

    static private String randomCim(){
        String abc = "abcdefghijlmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder cim=new StringBuilder("");
        for(int i=0;i< random.nextInt(50);i++){
            cim.append(abc.charAt(random.nextInt(abc.length())));
        }
        return cim.toString();
    }

}
