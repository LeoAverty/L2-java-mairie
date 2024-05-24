package Interface_graphique.Vue;
import java.awt.*;
import javax.swing.*;
import Interface_graphique.Modele.*;

public class FenetreVueMariage2 extends JFrame {
    Mairie1 mairie;
    JTextArea textArea;

    //fenetre principale
    public FenetreVueMariage2(Mairie1 mairie) {
        this.mairie = mairie;
        this.setTitle("Liste des mariages");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setEditable(false); // Pour empêcher la modification du contenu

        JScrollPane scrollPane = new JScrollPane(textArea); // Pour ajouter une barre de défilement si nécessaire

        // Ajoutez ici le code pour remplir le JTextArea avec la liste des mariages
        for (Mariage1 m : mairie.liste_mariage) {
            Homme1 homme = mairie.getHommeById(m.IDh);
            Femme1 femme = mairie.getFemmeById(m.IDf);
            textArea.append("Le " + m.jour + "/" + m.mois + "/" + m.annee + " " + femme.nom + " " + femme.prenom + " & " + homme.nom + " " + homme.prenom + "\n");
        }

        this.add(scrollPane, BorderLayout.CENTER);
        this.setVisible(true);
    }
}
