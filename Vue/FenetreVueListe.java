package Interface_graphique.Vue;
import java.awt.*;
import javax.swing.*;
import Interface_graphique.Modele.*;


public class FenetreVueListe extends JFrame {
    Mairie1 mairie;
    JTextArea textArea;

    // Fenetre principale
    public FenetreVueListe(Mairie1 mairie) {
        this.mairie = mairie;
        this.setTitle("Liste des personnes");
        this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
        textArea = new JTextArea();
        textArea.setEditable(false); // Pour empêcher la modification du contenu
    
        JScrollPane scrollPane = new JScrollPane(textArea); // Pour ajouter une barre de défilement si nécessaire
    
        // Remplir le JTextArea avec la liste des personnes
        for (Citoyen1 m : mairie.citoyens) {
            textArea.append("-Id: "+m.num_id+"  Nom: " + m.nom + "  Prenom: " + m.prenom + "  Sexe: " + m.getClass().getSimpleName() + "  Age: " + m.age + "ans "  + "\n");
        }
        
        // Affichage final
        this.add(scrollPane, BorderLayout.CENTER);
        this.setVisible(true);
        System.out.println("FenetreVueListe");
    }
}
