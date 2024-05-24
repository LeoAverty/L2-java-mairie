package Interface_graphique.Modele;
import java.util.*;

/**
 * 
 */
public class Homme1 extends Citoyen1 {

    /**
     * Default constructor
     */
    
        public Homme1(String num_id, String nom, String prenom, String age,Mairie1 mairieNaissance) {
            super(num_id, nom, prenom, age, mairieNaissance);
            // Initialisez les autres attributs spécifiques à homme si nécessaire
            this.liste_naissance = new HashSet<>();
            this.liste_mariage = new HashSet<>();
        }
    


    /**
     * 
     */
    public Set<Naissance1> liste_naissance;

    /**
     * 
     */
    public Set<Mariage1> liste_mariage;


}