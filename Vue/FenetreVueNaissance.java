package Interface_graphique.Vue;
import java.awt.*;
import java.util.Calendar;
import javax.swing.*;
import Interface_graphique.Controlleur.*;
import Interface_graphique.Modele.*;

public class FenetreVueNaissance extends JFrame {
    // Tout ce qui sera présent dans la fenêtre
    JTextField IDPere = new JTextField(10);
    JTextField IDMere = new JTextField(10);
    JTextField IDenfant = new JTextField(10);
    JTextField nomEnfant = new JTextField(10);
    JTextField prenomEnfant = new JTextField(10);
    JTextField ageEnfant= new JTextField(10);
    JButton hommeButton = new JButton("Homme");
    JButton femmeButton = new JButton("Femme");
    Mairie1 mairie;

    // Fenêtre principale
    public FenetreVueNaissance(Mairie1 mairie) {
        this.mairie = mairie;
        this.setTitle("Saisie de mariage");
        this.setSize(400, 200); // Taille de notre fenêtre principale
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window on close

        // Création d'un panel avec un GridLayout pour organiser les champs de texte
        JPanel textes = new JPanel();
        GridLayout D1 = new GridLayout(7, 2);
        JPanel date = new JPanel();
        date.setLayout(new FlowLayout());


        // Ajout des labels et des champs de texte au panel
        textes.setLayout(D1);
        textes.add(new JLabel("ID Pere:"));
        textes.add(IDPere);
        textes.add(new JLabel("ID Mere:"));
        textes.add(IDMere);
        textes.add(new JLabel("ID Enfant:"));
        textes.add(IDenfant);
        textes.add(new JLabel("Nom Enfant:"));
        textes.add(nomEnfant);
        textes.add(new JLabel("Prenom Enfant:"));
        textes.add(prenomEnfant);
        textes.add(new JLabel("Age Enfant:"));
        textes.add(ageEnfant);
        textes.add(hommeButton);
        textes.add(femmeButton);

        // Action des boutons, ils fonctionnent avec la classe EcouteurMariage1
        EcouteurNaissance ecouteurHomme = new EcouteurNaissance(IDPere, IDMere, IDenfant, nomEnfant,prenomEnfant,ageEnfant, "homme", mairie, this);
        EcouteurNaissance ecouteurFemme = new EcouteurNaissance(IDPere, IDMere, IDenfant, nomEnfant,prenomEnfant,ageEnfant, "femme", mairie, this);
        hommeButton.addActionListener(ecouteurHomme);
        femmeButton.addActionListener(ecouteurFemme);

        // Affichage final
        this.setLayout(new BorderLayout());
        this.add(textes, BorderLayout.CENTER);
        this.setVisible(true);
    }
}
