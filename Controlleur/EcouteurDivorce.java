package Interface_graphique.Controlleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import Interface_graphique.Modele.*;


public class EcouteurDivorce implements ActionListener {
    // Attributs
    JTextField IDhomme;
    JTextField IDfemme;
    JComboBox<String> jour;
    JComboBox<String> mois;
    JComboBox<String> annee;
    JFrame fenetre;
    Mairie1 mairie;

    // Constructeur
    public EcouteurDivorce(JTextField IDhomme, JTextField IDfemme, JComboBox<String> jour, JComboBox<String> mois, JComboBox<String> annee, Mairie1 mairie, JFrame fenetre) {
        this.IDhomme = IDhomme;
        this.IDfemme = IDfemme;
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
        this.mairie = mairie;
        this.fenetre = fenetre;
    }

    // Méthode qui permet de définir les actions à effectuer lorsqu'un bouton est cliqué
    // On enregistre les informations
    public void actionPerformed(ActionEvent e) {
        String idhomme = IDhomme.getText();
        String idfemme = IDfemme.getText();
        String jourm = (String) jour.getSelectedItem();
        String moism = (String) mois.getSelectedItem();
        String anneem = (String) annee.getSelectedItem();

        System.out.println("Vérification des IDs...");

        // Vérifie si l'ID de l'homme existe et s'il n'est pas déjà marié
        if (!mairie.Hommeexiste(idhomme)) {
            JOptionPane.showMessageDialog(fenetre, "ID manquant ou érroné !");
            System.out.println("ID de l'homme n'existe pas");
            return; // Arrête l'exécution de la méthode ici
        } else if (!mairie.etatPersonne(idhomme).equals("marié")) {
            JOptionPane.showMessageDialog(fenetre, "Cet homme n'est pas marié !");
            System.out.println("Cet homme n'est pas marié");
            return; // Arrête l'exécution de la méthode ici
        }

         // Vérifie si l'ID de la femme existe et si elle est mariée
         if (!mairie.Femmeexiste(idfemme)) {
            JOptionPane.showMessageDialog(fenetre, "L'ID de la femme n'existe pas !");
            System.out.println("ID de la femme n'existe pas");
            return; // Arrête l'exécution de la méthode ici
        } else if (!mairie.etatPersonne(idfemme).equals("marié")) {
            JOptionPane.showMessageDialog(fenetre, "Cette femme n'est pas mariée !");
            System.out.println("Cette femme n'est pas mariée");
            return; // Arrête l'exécution de la méthode ici
        }

        // Vérifie si l'homme et la femme sont mariés ensemble
        Mariage1 m = mairie.getMariageById(idhomme);
        if (m == null || !m.IDf.equals(idfemme)) {
            JOptionPane.showMessageDialog(fenetre, "Cet homme et cette femme ne sont pas mariés ensemble !");
            System.out.println("Cet homme et cette femme ne sont pas mariés ensemble");
            return; // Arrête l'exécution de la méthode ici
        }

        // Divorce l'homme et la femme
        Divorce1 d = new Divorce1(jourm, moism, anneem, idfemme, idhomme);
        mairie.ajout_divorce(d);
        mairie.delete_mariage(m);
        JOptionPane.showMessageDialog(fenetre, "Divorce effectué avec succès !");
        System.out.println("Divorce effectué avec succès");
        fenetre.dispose();
    }
}
