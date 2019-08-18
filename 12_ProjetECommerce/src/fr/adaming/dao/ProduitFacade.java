package fr.adaming.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.entity.Produit;

@Repository
public class ProduitFacade extends AbstractFacade<Produit>{

	
	// Constructeur de l'entity
	public ProduitFacade() {
		super(Produit.class);
	}
	
	//attirbut de dao
	@Autowired	
	private SessionFactory sf;
	
	//getters et setters
	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf= sf;
	}
	
	
	
	//=================Méthodes propres à Produit ==========================//

	
	//GetAll les produits
	
	@Transactional(readOnly=true)
	public List<Produit> getAll(){
		
		return sf.getCurrentSession().createQuery("FROM produit p").getResultList();			
		
	}

}
