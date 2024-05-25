import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Prevoz{
    private String datumOdhoda;
    private String uraOdhoda;
    private String datumPrihoda;
    private String uraPrihoda;
    private String krajOdhoda;
    private String drzavaOdhoda;
    private String krajPrihoda;
    private String drzavaPrihoda;
    private double cenaVozovnice;
    private int stSedezev;
    private int id;
    private int stProdanihVozovnic;
    private Relacija relacija;

    private static int zap = 1;

    public Prevoz(){
        id = zap;
        stProdanihVozovnic = 0;
        zap++;
    }

    public Prevoz(String dO, String uO, String dP, String uP, String kO, String drO, String kP, String drP, double c, int stS, Relacija r){
        datumOdhoda = dO;
        uraOdhoda = uO;
        datumPrihoda = dP;
        uraPrihoda = uP;
        krajOdhoda = kO;
        drzavaOdhoda = drO;
        krajPrihoda = kP;
        drzavaPrihoda = drP;
        cenaVozovnice = c;
        stSedezev = stS;
        id = zap;
        zap++;
        stProdanihVozovnic = 0;
        relacija = r;
    }

    public void setStProdanih(int st){
        stProdanihVozovnic = st;
    }

    public String getDatumOdhoda(){
        return datumOdhoda;
    }

    public String getUraOdhoda(){
        return uraOdhoda;
    }

    public String getDatumPrihoda(){
        return datumPrihoda;
    }

    public String getUraPrihoda(){
        return uraPrihoda;
    }

    public String getKrajOdhoda(){
        return krajOdhoda;
    }

    public String getDrzavaOdhoda(){
        return drzavaOdhoda;
    }

    public String getKrajPrihoda(){
        return krajPrihoda;
    }

    public String getDrzavaPrihoda(){
        return drzavaPrihoda;
    }

    public double getCenaVozovnice(){
        return cenaVozovnice;
    }

    public int getStSedezev(){
        return stSedezev;
    }

    public int getStProdanih(){
        return stProdanihVozovnic;
    }

    public int getId(){
        return id;
    }

    public int getStProstih(){
        return stSedezev - stProdanihVozovnic;
    }

    public void addDatumOdhoda(String dO){
        datumOdhoda = dO;
    }


    public String izpisNadrazreda(){
        String niz = "";
        niz += "Id: " + id + "\n";
        niz += "Datum in ura odhoda: " + datumOdhoda + ", " + uraOdhoda + "\n";
        niz += "Datum in ura prihoda: " + datumPrihoda + ", " + uraPrihoda + "\n";
        niz += "Kraj in drazava odhoda: " + krajOdhoda + ", " + drzavaOdhoda + "\n";
        niz += "Kraj in drzava prihoda: " + krajPrihoda + ", " + drzavaPrihoda + "\n";
        niz += "Cena vozovnice: " + cenaVozovnice + "\n";
        niz += "Stevilo sedezev: " + stSedezev + "\n";
        niz += relacija.RelacijaToString();
        niz += "Stevilo prostih sedezev: " + (stSedezev - stProdanihVozovnic) + "\n";

        return niz;
    }
    
    @Override
    public String toString(){
        String niz = "";
        niz += "Id: " + id + "\n";
        niz += "Datum in ura odhoda: " + datumOdhoda + ", " + uraOdhoda + "\n";
        niz += "Datum in ura prihoda: " + datumPrihoda + ", " + uraPrihoda + "\n";
        niz += "Kraj in drazava odhoda: " + krajOdhoda + ", " + drzavaOdhoda + "\n";
        niz += "Kraj in drzava prihoda: " + krajPrihoda + ", " + drzavaPrihoda + "\n";
        niz += "Cena vozovnice: " + cenaVozovnice + "\n";
        niz += "Stevilo sedezev: " + stSedezev + "\n";
        niz += relacija.RelacijaToString();
        niz += "Stevilo prostih sedezev: " + (stSedezev - stProdanihVozovnic) + "\n";

        return niz;
    }

    public static Prevoz ustvariPrevoz() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("datum odhoda: ");
        String datumOdhoda = br.readLine().trim();

        System.out.println("ura odhoda: ");
        String uraOdhoda = br.readLine().trim();

        System.out.println("datm prihoda: ");
        String datumPrihoda = br.readLine().trim();

        System.out.println("ura prihoda: ");
        String uraPrihoda = br.readLine().trim();

        System.out.println("kraj odhoda: ");
        String krajOdhoda = br.readLine().trim();

        System.out.println("drzava odhoda: ");
        String drzavaOdhoda = br.readLine().trim();

        System.out.println("kraj prihoda: ");
        String krajPrihoda = br.readLine().trim();

        System.out.println("drzava prihoda: ");
        String drzavaPrihoda = br.readLine().trim();

        System.out.println("cena vozovnice: ");
        double cenaVozovnice = Double.parseDouble(br.readLine().trim());

        System.out.println("stevilo sedezev: ");
        int stSedezev = Integer.parseInt(br.readLine().trim());

        Relacija r = Relacija.ustvariRelacija();

        Prevoz p = new Prevoz(datumOdhoda, uraOdhoda, datumPrihoda, uraPrihoda, krajOdhoda, drzavaOdhoda, krajPrihoda, drzavaPrihoda, cenaVozovnice, stSedezev, r);

        return p;
    }

    public String shraniPodatke(){
        String zapis = "PRE\r\n";
		zapis += this.datumOdhoda + "\r\n";
		zapis += this.uraOdhoda + "\r\n";
		zapis += this.datumPrihoda + "\r\n";
        zapis += this.uraPrihoda + "\r\n";
        zapis += this.krajOdhoda + "\r\n";
        zapis += this.drzavaOdhoda + "\r\n";
        zapis += this.krajPrihoda + "\r\n";
        zapis += this.drzavaPrihoda + "\r\n";
        zapis += this.cenaVozovnice + "\r\n";
        zapis += this.stSedezev + "\r\n";
        zapis += this.id + "\r\n";
        zapis += this.stProdanihVozovnic + "\r\n";

        zapis += this.relacija.shraniPodatke();

        zapis += "##\r\n";

        return zapis;
    }

    public String podatkiPrevoza(){
        String zapis = "";
		zapis += this.datumOdhoda + "\r\n";
		zapis += this.uraOdhoda + "\r\n";
		zapis += this.datumPrihoda + "\r\n";
        zapis += this.uraPrihoda + "\r\n";
        zapis += this.krajOdhoda + "\r\n";
        zapis += this.drzavaOdhoda + "\r\n";
        zapis += this.krajPrihoda + "\r\n";
        zapis += this.drzavaPrihoda + "\r\n";
        zapis += this.cenaVozovnice + "\r\n";
        zapis += this.stSedezev + "\r\n";
        zapis += this.id + "\r\n";
        zapis += this.stProdanihVozovnic + "\r\n";

        zapis += this.relacija.shraniPodatke();

        return zapis;
    }

    
    public static Prevoz preberiPodatke(ArrayList<String> zapis) throws Exception {
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

        Prevoz p = new Prevoz(datumOdhoda, uraOdhoda, datumPrihoda, uraPrihoda, krajOdhoda, drzavaOdhoda, krajPrihoda, drzavaPrihoda, cenaVozovnice, stSedezev, r);

        return p;
    }
}