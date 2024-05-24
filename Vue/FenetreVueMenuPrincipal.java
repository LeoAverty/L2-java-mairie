package Interface_graphique.Vue;
import java.awt.*;
import javax.swing.*;
import Interface_graphique.Controlleur.EcouteurMenuPrincipal;
import Interface_graphique.Modele.*;

public class FenetreVueMenuPrincipal extends JFrame {
    //Tout ce qui sera présent dans la fenêtre
    JButton Mariage= new JButton("Mariage");
    JButton Divorce= new JButton("Divorce");
    JButton Naissance= new JButton("Naissance");
    JButton Etat_personne= new JButton("Etat personne");
    JButton afficher_Liste= new JButton("Afficher Liste");
    JButton Saisie= new JButton("Saisie");
    JButton Quitter= new JButton("Quitter");
    private Mairie1 mairie;
    

    //Fentre principale
    public FenetreVueMenuPrincipal(Mairie1 mairie){
        this.mairie=mairie;
        this.setTitle("Menu principal");
        this.setSize(400, 400); // Taille de notre fentre principale 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the program when the window is closed 

        //**Orgranistion des premmier boutons
        //Definition de la colonne ainsi que du nombre de ligne
        JPanel Bouttons= new JPanel();
        GridLayout D1= new GridLayout(7,1);
        //Ajout des 7 boutons qui auront la Dispostion D1
        Bouttons.setLayout(D1);
        Bouttons.add(Mariage);
        Bouttons.add(Divorce);
        Bouttons.add(Naissance);
        Bouttons.add(Etat_personne);
        Bouttons.add(afficher_Liste);
        Bouttons.add(Saisie);
        Bouttons.add(Quitter);

        //Action des boutons ils fonctionnent avec la classe EcouteurMenuPrincipal
        EcouteurMenuPrincipal ecouteur= new EcouteurMenuPrincipal(mairie);
        Mariage.addActionListener(ecouteur);
        Divorce.addActionListener(ecouteur);
        Naissance.addActionListener(ecouteur);
        Etat_personne.addActionListener(ecouteur);
        Saisie.addActionListener(ecouteur);
        afficher_Liste.addActionListener(ecouteur);
        Quitter.addActionListener(ecouteur);
          












        //Affichage final
        
        this.add(Bouttons);
        this.setVisible(true);

        
    }
}
 