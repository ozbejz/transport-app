import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RazredKabine {
    private int razred;
    private String ugodnosti;

    public RazredKabine(){
        razred = 0;
        ugodnosti = "";
    }

    public RazredKabine(int r, String u){
        razred = r;
        ugodnosti = u;
    }

    public static RazredKabine ustvariRazredKabine() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Razred kabine: ");
        int razred = Integer.parseInt(br.readLine());
        
        System.out.println("Ugodnosti: ");
        String ugodnosti = br.readLine();

        RazredKabine rk = new RazredKabine(razred, ugodnosti);

        return rk;
    }

    public String RazredKabineToString(){
        String niz = "";
        niz += "Razred kabine: " + razred + "\n";
        niz += "Ugodnosti: " + ugodnosti + "\n";

        return niz;
    }

    public String shraniPodatke(){
        String niz = "RAZK\r\n";	
        niz += razred + "\r\n";
        niz += ugodnosti + "\r\n";
        niz += "#" + "\r\n";
        return niz;
    }

    public static RazredKabine preberiPodatke(ArrayList<String> zapis) throws Exception{
        int razred = Integer.parseInt(zapis.get(0));
        String ugodnosti = zapis.get(1);

        RazredKabine rk = new RazredKabine(razred, ugodnosti);

        return rk;
    }
}
