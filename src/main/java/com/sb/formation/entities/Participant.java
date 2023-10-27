package com.sb.formation.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Participant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="id")
	private Long id;
	@Column(unique = true,nullable = false)
	private String nom;
	@Column(nullable = false)
	private String prenom;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String tel;
	
	@Enumerated(EnumType.STRING )
	private TypeForm type;

	
	@ManyToOne
	@JoinColumn(name = "profil_id")
	private Profil profil ;
	
	@ManyToOne
	@JoinColumn(name = "pays_id")
	private Pays pays ;
	
	@ManyToOne
	@JoinColumn(name = "organisme_id")
	private Organisme organisme ;
	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Organisme getOrganisme() {
		return organisme;
	}

	public void setOrganisme(Organisme organisme) {
			this.organisme = organisme;
	}


	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	public Pays getPays() {
		return pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}

    @ManyToMany(mappedBy = "participants", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Session> sessions;

	public Participant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Set<Session> getSessions() {
		return sessions;
	}

	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}

	public TypeForm getType() {
		return type;
	}

	public void setType(TypeForm type) {
		this.type = type;
	}

	public Participant(String nom, String prenom, String email, String tel, TypeForm type, Profil profil, Pays pays,
			Organisme organisme, Set<Session> sessions) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tel = tel;
		this.type = type;
		this.profil = profil;
		this.pays = pays;
		this.organisme = organisme;
		this.sessions = sessions;
	}








	
	
	
}
