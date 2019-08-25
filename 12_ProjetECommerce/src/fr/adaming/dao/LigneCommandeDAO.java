package fr.adaming.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.entity.LigneCommande;

@Repository
public class LigneCommandeDAO {

	
	@Autowired
	private SessionFactory sf;

	//Getters et setters pour spring
	public SessionFactory getSessionFactory() {
		return sf;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sf = sessionFactory;
	}
	
/*___________ Les méthodes ____________*/

	

	@Transactional
	public int addLigneCommandeDao(LigneCommande pLigneCommande) {
		return (int) sf.getCurrentSession().save(pLigneCommande);

	}


	@Transactional
	public void updateLigneCommandeDao(LigneCommande pLigneCommande) {

		sf.getCurrentSession().update(pLigneCommande);

	}

	

	@Transactional
	public void deleteLigneCommandeDao(int pIdLigneCommande) {
		LigneCommande nLigneCommande= sf.getCurrentSession().get(LigneCommande.class, pIdLigneCommande);
		sf.getCurrentSession().delete(nLigneCommande);

	}



	

	@Transactional
	public LigneCommande getLigneCommandeDao(int pIdLigneCommande) {

		return sf.getCurrentSession().get(LigneCommande.class, pIdLigneCommande);

	}



	@Transactional
	public List<LigneCommande> getAllLigneCommandeDao() {

		return sf.getCurrentSession().createQuery("FROM ligneCommande l").getResultList();

	}

	

}
