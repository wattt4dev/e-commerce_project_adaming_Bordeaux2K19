package fr.adaming.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.entity.Commande;

@Repository
public class CommandeDAO {

	
	@Autowired
	private SessionFactory sf;
	

	public SessionFactory getSf() {
		return sf;
	}


	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}


	/*___________ Les méthodes ____________*/

	@Transactional
	public int addCommandeDao(Commande pCommande) {
		return (int) sf.getCurrentSession().save(pCommande);
	}
	


	@Transactional
	public void updateCommandeDao(Commande pCommande) {
		sf.getCurrentSession().update(pCommande);
	}
	

	@Transactional
	public void deleteCommandeDao(int pIdCommande) {
		Commande nCommande = sf.getCurrentSession().get(Commande.class, pIdCommande);
		sf.getCurrentSession().delete(nCommande);
	}


	@Transactional
	public Commande getCommandeDao(long pIdCommande) {
		return sf.getCurrentSession().get(Commande.class, pIdCommande);
	}



	@Transactional
	public List<Commande> getAllCommandeDao() {

		return sf.getCurrentSession().createQuery("FROM commande").getResultList();

	}




}
