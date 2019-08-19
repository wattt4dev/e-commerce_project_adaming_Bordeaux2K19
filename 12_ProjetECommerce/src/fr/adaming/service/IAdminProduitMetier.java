package fr.adaming.service;

import fr.adaming.entity.Produit;

public interface IAdminProduitMetier extends IInternauteBoutique{
	
	public Long addProduit(Produit p, Long idCat);
	
	public void deleteProduitService(Long idCategorie);
	
	public void updateProduitService(Produit p);
	
	public void addProduitService(Produit p);

}
