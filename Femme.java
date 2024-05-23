
import java.util.*;

/**
 * 
 */
public class Femme extends Citoyen {

	/**
	 * Constructeur,
	 * @param num_id          identifiant
	 * @param nom             nom
	 * @param prenom          prenom
	 * @param age             age
	 * @param mairieNaissance lieu de naissance
	 */
     public Femme(int num_id, String nom, String prenom, int age, Mairie mairieNaissance) {
        super(num_id, nom, prenom, age, mairieNaissance);
        this.liste_naissance = new HashSet<>();
        this.liste_mariage = new HashSet<>();
    }

    /**
     * Ensemble des enfants.
     */
    public Set<Naissance> liste_naissance;

    /**
     * Ensemble des mariages.
     */
    public Set<Mariage> liste_mariage;

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le nombre de femmes à enregistrer : ");
        int nombreFemmes = scanner.nextInt();
        scanner.nextLine(); // Lire la nouvelle ligne après le nombre

        List<Femme> femmes = new ArrayList<>();

        for (int i = 0; i < nombreFemmes; i++) {
            System.out.println("Entrez les informations pour la femme " + (i + 1) + ":");
            Femme femme = lireFemme(scanner);
           femmes.add(femme);
        }

        // Afficher les informations des femmes
        System.out.println("\nInformations des femmes enregistrées :");
        for (Femme femme : femmes) {
            System.out.println(femme);
        }

        // Fermer le scanner pour libérer les ressources
        scanner.close();
        
    }

    // Fonction pour lire les informations d'une femme à partir de la console
    public static Femme lireFemme(Scanner scanner) {
        // Scanner scanner = new Scanner(System.in);
        System.out.print("ID : ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Lire la nouvelle ligne après l'entier

        System.out.print("Nom : ");
        String nom = scanner.nextLine();

        System.out.print("Prénom : ");
        String prenom = scanner.nextLine();

        System.out.print("Âge : ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Lire la nouvelle ligne après l'entier
        // 
        // Créer une nouvelle femme avec les informations lues
        return new Femme(id, nom, prenom, age, null);
    }




}











