package minikong.komennot;

import java.util.Scanner;
import minikong.domain.TekstinTiedot;

public class HaeSana extends Komento{

    public HaeSana(TekstinTiedot t) {
        super(t);
    }
    
    @Override
    public void suorita() {
        //korvataan
        Scanner s = new Scanner(System.in);
        System.out.println("Anna sana: ");
        String sana = s.nextLine();
        
        if (!super.getTeksti().sanaListattu(sana)) {
            System.out.println("Sanaa ei löydy tekstistä");
        } else {
            System.out.println("Yleisin oikealla: " + super.getTeksti().getSana(sana).getSuurin(false));
            System.out.println("Yleisin vasemmalla: " + super.getTeksti().getSana(sana).getSuurin(true));
        }
    }

    
    
}