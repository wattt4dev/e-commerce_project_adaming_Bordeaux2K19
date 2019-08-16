package fr.adaming.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="ligneCommande")
@Table(name="lignesCommande")
public class LigneCommande {
	
	
	//déclaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLigneCommande;
	private int quantite;
	private double prix;
	

	
	
	//constructeurs (vide et chargés)
	public LigneCommande() {
		super();
	}



	public LigneCommande(int quantité, double prix) {
		super();
		this.quantite = quantite;
		this.prix = prix;
	}


	//getters et setters 

	public int getQuantite() {
		return quantite;
	}


	public void setQuantité(int quantite) {
		this.quantite = quantite;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}



	@Override
	public String toString() {
		return "LigneCommande [quantité=" + quantite + ", prix=" + prix + "]";
	}




	
	
	
	
	

}
