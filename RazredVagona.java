import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RazredVagona {
    private int razred;
    private String postelja;
    private String postrezba;

    public RazredVagona(){
        razred = 0;
        postelja = "";
        postrezba = "";
    }

    public RazredVagona(int r, String p, String po){
        razred = r;
        postelja = p;
        postrezba = po;
    }

    public int getRazred(){
        return razred;
    }

    public String getPostelja(){
        return postelja;
    }

    public String getPostrezba(){
        return postrezba;
    }

    public static RazredVagona ustvariRazredVagona() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Razred vagona: ");
        int razred = Integer.parseInt(br.readLine());
        
        System.out.println("Postelja (da/ne): ");
        String postelja = br.readLine();

        System.out.println("Postrezba: ");
        String postrezba = br.readLine();

        RazredVagona rv = new RazredVagona(razred, postelja, postrezba);

        return rv;
    }

    
    public String RazredVagonaToString(){
        String niz = "";
        niz += "Razred vagona: " + razred + "\n";
        niz += "Postelja: " + postelja + "\n";
        niz += "Postrezba: " + postrezba + "\n";

        return niz;
    }

    public String shraniPodatke(){
        String niz = "RAZV\r\n";	
        niz += razred + "\r\n";
        niz += postelja + "\r\n";
        niz += postrezba + "\r\n";
        niz += "#" + "\r\n";
        return niz;
    }

    public static RazredVagona preberiPodatke(ArrayList<String> zapis) throws Exception{
        int razred = Integer.parseInt(zapis.get(0));
        String postelja = zapis.get(1);
        String postrezba = zapis.get(2);

        RazredVagona rv = new RazredVagona(razred, postelja, postrezba);

        return rv;
    }
}
