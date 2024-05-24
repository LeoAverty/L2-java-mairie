package Interface_graphique.Vue;
import java.awt.*;
import javax.swing.*;
import Interface_graphique.Controlleur.EcouteurSaisie;
import Interface_graphique.Modele.Mairie1;

public class FenetreVueSaisie extends JFrame{
    //Tout ce qui sera présent dans la fenêtre
    JTextField idField = new JTextField(10);
    JTextField nomField = new JTextField(10);
    JTextField prenomField = new JTextField(10);
    JTextField ageField = new JTextField(10);
    JButton hommeButton = new JButton("Homme");
    JButton femmeButton = new JButton("Femme");
    
    Mairie1 mairie;

    //Fenetre principale
    public FenetreVueSaisie(Mairie1 mairie) {
        this.mairie=mairie;
        this.setTitle("Saisie d'une personne");
        this.setSize(300, 200);
        

        // Création d'un panel avec un GridLayout pour organiser les champs de texte
        JPanel textes= new JPanel();
        GridLayout D1= new GridLayout(5,2);
        // Ajout des labels et des champs de texte au panel
        textes.setLayout(D1);
        textes.add(new JLabel("ID:"));
        textes.add(idField);
        textes.add(new JLabel("Nom:"));
        textes.add(nomField);
        textes.add(new JLabel("Prenom:"));
        textes.add(prenomField);
        textes.add(new JLabel("Age:"));
        textes.add(ageField);
        textes.add(hommeButton);
        textes.add(femmeButton);
        
        
        //action des boutons ils fonctionnent avec la classe EcouteurSaisie
        EcouteurSaisie ecouteurHomme = new EcouteurSaisie(idField, nomField, prenomField, ageField, "homme", mairie, this);
        EcouteurSaisie ecouteurFemme = new EcouteurSaisie(idField, nomField, prenomField, ageField, "femme", mairie, this);
        hommeButton.addActionListener(ecouteurHomme);
        femmeButton.addActionListener(ecouteurFemme);
    
        // Ajout des panels à la fenetre 
        //Plusieurs panels= setLayout pour la fenetre
        this.setLayout(new BorderLayout());
        this.add(textes, BorderLayout.CENTER);
        this.setVisible(true);
        
    }




    
    
}
