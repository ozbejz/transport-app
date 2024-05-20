import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Krizarka extends Ladja{
    private String aktivnosti;
    private String restavracije;
    private String dodatno;

    public Krizarka(){
        super();
        aktivnosti = "";
    }

    public Krizarka(String dO, String uO, String dP, String uP, String kO, String drO, String kP, String drP, double c, int stS, Relacija r, String i, String l, String kr, String re, String dod){
        super(dO, uO, dP, uP, kO, drO, kP, drP, c, stS, r, i, l);
        aktivnosti = kr;
        restavracije = re;
        dodatno = dod;
    }

    public static Krizarka ustvariKrizarko() throws Exception {
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

        System.out.println("aktivnosti: ");
        String aktivnosti = br.readLine();

        System.out.println("restavracije: ");
        String restavracije = br.readLine();

        System.out.println("dodatno: ");
        String dodatno = br.readLine();

        Krizarka k = new Krizarka(datumOdhoda, uraOdhoda, datumPrihoda, uraPrihoda, krajOdhoda, drzavaOdhoda, krajPrihoda, drzavaPrihoda, 
            cenaVozovnice, stSedezev, r, imeLadje, lastnikLadje, aktivnosti, restavracije, dodatno);
        
        return k;
    }

    @Override
    public String toString(){
        String niz = "";
        niz += this.izpisNadrazredaLadja();
        niz += "Aktivnosti: " + this.aktivnosti + "\n";
        niz += "Restavracije: " + this.restavracije + "\n";
        niz += "Dodatno: " + this.dodatno + "\n";

        return niz;
    }

    public String shraniPodatke(){
        String zapis = "KRI\r\n";
        zapis += super.podatkiLadje();
        zapis += this.aktivnosti + "\r\n";
        zapis += this.restavracije + "\r\n";
        zapis += this.dodatno + "\r\n";

        zapis += "##\r\n";

        return zapis;
    }

    public static Krizarka preberiPodatke(ArrayList<String> zapis) throws Exception {
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

        String aktivnosti = zapis.get(18);
        String restavracije = zapis.get(19);
        String dodatno = zapis.get(20);

        Krizarka k = new Krizarka(datumOdhoda, uraOdhoda, datumPrihoda, uraPrihoda, krajOdhoda, drzavaOdhoda, krajPrihoda, drzavaPrihoda, cenaVozovnice, 
            stSedezev, r, imeLadje, lastnik, aktivnosti, restavracije, dodatno);

        return k;
    }
}
