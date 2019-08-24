package fr.adaming.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="ligneCommande")
@Table(name="lignesCommande")
public class LigneCommande implements Serializable{
	
	
	//déclaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLigneCommande;
	private int quantite;
	private double prix;
	
	//Association
	@ManyToOne
	@JoinColumn(name="commande_id", referencedColumnName="idCommande")
	private Commande commande;
	
	@OneToOne
	@JoinColumn(name="produit_id", referencedColumnName="idProduit")
	private Produit produit;
	
	
	@ManyToOne
	@JoinColumn(name="panier_id")
	private Panier panier;

	private long idP;
	
	
	//constructeurs (vide et chargés)
	public LigneCommande() {
		super();
	}



	public LigneCommande(int quantite, double prix) {
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



	public Commande getCommande() {
		return commande;
	}



	public void setCommande(Commande commande) {
		this.commande = commande;
	}



	public Produit getProduit() {
		return produit;
	}



	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	


	public long getIdP() {
		return idP;
	}



	public void setIdP(long idP) {
		this.idP = idP;
	}



	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	


	public int getIdLigneCommande() {
		return idLigneCommande;
	}



	public void setIdLigneCommande(int idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
	}



	@Override
	public String toString() {
		return "LigneCommande [idLigneCommande=" + idLigneCommande + ", quantite=" + quantite + ", prix=" + prix
				+ ", commande=" + commande + " , produit= , idP=" + idP + "]";
	}







	



	
	
	
	
	

}
