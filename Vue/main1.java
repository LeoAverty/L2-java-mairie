package Interface_graphique.Vue;
import Interface_graphique.Modele.*;
import java.util.Scanner;

public class main1 {
    public static void main(String[] args) {
        Mairie1 mairie = new Mairie1("Evry");
        new FenetreVueMenuPrincipal(mairie);
}
}
