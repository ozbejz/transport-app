import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Letalo extends Prevoz {
    protected int stLetala;

    public Letalo(){

    }

    public Letalo(String dO, String uO, String dP, String uP, String kO, String drO, String kP, String drP, double c, int stS, int stL){
        super(dO, uO, dP, uP, kO, drO, kP, drP, c, stS);
        stLetala = stL;
    }

    public int getStLetala(){
        return stLetala;
    }

    public static Letalo ustvariLetalo() throws Exception {
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

        System.out.println("stevilo letala: ");
        int stLetala = Integer.parseInt(br.readLine());

        Letalo l = new Letalo(datumOdhoda, uraOdhoda, datumPrihoda, uraPrihoda, krajOdhoda, drzavaOdhoda, krajPrihoda, drzavaPrihoda, cenaVozovnice, stSedezev, stLetala);

        return l;
    }

    public String izpisNadrazreda(){
        String niz = "";
        niz += this.izpisNadrazreda();
        niz += "Stevilka letala: " + stLetala + "\n";
        return niz;
    }

    @Override
    public String toString(){
        String niz = "";
        niz += this.izpisNadrazreda();
        niz += "Stevilka letala: " + stLetala + "\n";

        return niz;
    }
}
