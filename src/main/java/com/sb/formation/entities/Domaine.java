package com.sb.formation.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
public class Domaine implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="id")
	private Long id;
	@Column(unique = true,nullable = false)
	private String libelle;
	
	@OneToMany(mappedBy = "domaine")
	@JsonIgnore
	private Set<Formation> formations ;
	


	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	public Domaine() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Domaine(String libelle) {
		super();
		this.libelle = libelle;
	}
	public Set<Formation> getFormations() {
		return formations;
	}
	public void setFormations(Set<Formation> formations) {
		this.formations = formations;
	}

	
	
	


	
	

	}