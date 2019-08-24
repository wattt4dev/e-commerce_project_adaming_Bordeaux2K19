package fr.adaming.entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.persistence.Entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.adaming.entity.LigneCommande;
import fr.adaming.entity.Produit;

@Entity
public class Panier {
	
	
	private List<LigneCommande> panier;
		

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
