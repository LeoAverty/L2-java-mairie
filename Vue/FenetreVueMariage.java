package Interface_graphique.Vue;
import java.awt.*;
import javax.swing.*;
import Interface_graphique.Controlleur.EcouteurMariage;
import Interface_graphique.Modele.Mairie1;

public class FenetreVueMariage extends JFrame{
    //Tout ce qui sera présent dans la fenêtre
    JButton Saisie= new JButton("Saisir un mariage");
    JButton Afficher= new JButton("Afficher les mariages");
    Mairie1 mairie;

    //Fentre principale
    public FenetreVueMariage(Mairie1 mairie){
        this.mairie=mairie;
        this.setTitle("Mariage");
        this.setSize(400, 400); 

        //**Orgranistion des premmier boutons
        //Definition de la colonne ainsi que du nombre de ligne
        JPanel Bouttons= new JPanel();
        GridLayout D1= new GridLayout(2,1);
        Bouttons.setLayout(D1);
        Bouttons.add(Saisie);
        Bouttons.add(Afficher);

        //Action des boutons ils fonctionnent avec la classe EcouteurMariage
        EcouteurMariage ecouteur= new EcouteurMariage(mairie);
        Saisie.addActionListener(ecouteur);
        Afficher.addActionListener(ecouteur);

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //Affichage final
         this.add(Bouttons);
         this.setVisible(true);
      
























        



    }
    
}
