import java.io.*;
import java.util.*;

public class Avtobus extends Prevoz{
    private String prevoznik;
    private int stAvtobusa;

    public Avtobus(){
        super();

        Scanner sc = new Scanner(System.in);

        System.out.println("prevoznik: ");
        prevoznik = sc.nextLine().trim();

        System.out.println("stevilka avtobusa: ");
        stAvtobusa = sc.nextInt();
    }

    public Avtobus(String dO, String uO, String dP, String uP, String kO, String drO, String kP, String drP, double c, int stS, Relacija r, String p, int s){
        super(dO, uO, dP, uP, kO, drO, kP, drP, c, stS, r);
        prevoznik = p;
        stAvtobusa = s;
    }

    public static Avtobus ustvariAvtobus() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("datum odhoda: ");
        String datumOdhoda = br.readLine().trim();

        System.out.println("ura odhoda: ");
        String uraOdhoda = br.readLine().trim();

        System.out.println("datm prihoda: ");
        String datumPrihoda = br.readLine().trim();

        System.out.println("ura prihoda: ");
        String uraPrihoda = br.readLine().trim();

        System.out.println("kraj odhoda: ");
        String krajOdhoda = br.readLine().trim();

        System.out.println("drzava odhoda: ");
        String drzavaOdhoda = br.readLine().trim();

        System.out.println("kraj prihoda: ");
        String krajPrihoda = br.readLine().trim();

        System.out.println("drzava prihoda: ");
        String drzavaPrihoda = br.readLine().trim();

        System.out.println("cena vozovnice: ");
        double cenaVozovnice = Integer.parseInt(br.readLine().trim());

        System.out.println("stevilo sedezev: ");
        int stSedezev = Integer.parseInt(br.readLine().trim());

        Relacija r = Relacija.ustvariRelacija();

        System.out.println("avtobusni prevoznik: ");
        String prevoznik = br.readLine().trim();

        System.out.println("stevilka avtobusa: ");
        int stAvtobusa = Integer.parseInt(br.readLine().trim());

        Avtobus a = new Avtobus(datumOdhoda, uraOdhoda, datumPrihoda, uraPrihoda, krajOdhoda, drzavaOdhoda, krajPrihoda, drzavaPrihoda, cenaVozovnice, stSedezev, r, prevoznik, stAvtobusa);
        return a;   
    }

    @Override
    public String toString(){
        String niz = "";
        niz += this.izpisNadrazreda();
        niz += "Avtobusni prevoznik: " + prevoznik + "\n";
        niz += "Stevilka avtobusa: " + stAvtobusa + "\n";

        return niz;
    }

    public String shraniPodatke(){
        String zapis = "AVT\r\n";
        zapis += super.podatkiPrevoza();
        zapis += this.prevoznik + "\r\n";
        zapis += this.stAvtobusa + "\r\n";

        zapis += "##\r\n";
        
        return zapis;
    }

    public static Avtobus preberiPodatke(ArrayList<String> zapis) throws Exception {
        String datumOdhoda = zapis.get(0);
        String uraOdhoda = zapis.get(1);
        String datumPrihoda = zapis.get(2);
        String uraPrihoda = zapis.get(3);
        String krajOdhoda = zapis.get(4);
        String drzavaOdhoda = zapis.get(5);
        String krajPrihoda = zapis.get(6);
        String drzavaPrihoda = zapis.get(7);
        double cenaVozovnice = Double.parseDouble(zapis.get(8));
        int stSedezev = Integer.parseInt(zapis.get(9));

        ArrayList<String> relPodatki = new ArrayList<>();
        relPodatki.add(zapis.get(13));
        relPodatki.add(zapis.get(14));

        Relacija r = Relacija.preberiPodatke(relPodatki);

        String prevoznik = zapis.get(16);
        int stAvtobusa = Integer.parseInt(zapis.get(17));

        Avtobus a = new Avtobus(datumOdhoda, uraOdhoda, datumPrihoda, uraPrihoda, krajOdhoda, drzavaOdhoda, krajPrihoda, drzavaPrihoda, cenaVozovnice, stSedezev, r, prevoznik, stAvtobusa);

        return a;
    }
}
