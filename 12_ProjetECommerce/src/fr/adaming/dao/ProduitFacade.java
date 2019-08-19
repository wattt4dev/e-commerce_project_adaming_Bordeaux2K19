package fr.adaming.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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

	//Ajouter produit  par idCat
	
//	@Transactional
//	public void addProduit(Produit p, Long idCat){
//		sf.getCurrentSession().save(p);		
//	}
	
	//GetAll les produits
	
	@Transactional(readOnly=true)
	public List<Produit> getAll(){
		
		return sf.getCurrentSession().createQuery("FROM produit p").getResultList();			
		
	}
	
	//GetAll les produits par mot clé
	
	
	public List<Produit> getAllByMotCle(String mc){
		
		// 1. recup de la session d'hibernate
				Session session = sf.openSession();
				
				// 2. la requete HQL avec paramètres 
				/**
				 * param : notation par nom de paramètres 
				 */
				String requeteGetById = "SELECT p FROM produit p WHERE p.designation LIKE :kw";
				
				// 3. création de la requete 
				Query getByIdQuery = session.createQuery(requeteGetById);
				
				// 3.1. passage de params 
				getByIdQuery.setParameter("kw", mc);
				
				// 4. exec + recup du resultat 
				List<Produit> liste=   (List<Produit>) getByIdQuery.list();
				
				// 5. renvoi de la personne 
				return liste;
		
		
	}

}
