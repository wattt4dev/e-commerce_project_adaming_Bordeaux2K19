package fr.adaming.service;

import java.util.List;

import fr.adaming.entity.Categorie;
import fr.adaming.entity.Client;
import fr.adaming.entity.Commande;
import fr.adaming.entity.LigneCommande;
import fr.adaming.entity.Panier;
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

	public List<LigneCommande> getAllLigneService();
	
	public int addLigneCommandeService(LigneCommande pLigneCommande) ;


	public void updateLigneCommandeService(LigneCommande pLigneCommande);

	public void deleteLigneCommandeService(int pIdLigneCommande) ;


	public LigneCommande getLigneCommandeService(int pIdLigneCommande) ;


	public List<LigneCommande> getAllLigneCommandeService() ;

	public void ajouterLigneCommandeDansCommandeBDD(LigneCommande pLigneCommande, Commande pCommande) ;
	
	// ====================================================================
	// ------------------------ Méthode de Panier ------------------------
	// ====================================================================

	
	public int addPanierService(Panier pPanier);


	public void updatePanierService(Panier pPanier) ;


	public void deletePanierService(int pIdPanier) ;


	public Panier getPanierService(int pIdPanier) ;


	public List<Panier> getAllPanierService() ;

	// ====================================================================
	// ------------------------ Méthode de Commande ------------------------
	// ====================================================================


	
	public void addCommandeService(Commande pCommande) ;

	public void updateCommandeService(Commande pCommande) ;

	public void deleteCommandeService(long pIdCommande) ;

	public Commande getCommandeService(long pIdCommande);

	public List<Commande> getAllCommandeService() ;
	
	
	//-----methodes de client
	
	public int addClientService(Client client) ;

	public void updateClientService(Client client) ;

	public void deleteClientService(int pIdclient) ;

	public Client getClientService(int pIdclient);

	public List<Client> getAllClientService() ;
	

	//----- methode enregistrer commande
	
	
	
	

}
