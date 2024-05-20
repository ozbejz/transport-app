import java.io.*;
import java.util.*;

public class PotovalnaAgencija {
    private ArrayList<Prevoz> seznamPrevozov;
    private ArrayList<Integer> kupljeneVozovniceId;
    private ArrayList<Integer> kupljeneVozovniceKol;

    public PotovalnaAgencija(){
        this.seznamPrevozov = new ArrayList<>();
        this.kupljeneVozovniceId = new ArrayList<>();
        this.kupljeneVozovniceKol = new ArrayList<>();
    }

    public void dodajPrevoz(Prevoz p){
        this.seznamPrevozov.add(p);
    }

    public void izpis(){
        System.out.println("Izpis vseh prevozov");

        for (Prevoz prevoz : this.seznamPrevozov) {
            System.out.println(prevoz.toString());
        }
    }

    public void odstraniPrevoz() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Id prevoza:");

        int vnos = Integer.parseInt(br.readLine());
        this.seznamPrevozov.remove(vnos);
    }

    public void izpisAvtobusov(){
        for (Prevoz prevoz : this.seznamPrevozov) {
            if(prevoz instanceof Avtobus){
                System.out.println(prevoz.toString());
            }
        }
    }

    public void izpisPoDatumu(String datum){
        // odstranimo presledke
        datum = datum.replaceAll("\\s", "");
        for (Prevoz prevoz : this.seznamPrevozov){
            if(prevoz.getDatumOdhoda().replaceAll("\\s", "").equals(datum)){
                System.out.println(prevoz.toString());
            }
        }
    }

    public void izpisPoKraju(String krajOd, String krajPr){
        krajOd = krajOd.toUpperCase();
        krajPr = krajPr.toUpperCase();
        for (Prevoz prevoz : this.seznamPrevozov){
            if(prevoz.getKrajPrihoda().toUpperCase().equals(krajPr) && prevoz.getKrajPrihoda().toUpperCase().equals(krajPr)){
                System.out.println(prevoz.toString());
            }
        }
    }

    public void izpisPoCeni(double cena){
        for (Prevoz prevoz : this.seznamPrevozov){
            if(prevoz.getCenaVozovnice() < cena){
                System.out.println(prevoz.toString());
            }
        }
    }

    public void izpisPoStOseb(int st){
        for (Prevoz prevoz : this.seznamPrevozov) {
            // prostih je vec sedezev kot je oseb
            if(prevoz.getStSedezev() - prevoz.getStProdanih() >= st){
                System.out.println(prevoz.toString());
            }
        }
    }

    public void shraniVDatoteko(String imeDat) throws Exception{
        FileWriter fw = new FileWriter(imeDat);
		PrintWriter dat = new PrintWriter(fw);

        for(Prevoz p : this.seznamPrevozov){
            dat.print(p.shraniPodatke());
        }

        dat.println("###");
        dat.close();
    }

    public void beriIzDatoteke(String beriDat)throws Exception{
        FileReader fr = new FileReader(beriDat);
        BufferedReader dat = new BufferedReader(fr);
        
        this.seznamPrevozov.clear();

        ArrayList<String> podatki;

        while(dat.ready()){
            String vrstica = dat.readLine().trim().toUpperCase();
            if(vrstica.equals("PRE")){
                podatki = new ArrayList<String>();
                while(dat.ready() && !vrstica.equals("##"))
                {
                    vrstica = dat.readLine().trim();
                    podatki.add(vrstica);
                }

                Prevoz prevoz = Prevoz.preberiPodatke(podatki);
                this.seznamPrevozov.add(prevoz);
            }
            
            if(vrstica.equals("AVT")){
                podatki = new ArrayList<String>();
                while(dat.ready() && !vrstica.equals("##"))
                {
                    vrstica = dat.readLine().trim();
                    podatki.add(vrstica);
                }

                Avtobus avtobus = Avtobus.preberiPodatke(podatki);
                this.seznamPrevozov.add(avtobus);
            }

            if(vrstica.equals("LAD")){
                podatki = new ArrayList<String>();
                while(dat.ready() && !vrstica.equals("##"))
                {
                    vrstica = dat.readLine().trim();
                    podatki.add(vrstica);
                }

                Ladja ladja = Ladja.preberiPodatke(podatki);
                this.seznamPrevozov.add(ladja);
            }

            if(vrstica.equals("KRI")){
                podatki = new ArrayList<String>();
                while(dat.ready() && !vrstica.equals("##"))
                {
                    vrstica = dat.readLine().trim();
                    podatki.add(vrstica);
                }

                Krizarka krizarka = Krizarka.preberiPodatke(podatki);
                this.seznamPrevozov.add(krizarka);
            }

            if(vrstica.equals("TRA")){
                podatki = new ArrayList<String>();
                while(dat.ready() && !vrstica.equals("##"))
                {
                    vrstica = dat.readLine().trim();
                    podatki.add(vrstica);
                }

                Trajekt trajekt = Trajekt.preberiPodatke(podatki);
                this.seznamPrevozov.add(trajekt);
            }

            if(vrstica.equals("VLA")){
                podatki = new ArrayList<String>();
                while(dat.ready() && !vrstica.equals("##"))
                {
                    vrstica = dat.readLine().trim();
                    podatki.add(vrstica);
                }

                Vlak vlak = Vlak.preberiPodatke(podatki);
                this.seznamPrevozov.add(vlak);
            }

            if(vrstica.equals("PRI")){
                podatki = new ArrayList<String>();
                while(dat.ready() && !vrstica.equals("##"))
                {
                    vrstica = dat.readLine().trim();
                    podatki.add(vrstica);
                }

                PrivatnoLetalo pl = PrivatnoLetalo.preberiPodatke(podatki);
                this.seznamPrevozov.add(pl);
            }

            if(vrstica.equals("KOM")){
                podatki = new ArrayList<String>();
                while(dat.ready() && !vrstica.equals("##"))
                {
                    vrstica = dat.readLine().trim();
                    podatki.add(vrstica);
                }

                KomercialniLet kl = KomercialniLet.preberiPodatke(podatki);
                this.seznamPrevozov.add(kl);
            }
        }
        dat.close();
    }

    public void nakupVozovnic() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("vnesi drzavo odhoda: ");
        String drzavaOd = br.readLine().trim().toUpperCase();

        System.out.println("vnesi kraj odhoda: ");
        String krajOd = br.readLine().trim().toUpperCase();

        System.out.println("vnesi drzavo prihoda: ");
        String drzavaPr = br.readLine().trim().toUpperCase();

        System.out.println("vnesi kraj prihoda: ");
        String krajPr = br.readLine().trim().toUpperCase();

        System.out.println("vnesi datum potovanja: ");
        String datum = br.readLine().replaceAll("\\s", "");

        System.out.println("vnesi stevilo oseb: ");
        int stOseb = Integer.parseInt(br.readLine().trim());

        System.out.println("povratna vozovnica (da/ne): ");
        String p = br.readLine().trim();

        boolean povratna = false;

        if(p.toUpperCase().equals("DA")){
            povratna = true;
        }

        for (Prevoz prevoz : this.seznamPrevozov){
            boolean prevoziOd = drzavaOd.equals(prevoz.getDrzavaOdhoda().trim().toUpperCase()) && krajOd.equals(prevoz.getKrajOdhoda().trim().toUpperCase()) 
                && drzavaPr.equals(prevoz.getDrzavaPrihoda().trim().toUpperCase()) 
                && krajPr.equals(prevoz.getKrajPrihoda().trim().toUpperCase());
            if(prevoziOd && prevoz.getStSedezev() - prevoz.getStProdanih() >= stOseb && datum.equals(prevoz.getDatumOdhoda().replaceAll("\\s", ""))){
                System.out.println("(" + prevoz.getId() + ")");
                System.out.println(prevoz.toString());
            }
        }

        System.out.println("Prevozi s prestopom: ");
        for (Prevoz prevoz : this.seznamPrevozov){
            
        }

        if(povratna){
            System.out.println("Za nazaj: ");
            for (Prevoz prevoz : this.seznamPrevozov){
                boolean prevoziOd = drzavaOd.equals(prevoz.getDrzavaPrihoda().trim().toUpperCase()) && krajOd.equals(prevoz.getKrajPrihoda().trim().toUpperCase()) 
                    && drzavaPr.equals(prevoz.getDrzavaOdhoda().trim().toUpperCase()) 
                    && krajPr.equals(prevoz.getKrajOdhoda().trim().toUpperCase());
                if(prevoziOd && prevoz.getStSedezev() - prevoz.getStProdanih() >= stOseb){
                    System.out.println("(" + prevoz.getId() + ")");
                    System.out.println(prevoz.toString());
                }
            }
        }

        System.out.println("Za nakup vozovnice izberite stevilko prevoza ali (0) za izhod: ");
        String izbira = br.readLine().trim();
    }
}
