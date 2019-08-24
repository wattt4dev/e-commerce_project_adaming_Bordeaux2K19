package fr.adaming.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;

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
	public void ajouterLigneCommande(LigneCommande lc) {
		sf.getCurrentSession().save(lc);
	}
	
	
	public void modifierQuantite( LigneCommande lc) {
		sf.getCurrentSession().update(lc);
	}
	
	
	
	public void retirerProduitPanier (int idl) {
		LigneCommande lc=rechercherLigne(idl);
		System.out.println("ligne de commande avant null produit "+lc);		
		lc.setProduit(null);
		lc.setIdP(0);
		sf.getCurrentSession().flush();
		lc.setIdLigneCommande(idl);
		System.out.println("juste avant de supprimer la ligne de commande"+lc);
		sf.getCurrentSession().delete(lc);
	}	

	
	public LigneCommande rechercherLigne(int idl) {
		LigneCommande lc=sf.getCurrentSession().get(LigneCommande.class, idl);
		return lc;
		
	}
	
	public List<LigneCommande> getAllLigne(){
		
		return sf.getCurrentSession().createQuery("FROM ligneCommande l").getResultList();
		
		
	}

}
