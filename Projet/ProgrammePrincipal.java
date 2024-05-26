
import java.time.LocalDate;
import java.util.Scanner;

public class ProgrammePrincipal {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//Mairie mairie = new Mairie(2, "mairie pricipal");

		Mairie mairie = new Mairie("Evry");

		int choix;
		int an, mm, jj;
		LocalDate dateM, dateD;
		do {
			// afficherMenu();

			System.out.println("Menu :");
       		System.out.println("  1. Mariage");
			System.out.println("  2. Divorce");
    		System.out.println("  3. Naissance");
        	System.out.println("  4. État d'une personne");
        	System.out.println("  5. Affichage de la liste des personnes");
        	System.out.println("  6. Saisie des personnes");
        	System.out.println("  7. Logement");
        	System.out.println("  8. Locations");
        	System.out.println("  9. Quitter le programme");
        	System.out.println("Choisissez une option :");
			choix = scanner.nextInt();
			scanner.nextLine(); // pour consommer le saut de ligne

			switch (choix) {
				case 1:

					// MARIAGE
					System.out.println("1. saisir un mariage");
					System.out.println("2. afficher la liste des mariages ");
					choix = scanner.nextInt();
					scanner.nextLine();

					switch (choix) {
						case 1:
						//Entrer l'ID de la femme 
							System.out.println("Entrez l'ID de la femme :");
							int personne1Id = scanner.nextInt();
						//Boucle pour verifier si l'ID existe et si la femme est célibataire(Méthodes: Femmeexiste et etatPersonne)
						while (mairie.Femmeexiste(personne1Id) == false || mairie.etatPersonne(personne1Id).equals("marier")) {
							if (mairie.Femmeexiste(personne1Id) == false) {
								System.out.println("ce ID n'exixte pas, please Entrez l'ID de la femme :");
							} else if (mairie.etatPersonne(personne1Id).equals("marier")) {
								System.out.println("Cette femme est déjà mariée, veuillez entrer l'ID d'une femme célibataire :");
							}
							personne1Id = scanner.nextInt();
						}
						//Entrer l'ID de l'homme
							System.out.println("Entrez l'ID de l'homme :");
							int personne2Id = scanner.nextInt();
						//Boucle pour verifier si l'ID existe et si l'hommme est célibataire (Méthodes: Hommeexiste et etatPersonne)
						while (mairie.Hommeexiste(personne2Id) == false || mairie.etatPersonne(personne2Id).equals("marier")) {
							if (mairie.Hommeexiste(personne2Id) == false) {
								System.out.println("ce ID n'exixte pas, please Entrez l'ID de l'homme :");
							} else if (mairie.etatPersonne(personne2Id).equals("marier")) {
								System.out.println("Cet homme est déjà marié, veuillez entrer l'ID d'un homme célibataire :");
							}
							personne2Id = scanner.nextInt();
						}
							
						
						//Entrer la date de mariage
							System.out.println("Entrez la date de mariage :");
							System.out.println("Annee :");
							an = scanner.nextInt();
							do {
								System.out.println("mois :");
								mm = scanner.nextInt();
							} while (mm < 1 || mm > 12);

							System.out.println("jour :");
							jj = scanner.nextInt();

							dateM = LocalDate.of(an, mm, jj);

							Mariage m = new Mariage(dateM, personne1Id, personne2Id);
							mairie.ajout_mariage(m);

							// for(Mariage ma:mairie.liste_mariage)
							// System.out.print(ma.date_mariage+" "+ma.IDf+" "+ma.IDh);

							break;

						case 2:
							mairie.afficherMariage();
							break;
					}

					break;

				case 2:
					//DIVORCE
					//Entrer l'ID de la femme 
					System.out.println("Entrez l'ID de la femme à divorcer :");
					int femmeId = scanner.nextInt();

					//Boucle pour verifier si l'ID existe et si la femme est célibataire(Méthodes: Femmeexiste et etatPersonne)
					while (mairie.Femmeexiste(femmeId) == false || !mairie.etatPersonne(femmeId).equals("marier")) {
						if (mairie.Femmeexiste(femmeId) == false) {
							System.out.println("ce ID n'exixte pas, please Entrez l'ID de la femme :");
						} else if (!mairie.etatPersonne(femmeId).equals("marier")) {
							System.out.println("Cette femme n'est pas mariée, veuillez entrer l'ID d'une femme mariée :");
						}
						femmeId = scanner.nextInt();
					}

					//Entrer l'ID de l'homme
					System.out.println("Entrez l'ID de l'homme à divorcer :");
					int hommeID = scanner.nextInt();

					// Boucle pour vérifier si l'ID existe et si l'homme est célibataire (Méthodes: Hommeexiste et etatPersonne)
					while (mairie.Hommeexiste(hommeID) == false || !mairie.etatPersonne(hommeID).equals("marier")) {
						if (mairie.Hommeexiste(hommeID) == false) {
							System.out.println("ce ID n'exixte pas, please Entrez l'ID de l'homme :");
						} else if (!mairie.etatPersonne(hommeID).equals("marier")) {
							System.out.println("Cet homme n'est pas marié, veuillez entrer l'ID d'un homme marié :");
						}
						hommeID = scanner.nextInt();
					}
					// Entrer la date de mariage 
					Mariage ma;
					do {
    				System.out.println("Entrez la date de mariage :");
    				System.out.println("Annee :");
    				an = scanner.nextInt();
    				System.out.println("mois :");
    				mm = scanner.nextInt();
    				System.out.println("jour :");
    				jj = scanner.nextInt();
    				dateM = LocalDate.of(an, mm, jj);
    				ma = new Mariage(dateM, femmeId, hommeID);

    				if (!mairie.existMariage(ma)) {
        			System.out.println("ERROR: Aucun mariage n'existe avec cette date et ces IDs. Veuillez entrer une date de mariage valide.");
    				}
					} while (!mairie.existMariage(ma));
					
					
						System.out.println("Entrez la date de divorce :");
						System.out.println("Annee :");
						an = scanner.nextInt();
						System.out.println("mois :");
						mm = scanner.nextInt();
						System.out.println("jour :");
						jj = scanner.nextInt();
						dateD = LocalDate.of(an, mm, jj);

						Divorce d = new Divorce(femmeId, hommeID, dateM, dateD);
						mairie.ajout_divorce(d);

						mairie.delete_mariage(ma);

					

					break;
				case 3:
				//NAISSANCE
					//Les deux parents
					System.out.println("Entrez l'ID du pere :");
					int pereId = scanner.nextInt();
					while (mairie.Hommeexiste(pereId) == false) {
						System.out.println("Cet ID n'exixte pas, please Entrez l'ID du pere :");
						pereId = scanner.nextInt();
					}
					System.out.println("Entrez l'ID de la mere :");
					int mereId = scanner.nextInt();
					while (mairie.Femmeexiste(mereId) == false) {
						System.out.println("Cet ID n'exixte pas, please Entrez l'ID de la mere :");
						mereId = scanner.nextInt();	
					}

					//Date de naissance
					System.out.println("Entrez la date de naissance :");
					System.out.println("Annee :");
					an = scanner.nextInt();
					System.out.println("mois :");
					mm = scanner.nextInt();
					System.out.println("jour :");
					jj = scanner.nextInt();
					dateM = LocalDate.of(an, mm, jj);

					// generate the date of birth of today


					//Nouveau né=Citoyen

					// add a static var of the id to avoid the repetition

					System.out.println("Entrez l'ID de la personne :");
					int idNaissance = scanner.nextInt();
					while (mairie.Citoyenexiste(idNaissance)) {
						System.out.println("cet ID exixte déjà, please Entrez l'ID de la personne :");
						idNaissance = scanner.nextInt();
					}

					scanner.nextLine();
					System.out.println("Entrez le nom du nouveau né :");
					String nomNaissance = scanner.nextLine();
					System.out.println("Entrez le prenom du nouveau né :");
					String prenomNaissance = scanner.nextLine();
					// is there any possibility of having a new born non enregistred till he has 2 ou 3 years old?
					System.out.println("Entrez l'age de la personne :");
					int ageNaissance = scanner.nextInt();
					scanner.nextLine();

					Citoyen pNaissance = null;
					while (pNaissance == null) {
						System.out.println("Entrez le sexe du nouveau né :");
						System.out.println("  1. homme");
						System.out.println("  2. femme");
						choix = scanner.nextInt();
						scanner.nextLine();
						switch (choix) {
						case 1:
						pNaissance = new Homme(idNaissance, nomNaissance, prenomNaissance, ageNaissance, mairie);
							break;
						case 2:
						pNaissance = new Femme(idNaissance, nomNaissance, prenomNaissance, ageNaissance, mairie);
							break;
						default:
							System.out.println("choix invalide : " + choix);
							break;
						}
					}
					mairie.ajoutCitoyen(pNaissance);
					Naissance naissance = new Naissance(dateM, pereId, mereId, pNaissance,mairie);	
					mairie.ajout_naissance(naissance);


						

					// mairie.ajouterNaissance(naissance);

					break;
						
					case 4:
					System.out.println("Entrez l'ID de la personne :");
					int IDp = scanner.nextInt();
					Citoyen c = mairie.getCitoyen(IDp);
					if (c != null) {
						System.out.println("Nom : " + c.nom);
						System.out.println("Prénom : " + c.prenom);
						System.out.println("Age : " + c.age);
						System.out.println("Sexe : " + c.getClass().getName());
						System.out.println("Etat civil : " + mairie.etatPersonne(IDp));
						Logement logement = mairie.getLogement(IDp);
						if (logement != null) {
							System.out.println("Logement : " + logement.Id_logement);
						} else {
							System.out.println("Cette personne n'a pas de logement.");
						}
					} else {
						System.out.println("Erreur : cette personne n'existe pas.");
					}
					break;
					
				case 5:
					System.out.println("Menu :");
					System.out.println("1. toutes les personnes ");
					System.out.println("2. liste des femmes");
					System.out.println("3. liste des hommes");
					choix = scanner.nextInt();
					scanner.nextLine();
					switch (choix) {
					case 1:
						mairie.afficherListePersonnes();
						break;
					case 2:
						mairie.afficherListeFemme();
						break;
					case 3:
						mairie.afficherListeHomme();
						break;
					default:
						System.out.println("choix invalide : " + choix);
						break;
					}
					break;
				case 6:
					// Ajouter le code pour le choix 6 (saisie de personne)
					// InsertPersonne p = new InsertPersonne("sisi6", "aa", "1984-02-21", 'F',
					// "celiba"); // Specify true for hasSpouse

					System.out.println("Entrez l'ID de la personne :");
					int id = scanner.nextInt();
					while (mairie.Citoyenexiste(id)) {
						System.out.println("cet ID exixte déjà, please Entrez l'ID de la personne :");
						id = scanner.nextInt();
					}

					scanner.nextLine();
					System.out.println("Entrez le nom de la personne :");
					String nom = scanner.nextLine();
					System.out.println("Entrez le prenom de la personne :");
					String prenom = scanner.nextLine();
					System.out.println("Entrez l'age de la personne :");
					int age = scanner.nextInt();
					scanner.nextLine();

					Citoyen p = null;
					while (p == null) {
						System.out.println("Entrez le sexe de la personne :");
						System.out.println("  1. homme");
						System.out.println("  2. femme");
						choix = scanner.nextInt();
						scanner.nextLine();
						switch (choix) {
						case 1:
							p = new Homme(id, nom, prenom, age, mairie);
							break;
						case 2:
							p = new Femme(id, nom, prenom, age, mairie);
							break;
						default:
							System.out.println("choix invalide : " + choix);
							break;
						}
					}
					mairie.ajoutCitoyen(p);					
					break;
					case 7:
					//LOGEMENT
					System.out.println("1. Saisir un logement");
					System.out.println("2. Vue logemements");
					choix = scanner.nextInt();
					scanner.nextLine();
				
					switch (choix) {
						case 1:
							System.out.println("Entrez la superficie du logement :");
							int superficie = scanner.nextInt();
							System.out.println("Le logement est-il meublé ? (true/false)");
							boolean meuble = scanner.nextBoolean();
							System.out.println("Entrez l'ID du logement :");
							int Id_logement = scanner.nextInt();
							System.out.println("Entrez le nombre de places libres :");
							int placesLibres = scanner.nextInt();
							Logement logement = new Logement(superficie, meuble, Id_logement, placesLibres);
							mairie.ajout_logement(logement);
							break;
						case 2:
							mairie.afficherListeLogements();
							break;
						default:
							System.out.println("Choix invalide.");
							break;
					}
					break;
				
					case 8:
					//LOCATIONS
					System.out.println("1. Saisir une location");
					System.out.println("2. Vue locations");
					choix = scanner.nextInt();
					scanner.nextLine();
				
					switch(choix){
						case 1:
							System.out.println("Entrez l'ID du locataire :");
							int IDlocataire = scanner.nextInt();
							while (!mairie.Citoyenexiste(IDlocataire)) {
								System.out.println("cet ID n'exixte pas, please Entrez l'ID de la personne :");
								IDlocataire = scanner.nextInt();
							}
							System.out.println("Entrez l'ID du logement :");
							int IDlogement = scanner.nextInt();
							while (!mairie.logementExiste(IDlogement)) {
								System.out.println("cet ID n'exixte pas, please Entrez un ID de logement :");
								IDlogement = scanner.nextInt();
							}   
							Logement logement = mairie.getLogement(IDlogement);
							if (logement.PlacesLibres <= 0) {
								System.out.println("Pas de places libres dans ce logement.");
								break;
							}
							System.out.println("Entrez la date de début de la location :");
							System.out.println("Annee :");
							an = scanner.nextInt();
							System.out.println("mois :");
							mm = scanner.nextInt();
							System.out.println("jour :");
							jj = scanner.nextInt();
							dateD = LocalDate.of(an, mm, jj);
							System.out.println("Entrez la date de fin de la location :");
							System.out.println("Annee :");
							an = scanner.nextInt();
							System.out.println("mois :");
							mm = scanner.nextInt();
							System.out.println("jour :");
							jj = scanner.nextInt();
							dateM = LocalDate.of(an, mm, jj);
							Citoyen citoyen = mairie.getCitoyen(IDlocataire);
							Location location = new Location(dateD, dateM, logement, citoyen);
							mairie.ajout_location(location);
							break;
						case 2:
							mairie.afficherListeLocations();
							break;
						default:
							System.out.println("Choix invalide.");
							break;
					}
					break;
				case 9:
					System.out.println("Programme terminé.");
					break;
				default:
					System.out.println("Choix invalide.");
					break;
			}
		} while (choix != 9);

		scanner.close();
	}

}