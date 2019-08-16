package fr.adaming.entity;

import java.util.Date;

public class Commande {
	
	
	//Attributs
	private Long idcommande;
	private Date dateCommande;
	
	//Constructeur
	public Commande() {
		super();
	}

	public Commande(Date dateCommande) {
		super();
		this.dateCommande = dateCommande;
	}

	public Commande(Long idcommande, Date dateCommande) {
		super();
		this.idcommande = idcommande;
		this.dateCommande = dateCommande;
	}

	
	//Getters et Setters
	public Long getIdcommande() {
		return idcommande;
	}

	public void setIdcommande(Long idcommande) {
		this.idcommande = idcommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	
	
	
	
	
	
	

}
