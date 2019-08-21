package fr.adaming.entity;

import java.util.ArrayList;
import java.util.List;


public class GestionPanier {

private List<Produit> listeproduits = new ArrayList<>();
	
	public void ajouterProduit(Produit pProduit) {
		listeproduits.add(pProduit);
	}//end ajouter
	
	
	/**
	 * renvoie la listee des produits dans le panier
	 * @return
	 */
	public List<Produit> getProduitsPanier(){
		return listeproduits;
	}
	
}
