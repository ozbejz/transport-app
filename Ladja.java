import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ladja extends Prevoz{
    private String imeLadje;
    private String lastnik;

    public Ladja(){
        super();
        imeLadje = "";
        lastnik = "";
    }

    public Ladja(String dO, String uO, String dP, String uP, String kO, String drO, String kP, String drP, double c, int stS, Relacija r, String i, String l){
        super(dO, uO, dP, uP, kO, drO, kP, drP, c, stS, r);
        this.imeLadje = i;
        this.lastnik = l;
    }

    public static Ladja ustvariLadjo() throws Exception {
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

        System.out.println("ime ladje: ");
        String imeLadje = br.readLine();

        System.out.println("lastnik ladje: ");
        String lastnikLadje = br.readLine();

        Ladja l = new Ladja(datumOdhoda, uraOdhoda, datumPrihoda, uraPrihoda, krajOdhoda, drzavaOdhoda, krajPrihoda, drzavaPrihoda, cenaVozovnice, stSedezev, r, imeLadje, lastnikLadje);

        return l;
    }
    
    @Override
    public String toString(){
        String niz = "";
        /* 
        niz += "Datum in ura odhoda: " + this.getCenaVozovnice() + ", " + this.getUraOdhoda() + "\n";
        niz += "Datum in ura prihoda: " + this.getDatumPrihoda() + ", " + this.getUraPrihoda() + "\n";
        niz += "Kraj in drazava odhoda: " + this.getKrajOdhoda() + ", " + this.getDrzavaOdhoda() + "\n";
        niz += "Kraj in drzava prihoda: " + this.getKrajPrihoda() + ", " + this.getDrzavaPrihoda() + "\n";
        niz += "Cena vozovnice: " + this.getCenaVozovnice() + "\n";
        niz += "Stevilo sedezev: " + this.getStSedezev() + "\n";*/
        niz += this.izpisNadrazreda();
        niz += "Ime ladje: " + imeLadje + "\n";
        niz += "Lastnik ladje: " + lastnik + "\n";

        return niz;
    }

    public String izpisNadrazredaLadja(){
        String niz = "";
        niz += this.izpisNadrazreda();
        niz += "Ime ladje: " + this.imeLadje + "\r\n";
        niz += "Lastnik ladje: " + this.lastnik + "\r\n";

        return niz;
    }

    public String shraniPodatke(){
        String zapis = "LAD\r\n";
        zapis += super.podatkiPrevoza();
        zapis += this.imeLadje + "\r\n";
        zapis += this.lastnik + "\r\n";

        zapis += "##\r\n";

        return zapis;
    }

    public static Ladja preberiPodatke(ArrayList<String> zapis) throws Exception {
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

        String imeLadje = zapis.get(16);
        String lastnik = zapis.get(17);

        Ladja l = new Ladja(datumOdhoda, uraOdhoda, datumPrihoda, uraPrihoda, krajOdhoda, drzavaOdhoda, krajPrihoda, drzavaPrihoda, cenaVozovnice, stSedezev, r, imeLadje, lastnik);

        return l;
    }

    public String podatkiLadje(){
        String zapis = "";
		zapis += super.podatkiPrevoza();
        zapis += this.imeLadje + "\r\n";
        zapis += this.lastnik + "\r\n";

        return zapis;
    }
}
