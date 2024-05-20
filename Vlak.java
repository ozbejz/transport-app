import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Vlak extends Prevoz{
    private String prevoznik;
    private int stVlaka;
    private RazredVagona razred;

    public Vlak(){
        prevoznik = "";
        stVlaka = 0;
    }

    public Vlak(String dO, String uO, String dP, String uP, String kO, String drO, String kP, String drP, double c, int stS, String p, int s, RazredVagona rv, Relacija r){
        super(dO, uO, dP, uP, kO, drO, kP, drP, c, stS, r);
        prevoznik = p;
        stVlaka = s;
        razred = rv;
    }

    public static Vlak ustvariVlak() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("datum odhoda: ");
        String datumOdhoda = br.readLine();

        System.out.println("ura odhoda: ");
        String uraOdhoda = br.readLine();

        System.out.println("datm prihoda: ");
        String datumPrihoda = br.readLine();

        System.out.println("ura prihoda: ");
        String uraPrihoda = br.readLine();

        System.out.println("kraj odhoda: ");
        String krajOdhoda = br.readLine();

        System.out.println("drzava odhoda: ");
        String drzavaOdhoda = br.readLine();

        System.out.println("kraj prihoda: ");
        String krajPrihoda = br.readLine();

        System.out.println("drzava prihoda: ");
        String drzavaPrihoda = br.readLine();

        System.out.println("cena vozovnice: ");
        double cenaVozovnice = Integer.parseInt(br.readLine());

        System.out.println("stevilo sedezev: ");
        int stSedezev = Integer.parseInt(br.readLine());

        Relacija r = Relacija.ustvariRelacija();

        System.out.println("prevoznik: ");
        String prevoznik = br.readLine();

        System.out.println("stevilka vlaka: ");
        int stVlaka = Integer.parseInt(br.readLine());

        RazredVagona rv = RazredVagona.ustvariRazredVagona();

        Vlak v = new Vlak(datumOdhoda, uraOdhoda, datumPrihoda, uraPrihoda, krajOdhoda, drzavaOdhoda, krajPrihoda, drzavaPrihoda, cenaVozovnice, stSedezev, prevoznik, stVlaka, rv, r);
        
        return v;
    }

    @Override
    public String toString(){
        String niz = "";
        niz += this.izpisNadrazreda();
        niz += "Prevoznik: " + prevoznik + "\n";
        niz += "Stevilka vlaka: " + stVlaka + "\n";
        niz += razred.RazredVagonaToString();

        return niz;
    }

    public String shraniPodatke(){
        String zapis = "VLA\r\n";
        zapis += super.podatkiPrevoza();
        zapis += this.prevoznik + "\r\n";
        zapis += this.stVlaka + "\r\n";

        zapis += this.razred.shraniPodatke();

        zapis += "##\r\n";
        
        return zapis;
    }

    public static Vlak preberiPodatke(ArrayList<String> zapis) throws Exception {
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
        int stVlaka = Integer.parseInt(zapis.get(17));

        ArrayList<String> razPodatki = new ArrayList<>();
        razPodatki.add(zapis.get(19));
        razPodatki.add(zapis.get(20));
        razPodatki.add(zapis.get(21));

        RazredVagona raz = RazredVagona.preberiPodatke(razPodatki);

        Vlak v = new Vlak(datumOdhoda, uraOdhoda, datumPrihoda, uraPrihoda, krajOdhoda, drzavaOdhoda, krajPrihoda, drzavaPrihoda, cenaVozovnice,
            stSedezev, prevoznik, stVlaka, raz, r);

        return v;
    }
}
