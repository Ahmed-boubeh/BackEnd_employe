package org.projet.jee.model;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;


@Entity
@Table(name="socities")
public class Societe implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String adresse;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "socities_employes",
            joinColumns = {
                    @JoinColumn(name = "socities_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "employes_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private List<Employe> employes ;

	public Societe() {
		super();
	}

	public Societe(int id, String nom, String adresse, List<Employe> employes) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.employes = employes;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public List<Employe> getemployes() {
		return employes;
	}

	public void setemployes(List<Employe> employes) {
		this.employes = employes;
	};
	
	
	
}
