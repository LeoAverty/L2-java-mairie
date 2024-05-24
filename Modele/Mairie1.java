package Interface_graphique.Modele;

import java.util.Vector;


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

public class Mairie1 {

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
    public Vector<Citoyen1> citoyens = new Vector<Citoyen1>();

	///////
	
    // public Vector<Integer> liste_femme = new Vector<Integer>();
    // public Vector<Integer> liste_homme = new Vector<Integer>();

    public Vector<Mariage1> liste_mariage = new Vector<Mariage1>();
    // public List<Mariage> liste_mariage = new ArrayList<Mariage>();
    public Vector<Naissance1> liste_naissance = new Vector<Naissance1>();
    public Vector<Divorce1> liste_Divorce = new Vector<Divorce1>();
   
    // // Constructeur prenant le nom de la mairie
    // public Mairie(int id_mairie, String n) {
    //     this.id_mairie = id_mairie;
    //     this.nom_mairie = n;
    // }
	// Constructeur prenant le nom de la mairie
	public Mairie1(String nom) {
		this.nom = nom;
	}

	// public void ajouter_femme(int id) {
	// 	liste_femme.add(id);
	// }

	// public void ajouter_homme(int id) {
	// 	liste_homme.add(id);
	// }

	// Méthode pour ajouter un mariage à la liste des mariages
	public void ajout_mariage(Mariage1 m) {
		liste_mariage.add(m);
	}

	///////////////////// pour supprimer
	public void delete_mariage(Mariage1 m) {
		liste_mariage.remove(m);
	}



    // Méthode pour ajouter une naissance à la liste des naissances
    public void ajout_naissance(Naissance1 n) {
        liste_naissance.add(n);
    }

    public void ajoutCitoyen(Citoyen1 c) {
        citoyens.add(c);
    }

    public void ajout_divorce(Divorce1 d) {
        liste_Divorce.add(d);
    }

	/**
	 * Affiche la liste des personnes (nom, age, etc).
	 */
    public void afficherListePersonnes() {
        for (Citoyen1 citoyen : citoyens) {
            System.out.println(citoyen.getClass().getName() + " " + citoyen.num_id + "     " + citoyen.nom + "     " + citoyen.prenom + "     " + citoyen.age);
        }
    }

    

    public void afficherMariage(){

        for (Mariage1 m: liste_mariage){
            System.err.println("Le :"+m.jour+"/"+m.mois+"/"+m.annee+" "+m.IDf+" avec "+m.IDh );
        }
        
            }

	/**
	 * Affiche la liste des femmes (que les ids , lol ?)
	 */
	public void afficherListeFemme() {
		// for (Integer id : liste_femme)
		// 	System.out.println(id);
		for (Citoyen1 citoyen : citoyens) {
			if (citoyen instanceof Femme1)
				System.out.println(citoyen.num_id + "     " + citoyen.nom + "     " + citoyen.prenom + "     " + citoyen.age);
		}
	}

	/**
	 * Affiche la liste des hommes (que les ids , lol ?)
	 */
	public void afficherListeHomme() {
		// for (Integer id : liste_homme)
		// 	System.out.println(id);
		for (Citoyen1 citoyen : citoyens) {
			if (citoyen instanceof Homme1)
				System.out.println(citoyen.num_id + "     " + citoyen.nom + "     " + citoyen.prenom + "     " + citoyen.age);
		}
	}

    public boolean existMariage(Mariage1 m) {
        for(Mariage1 ma:liste_mariage) {
            if (ma.getDate().equals(m.getDate()) && ma.IDf.equals(m.IDf) && ma.IDh.equals(m.IDh))
                return true;
        }
        return false;
    }
    
    public boolean existeDIVORCE(Mariage1 m){
        for(Divorce1 d:liste_Divorce) {
            if(d.getDate().equals(m.getDate()) && d.idF.equals(m.IDf) && d.idH.equals(m.IDh))
                return true;
        }
        return false;
    }

    public boolean Citoyenexiste(Citoyen1 p) {
        for(Citoyen1 c:citoyens)
            if(c.nom.equals(p.nom)&& c.prenom.equals(p.prenom )&& c.age==p.age)
                return true;
        return false;  
        
    }

    public boolean Citoyenexiste(String id) {
        for (Citoyen1 c : citoyens) {
            if (c.num_id.equals(id)) {
                return true;
            }
        }
        return false;
    }

    // public boolean Femmeexiste(int id)
    // {
    //     for(Integer f:liste_femme)
    //         if(f==id)
    //             return true;
    //     return false;  
        
    // }
	public boolean Femmeexiste(String id) {
		for (Citoyen1 c : citoyens)
			if (c.num_id.equals(id))
				return c instanceof Femme1;
		return false;
	}
    
    // public boolean Hommeexiste(int id)
    // {
    //     for(Integer h:liste_homme)
    //         if(h==id)
    //             return true;
    //     return false;  
        
    // }
	public boolean Hommeexiste(String id) {
		for (Citoyen1 c : citoyens)
			if (c.num_id.equals(id))
				return c instanceof Homme1;
		return false;
	}


    public String etatPersonne(String id) {
        for (Mariage1 m : liste_mariage) {
            if (m.IDf.equals(id) || m.IDh.equals(id)) {
                if (existeDIVORCE(m)) {
                    return "divorcé";
                } else {
                    return "marié";
                }
            }
        }
        return "célibataire";
    }


    
    
 public Homme1 getHommeById(String id) {
        for (Citoyen1 citoyen : citoyens) {
            if (citoyen instanceof Homme1 && citoyen.num_id.equals(id)) {
                return (Homme1) citoyen;
            }
        }
        return null; // ou lancez une exception si l'ID n'est pas trouvé
    }
    
    public Femme1 getFemmeById(String id) {
        for (Citoyen1 citoyen : citoyens) {
            if (citoyen instanceof Femme1 && citoyen.num_id.equals(id)) {
                return (Femme1) citoyen;
            }
        }
        return null; // ou lancez une exception si l'ID n'est pas trouvé
    }

    public Citoyen1 getCitoyenById(String id) {
        for (Citoyen1 citoyen : citoyens) {
            if (citoyen.num_id.equals(id)) {
                return citoyen;
            }
        }
        return null; // ou lancez une exception si l'ID n'est pas trouvé
    }
    public Mariage1 getMariageById(String id) {
        for (Mariage1 mariage : liste_mariage) {
            if (mariage.IDf.equals(id) || mariage.IDh.equals(id)) {
                return mariage;
            }
        }
        return null; // ou lancez une exception si l'ID n'est pas trouvé
    }
    public Divorce1 getDivorceById(String id) {
        for (Divorce1 divorce : liste_Divorce) {
            if (divorce.idF.equals(id) || divorce.idH.equals(id)) {
                return divorce;
            }
        }
        return null; // ou lancez une exception si l'ID n'est pas trouvé
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

 