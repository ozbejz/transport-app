import java.io.*;
import java.util.*;

public class PotovalnaAgencija {
    private ArrayList<Prevoz> seznamPrevozov;
    private ArrayList<Prevoz> kupljeneVozovnice;
    private ArrayList<Integer> kupljeneVozovniceKol;

    public PotovalnaAgencija(){
        this.seznamPrevozov = new ArrayList<>();
        this.kupljeneVozovnice = new ArrayList<>();
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

        int id = -1;

        for(int i = 0; i < seznamPrevozov.size(); i++){
            if(seznamPrevozov.get(i).getId() == vnos){
                id = i;
            }
        }
        
        this.seznamPrevozov.remove(id);

        System.out.println("Brisanje koncano");
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
            if(prevoz.getKrajPrihoda().toUpperCase().equals(krajPr) && prevoz.getKrajOdhoda().toUpperCase().equals(krajOd)){
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

        System.out.println("Prenosi shranjeni v datoteko!");
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
        System.out.println("Prevozi vneseni iz datoteke!");
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
        boolean najdeno = false;

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
                najdeno = true;
            }
        }
        
        System.out.println("Prevozi s prestopom: ");

        //najprej naredimo seznam prevozov, ki se koncajo na zeleni destinaciji
        ArrayList<Prevoz> prevoziPrihod;
        prevoziPrihod = new ArrayList<>();
        boolean jePrestop = false;

        for (Prevoz prevoz : this.seznamPrevozov){
            boolean prevoziOd = drzavaPr.equals(prevoz.getDrzavaPrihoda().trim().toUpperCase()) 
                && krajPr.equals(prevoz.getKrajPrihoda().trim().toUpperCase());
            if(prevoziOd && prevoz.getStSedezev() - prevoz.getStProdanih() >= stOseb){
                prevoziPrihod.add(prevoz);
            }
        }

        // kraje prihoda tistih prevozov, ki se zacnejo na zeleni destinaciji primerjamo z kraji odhoda prevoziPrihod
        for (Prevoz prevoz : this.seznamPrevozov){
            boolean prevoziOd = drzavaOd.equals(prevoz.getDrzavaOdhoda().trim().toUpperCase()) && krajOd.equals(prevoz.getKrajOdhoda().trim().toUpperCase());
            if(prevoziOd && prevoz.getStSedezev() - prevoz.getStProdanih() >= stOseb && datum.equals(prevoz.getDatumOdhoda().replaceAll("\\s", ""))){
                for(Prevoz prevoz2 : prevoziPrihod){
                    boolean prevoziPrih = prevoz2.getDrzavaOdhoda().trim().toUpperCase().equals(prevoz.getDrzavaPrihoda().trim().toUpperCase()) 
                        && prevoz2.getKrajOdhoda().trim().toUpperCase().equals(prevoz.getKrajPrihoda().trim().toUpperCase());
                    if(prevoziPrih){
                        System.out.println("(" + prevoz.getId() + ")");
                        System.out.println(prevoz.toString());

                        System.out.println("(" + prevoz2.getId() + ")");
                        System.out.println(prevoz2.toString());
                        najdeno = true;
                        jePrestop = true;
                    }
                }
            }
        }

        if(jePrestop == false){
            System.out.println("Ni nobenega prevoza s prestopom \n");
        }
        
        if(najdeno == false){
            System.out.println("Zal nismo nasli nobenega prevoza ki bi vam ustrezal \n");
            return;
        }

        boolean jePovratna = false;

        if(povratna){
            System.out.println("Za nazaj: ");
            for (Prevoz prevoz : this.seznamPrevozov){
                boolean prevoziOd = drzavaOd.equals(prevoz.getDrzavaPrihoda().trim().toUpperCase()) && krajOd.equals(prevoz.getKrajPrihoda().trim().toUpperCase()) 
                    && drzavaPr.equals(prevoz.getDrzavaOdhoda().trim().toUpperCase()) 
                    && krajPr.equals(prevoz.getKrajOdhoda().trim().toUpperCase());
                if(prevoziOd && prevoz.getStSedezev() - prevoz.getStProdanih() >= stOseb){
                    System.out.println("(" + prevoz.getId() + ")");
                    System.out.println(prevoz.toString());
                    jePovratna = true;
                }
            }
        }

        if(povratna && jePovratna == false){
            System.out.println("Zal nismo nasli povratnih prevozov \n");
        }

        int izbira = 0;
        int kol = 0;

        while (true) {
            System.out.println("Za nakup vozovnice izberite stevilko prevoza ali (0) za izhod: ");
            izbira = Integer.parseInt(br.readLine());
            if(izbira == 0){
                break;
            }
            System.out.println("Vnesite stevilo vozovnic: ");
            kol = Integer.parseInt(br.readLine());
    
            for(int i = 0; i < seznamPrevozov.size(); i++){
                if(seznamPrevozov.get(i).getId() == izbira){
                    if(seznamPrevozov.get(i).getStProstih() < kol){
                        System.out.println("Premalo prostih mest!");
                        break;
                    }

                    System.out.println("Vozovnica kupljena!");
                    kupljeneVozovnice.add(seznamPrevozov.get(i));
                    kupljeneVozovniceKol.add(kol);
                    seznamPrevozov.get(i).setStProdanih(kol);
                }
            }
        }
    }

    public void izpisKupljenih(){
        System.out.println("Kupljene vozovnice: \n");
        for(int i = 0; i < kupljeneVozovnice.size(); i++){
            System.out.println(kupljeneVozovnice.get(i));
            System.out.print("Stevilo vozovnic: " + kupljeneVozovniceKol.get(i) + '\n');
        }
    }
}
