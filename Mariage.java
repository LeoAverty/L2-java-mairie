
import java.time.*;

/**
 * 
 */
public class Mariage {

	/**
	 * 
	 */
	public LocalDate date_mariage;
	public int IDf, IDh;

	/**
	 * 
	 */
	public Homme homme;

	/**
	 * 
	 */
	public Femme femme;

	/**
	 * 
	 */
	public Mairie mairie;

	/**
	 * 
	 */
	public Divorce divorce;

	/**
	 * Default constructor
	 */
	public Mariage(LocalDate date_mariage, int IDf, int IDh) {
		this.date_mariage = date_mariage;
		this.IDf = IDf;
		this.IDh = IDh;
	}

}
