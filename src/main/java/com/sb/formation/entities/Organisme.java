package com.sb.formation.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
@Entity
public class Organisme implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="id")
	private Long id;
	
	
	@OneToMany(mappedBy = "organisme")
	@JsonIgnore
	private Set<Formateur> formateurs ;
	
	@OneToMany(mappedBy = "organisme")
	@JsonIgnore
	private Set<Session> sessions ;
	
	@OneToMany(mappedBy = "organisme")
	@JsonIgnore
	private Set<Participant> participants ;
	
	@Column(unique = true,nullable = false)
	private String libelle;


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	public Set<Formateur> getFormateurs() {
		return formateurs;
	}
	public void setFormateurs(Set<Formateur> formateurs) {
		this.formateurs = formateurs;
	}

	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Set<Session> getSessions() {
		return sessions;
	}
	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}
	public Set<Participant> getParticipants() {
		return participants;
	}
	public void setParticipants(Set<Participant> participants) {
		this.participants = participants;
	}


	
	
	public Organisme(String libelle) {
		super();
		this.libelle = libelle;
	}
	public Organisme() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
