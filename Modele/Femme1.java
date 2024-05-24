package Interface_graphique.Modele;
import java.util.*;

/**
 * 
 */
public class Femme1 extends Citoyen1 {

	/**
	 * Constructeur,
	 * @param num_id          identifiant
	 * @param nom             nom
	 * @param prenom          prenom
	 * @param age             age
	 * @param mairieNaissance lieu de naissance
	 */
     public Femme1(String num_id, String nom, String prenom, String age, Mairie1 mairieNaissance) {
        super(num_id, nom, prenom, age, mairieNaissance);
        this.liste_naissance = new HashSet<>();
        this.liste_mariage = new HashSet<>();
    }

    /**
     * Ensemble des enfants.
     */
    public Set<Naissance1> liste_naissance;

    /**
     * Ensemble des mariages.
     */
    public Set<Mariage1> liste_mariage;


   




}











