package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.CategorieFacade;
import fr.adaming.dao.ProduitFacade;
import fr.adaming.entity.Categorie;
import fr.adaming.entity.Produit;

@Service //Déclaration de la classe comme Bean spring
public class ProduitServiceImpl implements IInternauteBoutique{

	// déclaration de la DAO 
	@Autowired //injection par type du bean dao
	private ProduitFacade pf;
	
	@Autowired //injection par type du bean dao
	private CategorieFacade cf;
	
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

	@Override
	public void deleteService(Long idCategorie) {
		pf.delete(idCategorie);
		
	}

	@Override
	public List<Produit> getAllByMotCleService(String mc) {
	
		return pf.getAllByMotCle(mc);
	}

	@Override
	public List<Produit> getAllByCategorieService(Long idCat) {
		
		return pf.getAllByCategorie(idCat);
	}

	@Override
	public List<Produit> getAllSelection() {
		return pf.getAllSelection();
	}

	// Ajouter produit par idCat
	
	@Transactional
	public Long addProduit(Produit p, Long idCat) {
		
		Categorie c1 = cf.findById(idCat);
		p.setCategorie(c1);
		pf.add(p);		

		return null;
	}


 
	
	
}
