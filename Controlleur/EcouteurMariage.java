package Interface_graphique.Controlleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Interface_graphique.Vue.*;
import Interface_graphique.Modele.*;

public class EcouteurMariage implements ActionListener{
    Mairie1 mairie;

    public EcouteurMariage(Mairie1 mairie) {
        this.mairie = mairie;
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("Saisir un mariage")) {
            new FenetreVueMariage1(mairie).setVisible(true);
    
        }
        else if(command.equals("Afficher les mariages")){
            new FenetreVueMariage2(mairie).setVisible(true);
        
    }
    
}
}
