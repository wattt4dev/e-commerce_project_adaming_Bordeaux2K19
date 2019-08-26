package fr.adaming.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name="categorie")
@Table(name="categories")
public class Categorie implements Serializable {
	
	
	//declaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCategorie;
	private String nomCategorie;
	@Lob
	private byte[] photo;
	private String description;
	@Transient
	private String pictureCat;
	
	@OneToMany(mappedBy="categorie")
	private List<Produit> listeProduitsCat = new ArrayList<Produit>();
	
	
	//constructeurs (vide et chargé)
	
	public Categorie() {
		super();
	}
	

	public Categorie(String nomCategorie, String description) {
		super();
		this.nomCategorie = nomCategorie;
		this.description = description;
	}


	public Categorie(String nomCategorie, byte[] photo, String description) {
		super();
		this.nomCategorie = nomCategorie;
		this.photo = photo;
		this.description = description;
	}

	public Categorie(Long idCategorie, String nomCategorie, byte[] photo, String description) {
		super();
		this.idCategorie = idCategorie;
		this.nomCategorie = nomCategorie;
		this.photo = photo;
		this.description = description;
	}


	
	//getters et setters 
	
	public long getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getDescription() {
		return description;
	}
	

	public String getPictureCat() {
		return pictureCat;
	}


	public void setPictureCat(String pictureCat) {
		this.pictureCat = pictureCat;
	}


	public List<Produit> getListeProduitsCat() {
		return listeProduitsCat;
	}


	public void setListeProduitsCat(List<Produit> listeProduitsCat) {
		this.listeProduitsCat = listeProduitsCat;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Categorie [idCategorie=" + idCategorie + ", nomCategorie=" + nomCategorie + ", photo="
				+ photo + ", description=" + description + "]";
	}
	
	

	

}
