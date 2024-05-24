package Interface_graphique.Modele;

import java.time.*;

/**
 * Qui est né, quand et où.
 */
public class Naissance1 {

	/**
	 * Date de naissance.
	 */
	private LocalDate dateNaissance;

	public String IDf, IDh;

	/**
	 * C'est la mère.
	 */
	private Femme1 femme;

	/**
	 * C'est le père.
	 */
	private Homme1 homme;

	/**
	 * Qui est né.
	 */
	private Citoyen1 citoyen;

	/**
	 * Lieu de naissance.
	 */
	private Mairie1 mairie;

	/**
	 * Default constructor
	 */
	public Naissance1(LocalDate dateNaissance, String IDh, String IDf,  Citoyen1 enfant, Mairie1 mairie) {
		this.dateNaissance = dateNaissance;
		this.IDf = IDf;
		this.IDh = IDh;
		this.citoyen = enfant;
		this.mairie = mairie;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public Femme1 getFemme() {
		return this.femme;
	}

	public Homme1 getHomme() {
		return this.homme;
	}

	public Citoyen1 getCitoyen() {
		return this.citoyen;
	}

	public Mairie1 getMairie() {
		return this.mairie;
	}
	// On met en private pour ne pas que l'on puisse modifier ultérieurement mais les méthodes get...
	// sont là pour pouvoir accéder aux valeurs.
}