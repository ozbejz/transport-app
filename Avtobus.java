import java.io.*;
import java.security.spec.ECParameterSpec;
import java.util.*;

public class Avtobus extends Prevoz{
    private String prevoznik;
    private int stAvtobusa;

    public Avtobus(){
        super();

        Scanner sc = new Scanner(System.in);

        System.out.println("prevoznik: ");
        prevoznik = sc.nextLine().trim();

        System.out.println("stevilka avtobusa: ");
        stAvtobusa = sc.nextInt();
    }

    public Avtobus(String dO, String uO, String dP, String uP, String kO, String drO, String kP, String drP, double c, int stS, String p, int s){
        super(dO, uO, dP, uP, kO, drO, kP, drP, c, stS);
        prevoznik = p;
        stAvtobusa = s;
    }

    public static Avtobus ustvariAvtobus() throws Exception{
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
        double cenaVozovnice = Integer.parseInt(br.readLine().trim());

        System.out.println("stevilo sedezev: ");
        int stSedezev = Integer.parseInt(br.readLine().trim());

        System.out.println("avtobusni prevoznik: ");
        String prevoznik = br.readLine().trim();

        System.out.println("stevilka avtobusa: ");
        int stAvtobusa = Integer.parseInt(br.readLine().trim());

        Avtobus a = new Avtobus(datumOdhoda, uraOdhoda, datumPrihoda, uraPrihoda, krajOdhoda, drzavaOdhoda, krajPrihoda, drzavaPrihoda, cenaVozovnice, stSedezev, prevoznik, stAvtobusa);
        return a;   
    }

    @Override
    public String toString(){
        String niz = "";
        niz += this.izpisNadrazreda();
        niz += "Avtobusni prevoznik: " + prevoznik + "\n";
        niz += "Stevilka avtobusa: " + stAvtobusa + "\n";

        return niz;
    }
}
