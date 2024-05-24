package Interface_graphique.Modele;
import java.util.*;

/**
 * Citoyen est une class abstraite car one ne peut pas creer un citoyen,
 * il faut creer un homme ou une femme.
 */
public abstract class Citoyen1 {

	/**
	 * Identifiant unique.
	 */
	public String num_id;

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
	public String age;

	

	

	/**
	 * Date de naissance.
	 */
	public Naissance1 naissance;

	/**
	 * Lieu de naissance.
	 */
	public Mairie1 mairie;


	/**
	 * Default constructor
	 */
	public Citoyen1(String num_id, String nom, String prenom, String age, Mairie1 mairieNaissance) {
		this.num_id = num_id;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.mairie = mairieNaissance;
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