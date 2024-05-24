package Interface_graphique.Modele;
import java.time.LocalDate;

/**
 * 
 */
public class Divorce1 {

    /**
     * Default constructor
     */
    public String idF;
    public String idH;
    public  String jour_d;
    public String mois_d;
    public String annee_d;
    public Divorce1(String idF,String idH,String jour_d,String mois_d,String annee_d) {
        this.idF=idF;
        this.idH=idH;
         this.jour_d=jour_d;
        this.mois_d=mois_d;
        this.annee_d=annee_d;   
    }
    public String getDate() {
		return jour_d + "/" + mois_d + "/" + annee_d;
	}

    /**
     * 
     */
   

    /**
     * 
     */
    public Mariage1 mariage;

}