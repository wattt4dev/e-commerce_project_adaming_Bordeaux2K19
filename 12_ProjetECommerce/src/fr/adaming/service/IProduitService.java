package fr.adaming.service;

import java.util.List;

import fr.adaming.entity.Produit;

public interface IProduitService {
	
	public List<Produit> getAllService();
	
	 public void addService(Produit p);
	 
	 public void updateService(Produit p);
	 
	 public Produit findByIdService(Long i);

}
