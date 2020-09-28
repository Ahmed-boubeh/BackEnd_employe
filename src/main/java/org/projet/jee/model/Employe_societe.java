package org.projet.jee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "socities_employes")
public class Employe_societe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int socities_id;
	private int employes_id;
	public Employe_societe(int id, int socities_id, int employes_id) {
		super();
		this.id = id;
		this.socities_id = socities_id;
		this.employes_id = employes_id;
	}
	public Employe_societe() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSocities_id() {
		return socities_id;
	}
	public void setSocities_id(int socities_id) {
		this.socities_id = socities_id;
	}
	public int getEmployes_id() {
		return employes_id;
	}
	public void setEmployes_id(int employes_id) {
		this.employes_id = employes_id;
	}
	
	

}
