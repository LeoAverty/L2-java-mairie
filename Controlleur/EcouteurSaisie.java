package Interface_graphique.Controlleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Interface_graphique.Modele.*;

public class EcouteurSaisie implements ActionListener {
    // Attributs (passage de vue à controleur)
    JTextField idField;
    JTextField nomField;
    JTextField prenomField;
    JTextField ageField;
    String sexe;  
    JFrame fenetre;
    Mairie1 mairie;

    // Constructeur
    public EcouteurSaisie(JTextField idField, JTextField nomField, JTextField prenomField, JTextField ageField, String sexe, Mairie1 mairie, JFrame fenetre) {
        this.idField = idField;
        this.nomField = nomField;
        this.prenomField = prenomField;
        this.ageField = ageField;
        this.sexe = sexe;
        this.mairie = mairie;
        this.fenetre = fenetre;
    }

    // Méthode qui permet de définir les actions à effectuer lorsqu'on saisit une personne
    public void actionPerformed(ActionEvent e) {
        System.out.println(mairie.citoyens);
        String id = idField.getText();
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String age = ageField.getText();

        // Vérifie si le citoyen existe déjà
        if (mairie.Citoyenexiste(id)) {
            // Gérer le cas où l'ID existe déjà
            JOptionPane.showMessageDialog(fenetre, "ID déjà existant !");
            return; // Ajout de return pour stopper l'exécution ici
        }

        // Création des nouvelles instances en fonction du sexe
        if (sexe.equalsIgnoreCase("homme")) {
            Homme1 homme = new Homme1(id, nom, prenom, age, mairie);
            // Ajout de l'homme à la mairie
            mairie.ajoutCitoyen(homme);
            System.out.println("Fermeture de la fenêtre");
            fenetre.dispose();
        } else if (sexe.equalsIgnoreCase("femme")) {
            Femme1 femme = new Femme1(id, nom, prenom, age, mairie);
            // Ajout de la femme à la mairie
            mairie.ajoutCitoyen(femme);
            System.out.println("Fermeture de la fenêtre");
            fenetre.dispose();
        }
    }
}

    
        
        
    
    
    

