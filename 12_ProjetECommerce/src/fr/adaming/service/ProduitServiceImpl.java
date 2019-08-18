package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.ProduitFacade;
import fr.adaming.entity.Produit;

@Service //D�claration de la classe comme Bean spring
public class ProduitServiceImpl implements IProduitService{

	// d�claration de la DAO 
	@Autowired //injection par type du bean dao
	private ProduitFacade pf;
	
	@Override
	public List<Produit> getAllService() {
		
		return pf.getAll();
	}

	@Override
	public void addService(Produit p) {
		pf.add(p);
	}

	@Override
	public void updateService(Produit p) {
		pf.update(p);
	}

	@Override
	public Produit findByIdService(Long id) {
		return pf.findById(id);
	}


 
	
	
}
