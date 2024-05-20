import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Letalo extends Prevoz {
    private int stLetala;
    private String proizvajalec;

    public Letalo(){

    }

    public Letalo(String dO, String uO, String dP, String uP, String kO, String drO, String kP, String drP, double c, int stS, Relacija r, int stL, String pro){
        super(dO, uO, dP, uP, kO, drO, kP, drP, c, stS, r);
        stLetala = stL;
        proizvajalec = pro;
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

        Relacija r = Relacija.ustvariRelacija();

        System.out.println("stevilo letala: ");
        int stLetala = Integer.parseInt(br.readLine());

        System.out.println("proizvajalec: ");
        String pr = br.readLine();

        Letalo l = new Letalo(datumOdhoda, uraOdhoda, datumPrihoda, uraPrihoda, krajOdhoda, drzavaOdhoda, krajPrihoda, drzavaPrihoda, cenaVozovnice, stSedezev, r, stLetala, pr);

        return l;
    }

    public String izpisNadrazredaLetalo(){
        String niz = "";
        niz += this.izpisNadrazreda();
        niz += "Stevilka letala: " + stLetala + "\n";
        niz += "Proizvajalec: " + proizvajalec + "\n";
        return niz;
    }

    @Override
    public String toString(){
        String niz = "";
        niz += this.izpisNadrazreda();
        niz += "Stevilka letala: " + stLetala + "\n";
        niz += "Proizvajalec: " + proizvajalec + "\n";

        return niz;
    }

    public String shraniPodatke(){
        String zapis = "LET\r\n";
        zapis += super.podatkiPrevoza();
        zapis += this.stLetala + "\r\n";
        zapis += this.proizvajalec + "\r\n";

        zapis += "##\r\n";
        
        return zapis;
    }

    public static Letalo preberiPodatke(ArrayList<String> zapis) throws Exception {
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

        int stLetala = Integer.parseInt(zapis.get(16));
        String proizvajalec = zapis.get(17);

        Letalo l = new Letalo(datumOdhoda, uraOdhoda, datumPrihoda, uraPrihoda, krajOdhoda, drzavaOdhoda, krajPrihoda, drzavaPrihoda, cenaVozovnice, 
            stSedezev, r, stLetala, proizvajalec);

        return l;
    }

    public String podatkiLetala(){
        String zapis = "";
		zapis += super.podatkiPrevoza();
        zapis += this.stLetala + "\r\n";
        zapis += this.proizvajalec + "\r\n";

        return zapis;
    }
}
