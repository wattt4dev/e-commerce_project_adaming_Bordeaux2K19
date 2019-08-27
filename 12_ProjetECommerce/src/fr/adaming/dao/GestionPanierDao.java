package fr.adaming.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.entity.Panier;
import fr.adaming.entity.Commande;
import fr.adaming.entity.LigneCommande;
import fr.adaming.entity.Produit;

@Repository
@Transactional
public class GestionPanierDao {
	
	// attirbut de dao
		@Autowired
		private SessionFactory sf;

		// getters et setters
		public SessionFactory getSf() {
			return sf;
		}

		public void setSf(SessionFactory sf) {
			this.sf = sf;
		}
	
	
	//metdodes	
	
		@Transactional
		public int addPanierDao(Panier pPanier) {
			return (int) sf.getCurrentSession().save(pPanier);
		}

				

		@Transactional
		public void updatePanierDao(Panier pPanier) {
			sf.getCurrentSession().update(pPanier);
		}

		

		

		@Transactional
		public void deletePanierDao(int pIdPanier) {

			Session session = sf.getCurrentSession();

			Panier nPanier = session.get(Panier.class, pIdPanier);

			session.delete(nPanier);
			

		}

		
	
		@Transactional
		public Panier getPanierDao(int panId) {
			return sf.getCurrentSession().get(Panier.class, panId);

		}

		


		@Transactional
		public List<Panier> getAllPanierDao() {
			return sf.getCurrentSession().createQuery("FROM panier p").getResultList();
		}

		

}
