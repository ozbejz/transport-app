import java.io.BufferedReader;
import java.io.InputStreamReader;

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
}
