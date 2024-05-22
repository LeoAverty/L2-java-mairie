

import java.time.*;

/**
 * Qui est né, quand et où.
 */
public class Naissance {

	/**
	 * Date de naissance.
	 */
	private LocalDate dateNaissance;

	/**
	 * C'est la mère.
	 */
	private Femme femme;

	/**
	 * C'est le père.
	 */
	private Homme homme;

	/**
	 * Qui est né.
	 */
	private Citoyen citoyen;

	/**
	 * Lieu de naissance.
	 */
	private Mairie mairie;

	/**
	 * Default constructor
	 */
	public Naissance(LocalDate dateNaissance, Homme pere, Femme mere,  Citoyen enfant, Mairie mairie) {
		this.dateNaissance = dateNaissance;
		this.homme = pere;
		this.femme = mere;
		this.citoyen = enfant;
		this.mairie = mairie;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public Femme getFemme() {
		return this.femme;
	}

	public Homme getHomme() {
		return this.homme;
	}

	public Citoyen getCitoyen() {
		return this.citoyen;
	}

	public Mairie getMairie() {
		return this.mairie;
	}
	// On met en private pour ne pas que l'on puisse modifier ultérieurement mais les méthodes get...
	// sont là pour pouvoir accéder aux valeurs.
}
