import java.io.BufferedReader;
import java.io.InputStreamReader;

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
        String krizarka = br.readLine();

        System.out.println("restavracije: ");
        String restavracije = br.readLine();

        System.out.println("dodatno: ");
        String dodatno = br.readLine();

        Krizarka k = new Krizarka(datumOdhoda, uraOdhoda, datumPrihoda, uraPrihoda, krajOdhoda, drzavaOdhoda, krajPrihoda, drzavaPrihoda, 
            cenaVozovnice, stSedezev, r, imeLadje, lastnikLadje, krizarka, restavracije, dodatno);
        
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
}
