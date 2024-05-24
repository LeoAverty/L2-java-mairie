package Interface_graphique.Controlleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import Interface_graphique.Modele.*;
import Interface_graphique.Vue.*;

public class EcouteurMenuPrincipal implements ActionListener {
    Mairie1 mairie;
    
    //Constructeur 
    public EcouteurMenuPrincipal(Mairie1 mairie) {
        this.mairie = mairie;
    }

    //Méthode qui permet de définir les actions à effectuer lorsqu'un bouton est cliqué
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if(command.equals("Mariage")){
            new FenetreVueMariage(mairie).setVisible(true);
        }

        if(command.equals("Naissance")){
            new FenetreVueNaissance(mairie).setVisible(true);
        }
        
        if(command.equals("Divorce")){
            new FenetreVueDivorce(mairie).setVisible(true);
        }

        if(command.equals("Etat personne")){
            new FenetreVueEtat(mairie).setVisible(true);
        }

        
        if (command.equals("Saisie")) {
            new FenetreVueSaisie(mairie).setVisible(true);
    
        }
    
        if(command.equals("Afficher Liste")){
            new FenetreVueListe(mairie).setVisible(true);
        }

        if (command.equals("Quitter")) {
            System.exit(0);
        }

    }
}