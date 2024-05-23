
import java.util.*;

// /**
//  * 
//  */
// public class Mairie {

//     /**
//      * Default constructor
//      */
//     public Mairie(String n) {
//         this.nom_mairie = n;
//     }

//     /**
//      * 
//      */
//     public String nom_mairie;

//     /**
//      * 
//      */
//     public Vector<Mariage> liste_mariage = new Vector<Mariage>();


//     /**
//      * 
//      */
//     public Vector<Deces> liste_deces = new Vector<Deces>();


//     /**
//      * 
//      */
//     public Vector<Logement> liste_logement = new Vector<Logement>();

//     /**
//      * 
//      */
//     public Vector<Naissance> liste_naissance = new Vector<Naissance>();

//     public void ajout_mariage(Mariage m)
//     {
//         liste_mariage.add(m);
//     }

//     public void ajout_deces(Deces d)
//     {
//         liste_mariage.add(d);
//     }

//     public void ajout_logement(Logement l)
//     {
//         liste_mariage.add(l);
//     }

//     public void ajout_naissance(Naissance n)
//     {
//         liste_mariage.add(n);
//     }
// }

// import java.time.LocalDate;
//import java.util.*;

public class Mairie {

	// /**
	//  * Identifiant unique, il peut y avoir plusieur maries.
	//  */
    // public int id_mairie;

	/**
	 * Nom.
	 */
    public String nom;

	/**
	 * Liste des citoyens.
	 */
    public Vector<Citoyen> citoyens = new Vector<Citoyen>();

	///////
	
    // public Vector<Integer> liste_femme = new Vector<Integer>();
    // public Vector<Integer> liste_homme = new Vector<Integer>();

    public Vector<Mariage> liste_mariage = new Vector<Mariage>();
    // public List<Mariage> liste_mariage = new ArrayList<Mariage>();
    public Vector<Deces> liste_deces = new Vector<Deces>();
    public Vector<Logement> liste_logement = new Vector<Logement>();
    public Vector<Naissance> liste_naissance = new Vector<Naissance>();
    public Vector<Divorce> liste_Divorce = new Vector<Divorce>();
   
    // // Constructeur prenant le nom de la mairie
    // public Mairie(int id_mairie, String n) {
    //     this.id_mairie = id_mairie;
    //     this.nom_mairie = n;
    // }
	// Constructeur prenant le nom de la mairie
	public Mairie(String nom) {
		this.nom = nom;
	}

	// public void ajouter_femme(int id) {
	// 	liste_femme.add(id);
	// }

	// public void ajouter_homme(int id) {
	// 	liste_homme.add(id);
	// }

	// Méthode pour ajouter un mariage à la liste des mariages
	public void ajout_mariage(Mariage m) {
		liste_mariage.add(m);
	}

	///////////////////// pour supprimer
	public void delete_mariage(Mariage m) {
		liste_mariage.remove(m);
	}

    // Méthode pour ajouter un décès à la liste des décès
    public void ajout_deces(Deces d) {
        liste_deces.add(d);
    }

    // Méthode pour ajouter un logement à la liste des logements
    public void ajout_logement(Logement l) {
        liste_logement.add(l);
    }

    // Méthode pour ajouter une naissance à la liste des naissances
    public void ajout_naissance(Naissance n) {
        liste_naissance.add(n);
    }

    public void ajoutCitoyen(Citoyen c) {
        citoyens.add(c);
    }

    public void ajout_divorce(Divorce d) {
        liste_Divorce.add(d);
    }

	/**
	 * Affiche la liste des personnes (nom, age, etc).
	 */
    public void afficherListePersonnes() {
        for (Citoyen citoyen : citoyens) {
            System.out.println(citoyen.getClass().getName() + " " + citoyen.num_id + "     " + citoyen.nom + "     " + citoyen.prenom + "     " + citoyen.age);
        }
    }

	/**
	 * Affiche la liste des femmes (que les ids , lol ?)
	 */
	public void afficherListeFemme() {
		// for (Integer id : liste_femme)
		// 	System.out.println(id);
		for (Citoyen citoyen : citoyens) {
			if (citoyen instanceof Femme)
				System.out.println(citoyen.num_id + "     " + citoyen.nom + "     " + citoyen.prenom + "     " + citoyen.age);
		}
	}

	/**
	 * Affiche la liste des hommes (que les ids , lol ?)
	 */
	public void afficherListeHomme() {
		// for (Integer id : liste_homme)
		// 	System.out.println(id);
		for (Citoyen citoyen : citoyens) {
			if (citoyen instanceof Homme)
				System.out.println(citoyen.num_id + "     " + citoyen.nom + "     " + citoyen.prenom + "     " + citoyen.age);
		}
	}

    public boolean existMariage(Mariage m) {
        for(Mariage ma:liste_mariage) {
            if (ma.date_mariage.isEqual(m.date_mariage) && ma.IDf == m.IDf && ma.IDh == m.IDh)
                return true;
        }
        return false;
    }
    
    public boolean existeDIVORCE(Mariage m){
        for(Divorce d:liste_Divorce) {
            if(d.date_mariage.isEqual(m.date_mariage) && d.idF == m.IDf && d.idH == m.IDh)
                return true;
        }
        return false;
    }

    public boolean Citoyenexiste(Citoyen p) {
        for(Citoyen c:citoyens)
            if(c.nom.equals(p.nom)&& c.prenom.equals(p.prenom )&& c.age==p.age)
                return true;
        return false;  
        
    }

    public boolean Citoyenexiste(int id) {
        for (Citoyen c : citoyens)
            if (c.num_id == id)
                return true;
        return false;  
        
    }

    // public boolean Femmeexiste(int id)
    // {
    //     for(Integer f:liste_femme)
    //         if(f==id)
    //             return true;
    //     return false;  
        
    // }
	public boolean Femmeexiste(int id) {
		for (Citoyen c : citoyens)
			if (c.num_id == id)
				return c instanceof Femme;
		return false;
	}
    
    // public boolean Hommeexiste(int id)
    // {
    //     for(Integer h:liste_homme)
    //         if(h==id)
    //             return true;
    //     return false;  
        
    // }
	public boolean Hommeexiste(int id) {
		for (Citoyen c : citoyens)
			if (c.num_id == id)
				return c instanceof Homme;
		return false;
	}


    public String etatPersonne(int id) {
        for (int i = liste_mariage.size() - 1; i >= 0; i--) {
            Mariage m = liste_mariage.get(i);
            if (m.IDf == id || m.IDh == id) {
                if (existeDIVORCE(m)) {
                    return "Divorcee";
                } else {
                    return "marier";
                }
            }
        }
        return "celiba";
    }


    public void afficherMariage(){

for (Mariage m: liste_mariage){
    System.err.println(m.date_mariage+" "+m.IDf+" "+m.IDh );
}

    }
    //Getter de citoyen (à placer ici)
    public Citoyen getCitoyen(int id) {
        for (Citoyen c : citoyens)
            if (c.num_id == id)
                return c;
        return null;  
    }





   
        // public static void main(String[] args) {
        // // Création d'une instance de la classe Mairie
        //     Mairie mairie = new Mairie(1,"Mairie principale");
    
        // // Création de quelques objets Mariage
        //     Mariage mariage1 = new Mariage(LocalDate.of(2024,02,21),1,2);
        //     Mariage mariage2 = new Mariage(LocalDate.of(2024,02,21),1,2);
        //     // Mariage mariage3 = new Mariage(/* paramètres du mariage */);
    
        // // Ajout des mariages à la liste des mariages de la mairie
        //     mairie.ajout_mariage(mariage1);
        //     mairie.ajout_mariage(mariage2);
        //     // mairie.ajout_mariage(mariage3);
    
        // // Affichage de la liste des mariages
        //     afficherListeMariages(mairie);
        // }
    
        // // Méthode pour afficher la liste des mariages
        // public static void afficherListeMariages(Mairie mairie) {
        //     System.out.println("Liste des mariages :");
        //     for (Mariage mariage : mairie.liste_mariage) {
        //         // Ajoutez ici le code pour afficher les détails de chaque mariage
        //         System.out.println(mariage);
        //     }
        // }
    
    


}
import java.util.*;

// /**
//  * 
//  */
// public class Mairie {

//     /**
//      * Default constructor
//      */
//     public Mairie(String n) {
//         this.nom_mairie = n;
//     }

//     /**
//      * 
//      */
//     public String nom_mairie;

//     /**
//      * 
//      */
//     public Vector<Mariage> liste_mariage = new Vector<Mariage>();


//     /**
//      * 
//      */
//     public Vector<Deces> liste_deces = new Vector<Deces>();


//     /**
//      * 
//      */
//     public Vector<Logement> liste_logement = new Vector<Logement>();

//     /**
//      * 
//      */
//     public Vector<Naissance> liste_naissance = new Vector<Naissance>();

//     public void ajout_mariage(Mariage m)
//     {
//         liste_mariage.add(m);
//     }

//     public void ajout_deces(Deces d)
//     {
//         liste_mariage.add(d);
//     }

//     public void ajout_logement(Logement l)
//     {
//         liste_mariage.add(l);
//     }

//     public void ajout_naissance(Naissance n)
//     {
//         liste_mariage.add(n);
//     }
// }

// import java.time.LocalDate;
//import java.util.*;

public class Mairie {

	// /**
	//  * Identifiant unique, il peut y avoir plusieur maries.
	//  */
    // public int id_mairie;

	/**
	 * Nom.
	 */
    public String nom;

	/**
	 * Liste des citoyens.
	 */
    public Vector<Citoyen> citoyens = new Vector<Citoyen>();

	///////
	
    // public Vector<Integer> liste_femme = new Vector<Integer>();
    // public Vector<Integer> liste_homme = new Vector<Integer>();

    public Vector<Mariage> liste_mariage = new Vector<Mariage>();
    // public List<Mariage> liste_mariage = new ArrayList<Mariage>();
    public Vector<Deces> liste_deces = new Vector<Deces>();
    public Vector<Logement> liste_logement = new Vector<Logement>();
    public Vector<Naissance> liste_naissance = new Vector<Naissance>();
    public Vector<Divorce> liste_Divorce = new Vector<Divorce>();
   
    // // Constructeur prenant le nom de la mairie
    // public Mairie(int id_mairie, String n) {
    //     this.id_mairie = id_mairie;
    //     this.nom_mairie = n;
    // }
	// Constructeur prenant le nom de la mairie
	public Mairie(String nom) {
		this.nom = nom;
	}

	// public void ajouter_femme(int id) {
	// 	liste_femme.add(id);
	// }

	// public void ajouter_homme(int id) {
	// 	liste_homme.add(id);
	// }

	// Méthode pour ajouter un mariage à la liste des mariages
	public void ajout_mariage(Mariage m) {
		liste_mariage.add(m);
	}

	///////////////////// pour supprimer
	public void delete_mariage(Mariage m) {
		liste_mariage.remove(m);
	}

    // Méthode pour ajouter un décès à la liste des décès
    public void ajout_deces(Deces d) {
        liste_deces.add(d);
    }

    // Méthode pour ajouter un logement à la liste des logements
    public void ajout_logement(Logement l) {
        liste_logement.add(l);
    }

    // Méthode pour ajouter une naissance à la liste des naissances
    public void ajout_naissance(Naissance n) {
        liste_naissance.add(n);
    }

    public void ajoutCitoyen(Citoyen c) {
        citoyens.add(c);
    }

    public void ajout_divorce(Divorce d) {
        liste_Divorce.add(d);
    }

	/**
	 * Affiche la liste des personnes (nom, age, etc).
	 */
    public void afficherListePersonnes() {
        for (Citoyen citoyen : citoyens) {
            System.out.println(citoyen.getClass().getName() + " " + citoyen.num_id + "     " + citoyen.nom + "     " + citoyen.prenom + "     " + citoyen.age);
        }
    }

	/**
	 * Affiche la liste des femmes (que les ids , lol ?)
	 */
	public void afficherListeFemme() {
		// for (Integer id : liste_femme)
		// 	System.out.println(id);
		for (Citoyen citoyen : citoyens) {
			if (citoyen instanceof Femme)
				System.out.println(citoyen.num_id + "     " + citoyen.nom + "     " + citoyen.prenom + "     " + citoyen.age);
		}
	}

	/**
	 * Affiche la liste des hommes (que les ids , lol ?)
	 */
	public void afficherListeHomme() {
		// for (Integer id : liste_homme)
		// 	System.out.println(id);
		for (Citoyen citoyen : citoyens) {
			if (citoyen instanceof Homme)
				System.out.println(citoyen.num_id + "     " + citoyen.nom + "     " + citoyen.prenom + "     " + citoyen.age);
		}
	}

    public boolean existMariage(Mariage m) {
        for(Mariage ma:liste_mariage) {
            if (ma.date_mariage.isEqual(m.date_mariage) && ma.IDf == m.IDf && ma.IDh == m.IDh)
                return true;
        }
        return false;
    }
    
    public boolean existeDIVORCE(Mariage m){
        for(Divorce d:liste_Divorce) {
            if(d.date_mariage.isEqual(m.date_mariage) && d.idF == m.IDf && d.idH == m.IDh)
                return true;
        }
        return false;
    }

    public boolean Citoyenexiste(Citoyen p) {
        for(Citoyen c:citoyens)
            if(c.nom.equals(p.nom)&& c.prenom.equals(p.prenom )&& c.age==p.age)
                return true;
        return false;  
        
    }

    public boolean Citoyenexiste(int id) {
        for (Citoyen c : citoyens)
            if (c.num_id == id)
                return true;
        return false;  
        
    }

    // public boolean Femmeexiste(int id)
    // {
    //     for(Integer f:liste_femme)
    //         if(f==id)
    //             return true;
    //     return false;  
        
    // }
	public boolean Femmeexiste(int id) {
		for (Citoyen c : citoyens)
			if (c.num_id == id)
				return c instanceof Femme;
		return false;
	}
    
    // public boolean Hommeexiste(int id)
    // {
    //     for(Integer h:liste_homme)
    //         if(h==id)
    //             return true;
    //     return false;  
        
    // }
	public boolean Hommeexiste(int id) {
		for (Citoyen c : citoyens)
			if (c.num_id == id)
				return c instanceof Homme;
		return false;
	}


    public String etatPersonne(int id) {
        for (int i = liste_mariage.size() - 1; i >= 0; i--) {
            Mariage m = liste_mariage.get(i);
            if (m.IDf == id || m.IDh == id) {
                if (existeDIVORCE(m)) {
                    return "Divorcee";
                } else {
                    return "marier";
                }
            }
        }
        return "celiba";
    }


    public void afficherMariage(){

for (Mariage m: liste_mariage){
    System.err.println(m.date_mariage+" "+m.IDf+" "+m.IDh );
}

    }
    //Getter de citoyen (à placer ici)
    public Citoyen getCitoyen(int id) {
        for (Citoyen c : citoyens)
            if (c.num_id == id)
                return c;
        return null;  
    }





   
        // public static void main(String[] args) {
        // // Création d'une instance de la classe Mairie
        //     Mairie mairie = new Mairie(1,"Mairie principale");
    
        // // Création de quelques objets Mariage
        //     Mariage mariage1 = new Mariage(LocalDate.of(2024,02,21),1,2);
        //     Mariage mariage2 = new Mariage(LocalDate.of(2024,02,21),1,2);
        //     // Mariage mariage3 = new Mariage(/* paramètres du mariage */);
    
        // // Ajout des mariages à la liste des mariages de la mairie
        //     mairie.ajout_mariage(mariage1);
        //     mairie.ajout_mariage(mariage2);
        //     // mairie.ajout_mariage(mariage3);
    
        // // Affichage de la liste des mariages
        //     afficherListeMariages(mairie);
        // }
    
        // // Méthode pour afficher la liste des mariages
        // public static void afficherListeMariages(Mairie mairie) {
        //     System.out.println("Liste des mariages :");
        //     for (Mariage mariage : mairie.liste_mariage) {
        //         // Ajoutez ici le code pour afficher les détails de chaque mariage
        //         System.out.println(mariage);
        //     }
        // }
    
    


}
