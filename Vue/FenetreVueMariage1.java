package Interface_graphique.Vue;
import java.awt.*;
import java.util.Calendar;
import javax.swing.*;
import Interface_graphique.Controlleur.*;
import Interface_graphique.Modele.*;

public class FenetreVueMariage1 extends JFrame {
    // Tout ce qui sera présent dans la fenêtre
    JTextField IDhomme = new JTextField(10);
    JTextField IDfemme = new JTextField(10);
    JComboBox<String> jourBox = new JComboBox<>();
    JComboBox<String> moisBox = new JComboBox<>();
    JComboBox<String> anneeBox = new JComboBox<>();
    JButton Entrer = new JButton("OK");
    Mairie1 mairie;

    // Fenêtre principale
    public FenetreVueMariage1(Mairie1 mairie) {
        this.mairie = mairie;
        this.setTitle("Saisie de mariage");
        this.setSize(400, 200); // Taille de notre fenêtre principale
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window on close

        // Création d'un panel avec un GridLayout pour organiser les champs de texte
        JPanel textes = new JPanel();
        GridLayout D1 = new GridLayout(4, 2);
        JPanel date = new JPanel();
        date.setLayout(new FlowLayout());

        // Remplissage des JComboBox
        for (int i = 1; i <= 31; i++) {
            jourBox.addItem(String.format("%02d", i));
        }
        for (int i = 1; i <= 12; i++) {
            moisBox.addItem(String.format("%02d", i));
        }
        for (int i = 1900; i <= Calendar.getInstance().get(Calendar.YEAR); i++) {
            anneeBox.addItem(Integer.toString(i));
        }

        date.add(jourBox);
        date.add(moisBox);
        date.add(anneeBox);

        // Ajout des labels et des champs de texte au panel
        textes.setLayout(D1);
        textes.add(new JLabel("ID homme:"));
        textes.add(IDhomme);
        textes.add(new JLabel("ID femme:"));
        textes.add(IDfemme);
        textes.add(new JLabel("Date mariage:"));
        textes.add(date);

        // Action des boutons, ils fonctionnent avec la classe EcouteurMariage1
        EcouteurMariage1 ecouteurMariage1 = new EcouteurMariage1(IDhomme, IDfemme, jourBox, moisBox, anneeBox, mairie, this);
        Entrer.addActionListener(ecouteurMariage1);

        // Affichage final
        this.setLayout(new BorderLayout());
        this.add(textes, BorderLayout.CENTER);
        this.add(Entrer, BorderLayout.SOUTH);
        this.setVisible(true);
    }
}
