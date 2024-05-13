import java.io.*;
import java.util.*;

public class PotovalnaAgencija {
    private ArrayList<Prevoz> seznamPrevozov;

    public PotovalnaAgencija(){
        this.seznamPrevozov = new ArrayList<>();
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

    public void iskanjePrevozov(){

    }

    public void izpisAvtobusov(){
        for (Prevoz prevoz : this.seznamPrevozov) {
            if(prevoz instanceof Avtobus){
                System.out.println(prevoz.toString());
            }
        }
    }
}
