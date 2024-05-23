
import java.util.*;

/**
 * 
 */
public class Homme extends Citoyen {

    /**
     * Default constructor
     */
    
        public Homme(int num_id, String nom, String prenom, int age,Mairie mairieNaissance) {
            super(num_id, nom, prenom, age, mairieNaissance);
            // Initialisez les autres attributs spécifiques à homme si nécessaire
            this.liste_naissance = new HashSet<>();
            this.liste_mariage = new HashSet<>();
        }
    


    /**
     * 
     */
    public Set<Naissance> liste_naissance;

    /**
     * 
     */
    public Set<Mariage> liste_mariage;


}
