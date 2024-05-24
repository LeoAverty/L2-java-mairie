package Interface_graphique.Controlleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Interface_graphique.Modele.*;

public class EcouteurNaissance implements ActionListener {
    // Attributs (passage de vue à controleur)
    JTextField IDpere;
    JTextField IDmere;
    JTextField IDenfant;
    JTextField nomEnfant;
    JTextField prenomEfant;
    JTextField ageEfant;
    String sexeEnfant;  
    JFrame fenetre;
    Mairie1 mairie;

    // Constructeur
    public EcouteurNaissance(JTextField IDpere, JTextField IDmere, JTextField IDenfant, JTextField nomEnfant, JTextField prenomEfant,JTextField ageEfant,String sexeEnfant, Mairie1 mairie, JFrame fenetre) {
        this.IDpere = IDpere;
        this.IDmere = IDmere;
        this.IDenfant = IDenfant;
        this.nomEnfant = nomEnfant;
        this.prenomEfant = prenomEfant;
        this.ageEfant = ageEfant;
        this.sexeEnfant = sexeEnfant;
        this.mairie = mairie;
        this.fenetre = fenetre;
    }

    // Méthode qui permet de définir les actions à effectuer lorsqu'on saisit une personne
    public void actionPerformed(ActionEvent e) {
        System.out.println(mairie.citoyens);
        String idpere = IDpere.getText();
        String idmere = IDmere.getText();
        String id = IDenfant.getText();
        String nom = nomEnfant.getText();
        String prenom = prenomEfant.getText();
        String age = ageEfant.getText();
        // Vérifie si le citoyen existe 
        if (!mairie.Citoyenexiste(idpere)) {
            // Gérer le cas où l'ID existe déjà
            JOptionPane.showMessageDialog(fenetre, "ID inexistant(pere) !");
            return; // Ajout de return pour stopper l'exécution ici
        }

        // Vérifie si le citoyen existe 
        if (!mairie.Citoyenexiste(idmere)) {
            // Gérer le cas où l'ID existe déjà
            JOptionPane.showMessageDialog(fenetre, "ID inexistant(mere) !");
            return; // Ajout de return pour stopper l'exécution ici
        }

        // Vérifie si l'id de l'enfant existe
        if (mairie.Citoyenexiste(id)) {
            // Gérer le cas où l'ID existe déjà
            JOptionPane.showMessageDialog(fenetre, "ID existant(enfant) !");
            return; // Ajout de return pour stopper l'exécution ici
        }

        // Création des nouvelles instances en fonction du sexe
        if (sexeEnfant.equalsIgnoreCase("homme")) {
            Homme1 homme = new Homme1(id,nom,prenom,age,mairie);
            // Ajout de l'homme à la mairie
            mairie.ajoutCitoyen(homme);
            System.out.println("Fermeture de la fenêtre");
            fenetre.dispose();
        } else if (sexeEnfant.equalsIgnoreCase("femme")) {
            Femme1 femme = new Femme1(id, nom, prenom, age, mairie);
            // Ajout de la femme à la mairie
            mairie.ajoutCitoyen(femme);
            System.out.println("Fermeture de la fenêtre");
            fenetre.dispose();
        }
    }
}
