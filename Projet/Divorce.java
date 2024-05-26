
import java.time.LocalDate;

/**
 * 
 */
public class Divorce {

    /**
     * Default constructor
     */
    int idF;
    int idH;
    LocalDate date_mariage;
    LocalDate date_divorce;
    public Divorce(int idF,int idH,LocalDate date_mariage,LocalDate date_divorce) {
        this.idF=idF;
        this.idH=idH;
        this.date_mariage=date_mariage;
        this.date_divorce=date_divorce;    
    }

    /**
     * 
     */
   

    /**
     * 
     */
    public Mariage mariage;

}