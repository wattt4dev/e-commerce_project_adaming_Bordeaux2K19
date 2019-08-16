package fr.adaming.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="ligneCommande")
@Table(name="ligneCommandes")
public class LigneCommande {
	
	
	//déclaration des attributs
	private int quantité;
	private double prix;

	
	
	//constructeurs (vide et chargés)
	public LigneCommande() {
		super();
	}



	public LigneCommande(int quantité, double prix) {
		super();
		this.quantité = quantité;
		this.prix = prix;
	}


	//getters et setters 

	public int getQuantité() {
		return quantité;
	}


	public void setQuantité(int quantité) {
		this.quantité = quantité;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}



	@Override
	public String toString() {
		return "LigneCommande [quantité=" + quantité + ", prix=" + prix + "]";
	}




	
	
	
	
	

}
