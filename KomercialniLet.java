import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class KomercialniLet extends Letalo{
    private String letalskaDruzba;
    public RazredKabine razred;

    public KomercialniLet(){
        letalskaDruzba = "";
    }

    public KomercialniLet(String dO, String uO, String dP, String uP, String kO, String drO, String kP, String drP, double c, int stS, 
        Relacija r, int stL, String pro, String ld, RazredKabine rk){
        super(dO, uO, dP, uP, kO, drO, kP, drP, c, stS, r, stL, pro);
        letalskaDruzba = ld;
        razred = rk;
    }

    public static KomercialniLet ustvariKomercialniLet() throws Exception{
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

        System.out.println("letalska druzba: ");
        String letalskaDruzba = br.readLine();

        RazredKabine rk = RazredKabine.ustvariRazredKabine();

        KomercialniLet kl = new KomercialniLet(datumOdhoda, uraOdhoda, datumPrihoda, uraPrihoda, krajOdhoda, drzavaOdhoda, krajPrihoda, drzavaPrihoda, cenaVozovnice, 
            stSedezev, r, stLetala, pr, letalskaDruzba, rk);

        return kl;
    }

    @Override
    public String toString(){
        String niz = "";
        niz += this.izpisNadrazredaLetalo();
        niz += "Letalska druzba: " + letalskaDruzba + "\n";
        niz += razred.RazredKabineToString();

        return niz;
    }

    public String shraniPodatke(){
        String zapis = "KOM\r\n";
        zapis += super.podatkiLetala();
        zapis += this.letalskaDruzba + "\n";

        zapis += this.razred.shraniPodatke();

        zapis += "##\r\n";
        
        return zapis;
    }

    public static KomercialniLet preberiPodatke(ArrayList<String> zapis) throws Exception {
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

        String druzba = zapis.get(18);

        ArrayList<String> razPodatki = new ArrayList<>();
        razPodatki.add(zapis.get(20));
        razPodatki.add(zapis.get(21));
        razPodatki.add(zapis.get(22));

        RazredKabine raz = RazredKabine.preberiPodatke(razPodatki);

        KomercialniLet kl = new KomercialniLet(datumOdhoda, uraOdhoda, datumPrihoda, uraPrihoda, krajOdhoda, drzavaOdhoda, krajPrihoda, drzavaPrihoda, cenaVozovnice, 
            stSedezev, r, stLetala, proizvajalec, druzba, raz);

        return kl;
    }
}
