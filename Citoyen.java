
import java.util.*;

/**
 * Citoyen est une class abstraite car one ne peut pas creer un citoyen,
 * il faut creer un homme ou une femme.
 */
public abstract class Citoyen {

	/**
	 * Identifiant unique.
	 */
	public int num_id;

	/**
	 * Nom de famille.
	 */
	public String nom;

	/**
	 * Prenom.
	 */
	public String prenom;

	/**
	 * Age.
	 */
	public int age;

	/**
	 * Date de deces.
	 */
	public Deces deces;

	/**
	 * Liste des locations.
	 */
	public Set<Location> liste_location;

	/**
	 * Date de naissance.
	 */
	public Naissance naissance;

	/**
	 * Lieu de naissance.
	 */
	public Mairie mairie;


	/**
	 * Default constructor
	 */
	public Citoyen(int num_id, String nom, String prenom, int age, Mairie mairieNaissance) {
		this.num_id = num_id;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.deces = null;
		this.mairie = mairieNaissance;
	}

	public boolean isDead() {
		if (this.deces != null) {
			return true;
		} 
		return false;
	}

	

	// public static void main(String[] args) {
	// 	Citoyen p = new Citoyen(1, "aaa", "bbb", 22);
	// 	Femme f = new Femme(2, "hhh", "lll", 23);
	// 	// Femme f=new Femme();
	// 	LocalDate date = LocalDate.of(1984, 2, 21);

	// 	// Affichage de la date
	// 	System.out.println("Date :" + f.nom);

	// }

}
