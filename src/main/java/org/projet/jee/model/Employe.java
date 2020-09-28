package org.projet.jee.model;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "employes")
public class Employe implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private double salaire;
	
	
	@ManyToMany(mappedBy = "employes", fetch = FetchType.LAZY)
    private List<Societe> societes;


	public Employe() {
		super();
	}


	public Employe(int id, String nom, double salaire, List<Societe> societes) {
		super();
		this.id = id;
		this.nom = nom;
		this.salaire = salaire;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public double getSalaire() {
		return salaire;
	}


	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

/*
	public List<Societe> getSocietes() {
		return societes;
	}


	public void setSocietes(List<Societe> societes) {
		this.societes = societes;
	}
*/

	
	
    
	

}
