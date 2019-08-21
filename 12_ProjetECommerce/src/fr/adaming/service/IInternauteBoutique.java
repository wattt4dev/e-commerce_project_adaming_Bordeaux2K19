package fr.adaming.service;

import java.util.List;

import fr.adaming.entity.Categorie;
import fr.adaming.entity.Client;
import fr.adaming.entity.Commande;
import fr.adaming.entity.GestionPanier;
import fr.adaming.entity.Produit;

public interface IInternauteBoutique {

	public List<Produit> getAllProduitService();

	public Produit findProduitByIdService(Long i);

	public List<Produit> getAllProduitByMotCleService(String mc);

	public List<Produit> getAllProduitByCategorieService(Long idCat);

	public List<Produit> getAllProduitSelection();

	// Méthodes propres à catégorie
	public Categorie getCategorieById(Long idCategorie);

	public List<Categorie> getAllCategorie();
	
	public Commande enregistrerCommande(GestionPanier p, Client c);

}
