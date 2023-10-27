package com.sb.formation.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Formation  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="id")
	private Long id;
	@Column(unique = true,nullable = false)
	private String titre;
	@Column(nullable = false)
	private int annee ;
	@Column(nullable = false)
	private int nb_session ;
	@Column(nullable = false)
	private int duree ;
	@Column(nullable = false)
	private double budget ;
	
	@Enumerated(EnumType.STRING )
	private TypeForm type_formation;

	@ManyToOne
	@JoinColumn(name = "domaine_id")
	private Domaine domaine ;
	
	
	public Long getIdFormation() {
		return id;
	}
	
	@OneToMany(mappedBy = "formation")
	@JsonIgnore
	private Set<Session> sessions ;

	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public int getNb_session() {
		return nb_session;
	}
	public void setNb_session(int nb_session) {
		this.nb_session = nb_session;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}

	public TypeForm getType_formation() {
		return type_formation;
	}
	public void setType_formation(TypeForm type_formation) {
		this.type_formation = type_formation;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	

	public Set<Session> getSessions() {
		return sessions;
	}
	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}
	public Formation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Domaine getDomaine() {
		return domaine;
	}
	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}
	public Formation(String titre, int annee, int nb_session, int duree, double budget, TypeForm type_formation,
			Domaine domaine) {
		super();
		this.titre = titre;
		this.annee = annee;
		this.nb_session = nb_session;
		this.duree = duree;
		this.budget = budget;
		this.type_formation = type_formation;
		this.domaine = domaine;
	}

	

	
	


}
