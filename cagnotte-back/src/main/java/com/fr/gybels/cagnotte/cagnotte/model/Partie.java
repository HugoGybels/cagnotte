package com.fr.gybels.cagnotte.cagnotte.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Partie {

	@Id
	private Integer idPartie;

	private String typeJeu;

	private LocalDateTime date;

	@OneToMany(mappedBy="partie")
	private Set<Resultat> resultat;

	public Integer getIdPartie() {
		return idPartie;
	}

	public void setIdPartie(Integer idPartie) {
		this.idPartie = idPartie;
	}

	public String getTypeJeu() {
		return typeJeu;
	}

	public void setTypeJeu(String typeJeu) {
		this.typeJeu = typeJeu;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Set<Resultat> getResultat() {
		return resultat;
	}

	public void setResultat(Set<Resultat> resultat) {
		this.resultat = resultat;
	}
}
