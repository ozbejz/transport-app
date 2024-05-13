import java.io.BufferedReader;
import java.io.InputStreamReader;

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

    private static int zap = 0;

    public Prevoz(){
        id = zap;
        stProdanihVozovnic = 0;
        zap++;
    }

    public Prevoz(String dO, String uO, String dP, String uP, String kO, String drO, String kP, String drP, double c, int stS){
        datumOdhoda = dO;
        uraOdhoda = uP;
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

    public void addDatumOdhoda(String dO){
        datumOdhoda = dO;
    }
    
    @Override
    public String toString(){
        String niz = "";
        niz += "Datum in ura odhoda: " + datumOdhoda + ", " + uraOdhoda + "\n";
        niz += "Datum in ura prihoda: " + datumPrihoda + ", " + uraPrihoda + "\n";
        niz += "Kraj in drazava odhoda: " + krajOdhoda + ", " + drzavaOdhoda + "\n";
        niz += "Kraj in drzava prihoda: " + krajPrihoda + ", " + drzavaPrihoda + "\n";
        niz += "Cena vozovnice: " + cenaVozovnice + "\n";
        niz += "Stevilo sedezev: " + stSedezev + "\n";

        return niz;
    }

    public static Prevoz ustvariPrevoz() throws Exception{
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

        Prevoz p = new Prevoz(datumOdhoda, uraOdhoda, datumPrihoda, uraPrihoda, krajOdhoda, drzavaOdhoda, krajPrihoda, drzavaPrihoda, cenaVozovnice, stSedezev);

        return p;
    }

}