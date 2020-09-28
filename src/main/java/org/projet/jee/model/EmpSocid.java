package org.projet.jee.model;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;


public class EmpSocid{
	
	private int id;
	private String nom;
	private double salaire;
	private int societe_id;
	public EmpSocid(int id, String nom, double salaire, int societe_id) {
		super();
		this.id = id;
		this.nom = nom;
		this.salaire = salaire;
		this.societe_id = societe_id;
	}
	public EmpSocid() {
		super();
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
	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}
	public int getSociete_id() {
		return societe_id;
	}
	public void setSociete_id(int societe_id) {
		this.societe_id = societe_id;
	}
	
	
	

	
	
    
	

}
