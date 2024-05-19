import java.io.BufferedReader;
import java.io.InputStreamReader;

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
}
