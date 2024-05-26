import java.time.LocalDate;

public class Location {
    public LocalDate dateDebut;
    public LocalDate dateFin;
    public Logement logement;
    public Citoyen citoyen;


    public Location(LocalDate dateDebut, LocalDate dateFin, Logement logement,Citoyen citoyen) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.logement = logement;
        this.citoyen = citoyen;
    }

    

}