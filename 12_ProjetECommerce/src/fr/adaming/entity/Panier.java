package fr.adaming.entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.adaming.entity.LigneCommande;
import fr.adaming.entity.Produit;

@Entity(name="panier")
@Table(name="paniers")
public class Panier {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_panier")
	private int id;
	
	private double total;
	
	
	//asociation uml
	@OneToMany(mappedBy="panier")
	private List<LigneCommande> panier;
	
	
	//constructeurs
	public Panier() {
		super();
	}


	public List<LigneCommande> getPanier() {
		return panier;
	}


	public void setPanier(List<LigneCommande> panier) {
		this.panier = panier;
	}


	@Override
	public String toString() {
		return "Panier [panier=" + panier + "]";
	}





	



	


}
