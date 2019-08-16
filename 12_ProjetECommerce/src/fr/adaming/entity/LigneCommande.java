package fr.adaming.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="ligneCommande")
@Table(name="ligneCommandes")
public class LigneCommande {
	
	
	//d�claration des attributs
	private int quantit�;
	private double prix;

	
	
	//constructeurs (vide et charg�s)
	public LigneCommande() {
		super();
	}



	public LigneCommande(int quantit�, double prix) {
		super();
		this.quantit� = quantit�;
		this.prix = prix;
	}


	//getters et setters 

	public int getQuantit�() {
		return quantit�;
	}


	public void setQuantit�(int quantit�) {
		this.quantit� = quantit�;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}



	@Override
	public String toString() {
		return "LigneCommande [quantit�=" + quantit� + ", prix=" + prix + "]";
	}




	
	
	
	
	

}
