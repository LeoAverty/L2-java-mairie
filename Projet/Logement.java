

import java.util.*;

/**
 * 
 */
public class Logement {

    /**
     * Default constructor
     */
    public Logement(int superficie,boolean meuble,int Id_logement,int PlacesLibres) {
        this.superficie = superficie;
        this.meuble = meuble;
        this.Id_logement = Id_logement;
        this.PlacesLibres = PlacesLibres;
    }
    public void decrementerPlacesLibres() {
        if (PlacesLibres > 0) {
            PlacesLibres--;
        } else {
            System.out.println("Pas de places libres dans ce logement.");
        }
    }

    /**
     * 
     */
    public int superficie;

    /**
     * 
     */
    public boolean meuble;


    /**
     * 
     */
    public Mairie mairie;

    /**
     * 
     */
    public Set<Location> liste_location;
    /**
     * 
     */
    public int Id_logement;

    public int PlacesLibres;
    

}
