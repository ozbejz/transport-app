import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Vlak extends Prevoz{
    private String prevoznik;
    private int stVlaka;

    public Vlak(){
        prevoznik = "";
        stVlaka = 0;
    }

    public Vlak(String dO, String uO, String dP, String uP, String kO, String drO, String kP, String drP, double c, int stS, String p, int s){
        super(dO, uO, dP, uP, kO, drO, kP, drP, c, stS);
        prevoznik = p;
        stVlaka = s;
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

        System.out.println("prevoznik: ");
        String prevoznik = br.readLine();

        System.out.println("stevilka vlaka: ");
        int stVlaka = Integer.parseInt(br.readLine());

        Vlak v = new Vlak(datumOdhoda, uraOdhoda, datumPrihoda, uraPrihoda, krajOdhoda, drzavaOdhoda, krajPrihoda, drzavaPrihoda, cenaVozovnice, stSedezev, prevoznik, stVlaka);
        
        return v;
    }

    @Override
    public String toString(){
        String niz = "";
        niz += "Datum in ura odhoda: " + this.getCenaVozovnice() + ", " + this.getUraOdhoda() + "\n";
        niz += "Datum in ura prihoda: " + this.getDatumPrihoda() + ", " + this.getUraPrihoda() + "\n";
        niz += "Kraj in drazava odhoda: " + this.getKrajOdhoda() + ", " + this.getDrzavaOdhoda() + "\n";
        niz += "Kraj in drzava prihoda: " + this.getKrajPrihoda() + ", " + this.getDrzavaPrihoda() + "\n";
        niz += "Cena vozovnice: " + this.getCenaVozovnice() + "\n";
        niz += "Stevilo sedezev: " + this.getStSedezev() + "\n";
        niz += "Prevoznik: " + prevoznik + "\n";
        niz += "Stevilka vlaka: " + stVlaka + "\n";

        return niz;
    }
}
