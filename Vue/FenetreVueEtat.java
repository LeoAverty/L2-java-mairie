package Interface_graphique.Vue;
import java.awt.*;
import javax.swing.*;
import Interface_graphique.Controlleur.*;
import Interface_graphique.Modele.*;

public class FenetreVueEtat extends JFrame{
    JTextField idField = new JTextField(10);
    JButton Entrer = new JButton("OK");
    Mairie1 mairie;

    //Fentre pirncipale
    public FenetreVueEtat (Mairie1 mairie){
        this.mairie = mairie;
        this.setTitle("Saisie d'une personne");
        this.setSize(200, 500);

    // Création d'un panel avec un GridLayout pour organiser les champs de texte
    JPanel texte = new JPanel();
    texte.setLayout(new FlowLayout());

    // Création de la JTextArea pour afficher les informations
    JTextArea infoArea = new JTextArea(5, 20);
    infoArea.setEditable(false); // rendre la JTextArea non éditable

    



    // Ajout des labels et des champs de texte au panel
    texte.add(new JLabel("IDentifiant:"));
    texte.add(idField);
    
    



    //Action des boutons ils fonctionnent avec la classe EcouteurMariage
    EcouteurEtat ecouteur= new EcouteurEtat(mairie, idField,infoArea);
    Entrer.addActionListener(ecouteur);


    // Affichage final
    System.out.println("affichage en cours");
    this.setLayout(new BorderLayout());
    this.add(texte, BorderLayout.NORTH);
    this.add(infoArea, BorderLayout.CENTER); // ajouter la JTextArea à la fenêtre
    this.add(Entrer, BorderLayout.SOUTH);
    this.pack();
    this.setVisible(true);

    

        
    }

    





















}