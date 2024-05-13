import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Krizarka extends Ladja{
    private String ime;

    public Krizarka(){
        super();
        ime = "";
    }

    public Krizarka(String dO, String uO, String dP, String uP, String kO, String drO, String kP, String drP, double c, int stS, String i, String l, String kr){
        super(dO, uO, dP, uP, kO, drO, kP, drP, c, stS, i, l);
        ime = kr;
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

        System.out.println("ime ladje: ");
        String imeLadje = br.readLine();

        System.out.println("lastnik ladje: ");
        String lastnikLadje = br.readLine();

        System.out.println("krizarka: ");
        String krizarka = br.readLine();

        Krizarka k = new Krizarka(datumOdhoda, uraOdhoda, datumPrihoda, uraPrihoda, krajOdhoda, drzavaOdhoda, krajPrihoda, drzavaPrihoda, cenaVozovnice, stSedezev, imeLadje, lastnikLadje, krizarka);
        
        return k;
    }

    @Override
    public String toString(){
        String niz = "";
        niz += this.izpisNadrazreda();
        niz += "Krizarka: " + this.ime + "\n";

        return niz;
    }
}
