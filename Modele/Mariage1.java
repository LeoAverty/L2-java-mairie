package Interface_graphique.Modele;
import java.time.*;

/**
 * 
 */
public class Mariage1 {

	/**
	 * 
	 */
	public String jour;
	public String mois;
	public String annee;
	public String IDf, IDh;

	/**
	 * 
	 */
	public Homme1 homme;

	/**
	 * 
	 */
	public Femme1 femme;

	/**
	 * 
	 */
	public Mairie1 mairie;

	/**
	 * 
	 */
	public Divorce1 divorce;

	/**
	 * Default constructor
	 */
	public Mariage1(String jour, String mois, String annee, String IDf, String IDh) {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
        this.IDf = IDf;
        this.IDh = IDh;
	}
	public String getDate() {
		return jour + "/" + mois + "/" + annee;
	}


}