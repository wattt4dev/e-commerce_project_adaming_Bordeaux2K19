package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.adaming.dao.ProduitFacade;
import fr.adaming.entity.Produit;

public class ProduitServiceImpl implements IProduitService{

	// déclaration de la DAO 
	@Autowired //injection par type du bean dao
	private ProduitFacade pf;
	
	@Override
	public List<Produit> getAllService() {
		
		return pf.getAll();
	}
 
}
