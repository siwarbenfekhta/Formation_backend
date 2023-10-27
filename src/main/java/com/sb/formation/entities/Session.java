package com.sb.formation.entities;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Session {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="id")
	private Long id;
	@Column(nullable = false)
	private String lieu;
	@Column
	private String Date_debut;
	@Column
	private String date_fin ;
	@Column(nullable = false)
	private int nb_partcipant ;
	
	@ManyToOne
	@JoinColumn(name = "organisme_id")
	private Organisme organisme ;
	
	@ManyToOne
	@JoinColumn(name = "formateur_id")
	private Formateur formateur ;
	
	@ManyToOne
	@JoinColumn(name = "formation_id")
	private Formation formation ;
	

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "participant_session", 
	joinColumns = @JoinColumn(name = "session_id"), 
	inverseJoinColumns = @JoinColumn(name = "participant_id"))
	private Set<Participant> participants = new HashSet<>();
	
	

	public Long getIdSession() {
		return id;
	}

	public void setIdSession(Long idSession) {
		this.id = idSession;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate_debut() {
		return Date_debut;
	}

	public void setDate_debut(String date_debut) {
		Date_debut = date_debut;
	}

	public String getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}


	public int getNb_partcipant() {
		return nb_partcipant;
	}

	public void setNb_partcipant(int nb_partcipant) {
		this.nb_partcipant = nb_partcipant;
	}

	public Organisme getOrganisme() {
		return organisme;
	}

	public void setOrganisme(Organisme organisme) {
		this.organisme = organisme;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public Set<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<Participant> participants) {
		this.participants = participants;
	}


	

	public Session(String lieu, String date_debut, String date_fin, int nb_partcipant, Organisme organisme,
			Formateur formateur, Formation formation) {
		super();
		this.lieu = lieu;
		Date_debut = date_debut;
		this.date_fin = date_fin;
		this.nb_partcipant = nb_partcipant;
		this.organisme = organisme;
		this.formateur = formateur;
		this.formation = formation;
	}

	public Session() {
		super();
		// TODO Auto-generated constructor stub
	}
	

    
    

}
