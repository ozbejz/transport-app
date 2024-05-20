import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Relacija {
    private String naziv;
    private String potrebenPotniList;

    public Relacija(){
        naziv = "";
        potrebenPotniList = "";
    }

    public Relacija(String n, String p){
        naziv = n;
        potrebenPotniList = p;
    }

    public static Relacija ustvariRelacija() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("naziv relacije (medobcinski, medkrajevni, mednarodni): ");
        String naziv = br.readLine();

        System.out.println("potreben potni list (da/ne): ");
        String list = br.readLine();

        Relacija r = new Relacija(naziv, list);

        return r;
    }

    public String RelacijaToString(){
        String niz = "";
        niz += "Relacija: " + naziv + "\n";
        niz += "Je potreben potni list? " + potrebenPotniList + "\n";

        return niz;
    }

    public String shraniPodatke(){
        String niz = "REL\r\n";	
        niz += naziv + "\r\n";
        niz += potrebenPotniList + "\r\n";
        niz += "#" + "\r\n";
        return niz;
    }

    public static Relacija preberiPodatke(ArrayList<String> zapis) throws Exception{
        String naziv = zapis.get(0);
        String list = zapis.get(1);

        Relacija r = new Relacija(naziv, list);

        return r;
    }
}
