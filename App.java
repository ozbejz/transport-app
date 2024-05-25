import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PotovalnaAgencija agencija = new PotovalnaAgencija();

        while (true) {
            try{
                System.out.println("(1) vnos prevoza");
                System.out.println("(2) izpis/iskanje prevozov");
                System.out.println("(3) odstranitev prevoza");
                System.out.println("(4) nakup vozovnic");
                System.out.println("(5) pregled kupljenih vozovnic");
                System.out.println("(6) shrani prevoze");
                System.out.println("(7) vnesi prevoze iz datoteke");
                System.out.println("(0) koncaj");
                
                int vnos = Integer.parseInt(br.readLine());
                
                switch (vnos) {
                    case 1:
                        Prevoz p = vnosPrevoza();
                        agencija.dodajPrevoz(p);
                        break;
                    case 2:
                        System.out.println("(1) izpis po datumu");
                        System.out.println("(2) izpis po kraju");
                        System.out.println("(3) izpis po ceni vozovnice");
                        System.out.println("(4) izpis po stevilu oseb");
                        System.out.println("(5) izpis vseh prevozov");

                        vnos = Integer.parseInt(br.readLine());
            
                        switch (vnos) {
                            case 1:
                                System.out.println("datum potovanja:");
                                String datum = br.readLine();
                                agencija.izpisPoDatumu(datum);
                                break;
                            case 2:
                                System.out.println("kraj odhoda:");
                                String krajOd = br.readLine();
                                System.out.println("kraj prihoda:");
                                String krajPr = br.readLine();

                                agencija.izpisPoKraju(krajOd, krajPr);
                                break;
                            case 3:
                                System.out.println("vnesi max ceno vozovnice: ");
                                double cena = Double.parseDouble(br.readLine());
                                agencija.izpisPoCeni(cena);
                                break;
                            case 4:
                                System.out.println("vnesi stevilo oseb: ");
                                int st = Integer.parseInt(br.readLine());
                                agencija.izpisPoStOseb(st);
                                break;
                            case 5:
                                agencija.izpis();
                                break;
                        
                            default:
                                break;
                        }
                        break;
                    case 3:
                        agencija.odstraniPrevoz();
                        break;
                    case 4:
                        agencija.nakupVozovnic();
                        break;
                    case 5:
                        agencija.izpisKupljenih();
                    break;
                    case 6:
                        agencija.shraniVDatoteko("prevozi.txt");
                        break;
                    case 7:
                        agencija.beriIzDatoteke("prevozi.txt");
                        break;
                    case 0:
                        System.out.println("konec programa");
                        return;
                    default:
                        System.out.println("napacen ukaz");
                        break;
                }
            }
            catch(Exception e){
                System.out.println("napaka");
            }
        }
    }

    static public Prevoz vnosPrevoza() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try{
            while (true) {
                System.out.println("(1) avtobus");
                System.out.println("(2) ladja");
                System.out.println("(3) vlak");
                System.out.println("(4) letalo");
                System.out.println("(5) drugo");
        
                int vnos = Integer.parseInt(br.readLine());
                switch (vnos) {
                    case 1:
                        Prevoz avtobus = Avtobus.ustvariAvtobus();
                        return avtobus;
                    case 2:
                        System.out.println("(1) krizarka");
                        System.out.println("(2) trajekt");
                        System.out.println("(3) drugo");
    
                        vnos = Integer.parseInt(br.readLine());
    
                        switch (vnos) {
                            case 1:
                                Prevoz k = Krizarka.ustvariKrizarko();
                                return k;
                            case 2:
                                Prevoz t = Trajekt.ustvariTrajekt();
                                return t;
                            case 3:
                                Prevoz l = Ladja.ustvariLadjo();
                                return l;
                            default:
                                System.out.println("napacen ukaz");
                                break;
                        }
                        break;
                    case 3:
                        Prevoz v = Vlak.ustvariVlak();
                        return v;
                    case 4:
                        System.out.println("(1) privatno letalo");
                        System.out.println("(2) komercialni let");
    
                        vnos = Integer.parseInt(br.readLine());
    
                        switch (vnos) {
                            case 1:
                                Prevoz pl = PrivatnoLetalo.ustvariPrivatnoLetalo();
                                return pl;
                            case 2:
                                Prevoz kl = KomercialniLet.ustvariKomercialniLet();
                                return kl;
                            default:
                                System.out.println("napacen ukaz");
                                break;
                        }
                        break;
                    case 5:
                        Prevoz p = Prevoz.ustvariPrevoz();
                        return p;
                    default:
                        System.out.println("napacen ukaz");
                        break;
                }
            }
        }
        catch(Exception e){
            System.out.println("Napaka");
        }
        return null;
    }
}
