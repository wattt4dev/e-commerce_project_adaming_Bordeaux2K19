package fr.adaming.service;

import fr.adaming.entity.Produit;

public interface IAdminProduitMetier extends IInternauteBoutique{
	
	public Long addProduit(Produit p, Long idCat);
	
	public void deleteService(Long idCategorie);
	
	public void updateService(Produit p);
	
	public void addService(Produit p);

}
