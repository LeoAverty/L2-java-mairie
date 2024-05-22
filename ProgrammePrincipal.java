
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
			System.out.println("  7. Quitter le programme");
			System.out.println("Choisissez une option :");
			choix = scanner.nextInt();
			scanner.nextLine(); // pour consommer le saut de ligne

			switch (choix) {
				case 1:

					System.out.println("1. saisir un mariage");
					System.out.println("2. afficher la liste des mariages ");
					choix = scanner.nextInt();
					scanner.nextLine();

					switch (choix) {
						case 1:
							System.out.println("Entrez l'ID de la femme :");
							int personne1Id = scanner.nextInt();

							while (mairie.Femmeexiste(personne1Id) == false) {
								System.out.println("ce ID n'exixte pas, please Entrez l'ID de la femme :");
								personne1Id = scanner.nextInt();
							}

							System.out.println("Entrez l'ID de l'homme :");
							int personne2Id = scanner.nextInt();
							while (mairie.Hommeexiste(personne2Id) == false) {
								System.out.println("ce ID n'exixte pas, please Entrez l'ID de l'homme :");
								personne2Id = scanner.nextInt();
							}
							

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
					System.out.println("Entrez l'ID de la femme à divorcer :");
					int femmeId = scanner.nextInt();

					System.out.println("Entrez l'ID de l'homme à divorcer :");
					int hommeID = scanner.nextInt();
					System.out.println("Entrez la date de mariage :");
					System.out.println("Annee :");
					an = scanner.nextInt();
					System.out.println("mois :");
					mm = scanner.nextInt();
					System.out.println("jour :");
					jj = scanner.nextInt();
					dateM = LocalDate.of(an, mm, jj);

					Mariage ma = new Mariage(dateM, femmeId, hommeID);
					if (mairie.existMariage(ma)) {
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

					} else {
						System.out.println("ERROR");
					}

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
						pNaissance = new Homme(idNaissance, nomNaissance, prenomNaissance, ageNaissance);
							break;
						case 2:
						pNaissance = new Femme(idNaissance, nomNaissance, prenomNaissance, ageNaissance);
							break;
						default:
							System.out.println("choix invalide : " + choix);
							break;
						}
					}
					mairie.ajoutCitoyen(pNaissance);

					Naissance naissance = new Naissance(dateM, pereId, mereId, pNaissance);	

					// mairie.ajouterNaissance(naissance);

					break;
						
				case 4:
					System.out.println("Entrez l'ID de la personne dont vous voulez connaître l'état :");
					int personneIdEtat = scanner.nextInt();
					String etat = mairie.etatPersonne(personneIdEtat);
					System.err.println(etat);
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
							p = new Homme(id, nom, prenom, age);
							break;
						case 2:
							p = new Femme(id, nom, prenom, age);
							break;
						default:
							System.out.println("choix invalide : " + choix);
							break;
						}
					}
					mairie.ajoutCitoyen(p);					
					break;
				case 7:
					System.out.println("Programme terminé.");
					break;
				default:
					System.out.println("Choix invalide.");
					break;
			}
		} while (choix != 7);

		scanner.close();
	}

}
