package Interface_graphique.Controlleur;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Interface_graphique.Modele.*;


public class EcouteurEtat implements ActionListener {
    private Mairie1 mairie;
    private JTextField idField;
    private JTextArea infoArea; // nouveau champ pour stocker la JTextArea

    public EcouteurEtat(Mairie1 mairie, JTextField idField, JTextArea infoArea) { // nouveau paramètre pour le constructeur
        this.mairie = mairie;
        this.idField = idField;
        this.infoArea = infoArea; // stocker la JTextArea dans le champ
    }

    public void actionPerformed(ActionEvent e) {
        String id = idField.getText();
        Citoyen1 citoyen = mairie.getCitoyenById(id);
        if (citoyen != null) {
            infoArea.append("ID: " + citoyen.num_id + "\n");
            infoArea.append("Nom: " + citoyen.nom + "\n");
            infoArea.append("Prénom: " + citoyen.prenom + "\n");
            infoArea.append("Sexe: " + (citoyen instanceof Homme1 ? "Homme" : "Femme") + "\n");
            infoArea.append("Date de naissance: " + citoyen.age + "\n");
    
            // Trouver le mariage qui inclut le citoyen
            Mariage1 mariage = mairie.getMariageById(id);
            if (mariage != null && (mariage.IDf.equals(id) || mariage.IDh.equals(id))) {
                // Obtenir l'autre personne dans le mariage
                String idConjoint = mariage.IDf.equals(id) ? mariage.IDh : mariage.IDf;
                Citoyen1 conjoint = mairie.getCitoyenById(idConjoint);
    
                // Afficher le nom et le prénom du conjoint
                infoArea.append("Marié(e) à: " + conjoint.nom + " " + conjoint.prenom + "\n");
            } else {
                infoArea.append("Pas marié(e)\n");
            }
        } else {
            infoArea.append("Aucun citoyen trouvé avec l'ID " + id + "\n");
        }
    }
}

    


