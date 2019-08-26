package fr.adaming.dao;

import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.entity.Categorie;
import fr.adaming.entity.Produit;

/**
 * Facade pour la classe Catégorie à partir de la classe astraite AbstractFacade
 * 
 * @author IN-BR-006
 *
 */
@Repository
public class CategorieFacade extends AbstractFacade<Categorie> {

	// Déclaration d'une SessionFactory
	@Autowired
	private SessionFactory sf;
	
	// Getter et setter de la SessionFactory
	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf= sf;
	}

	// Constructeur vide
	public CategorieFacade() {
		super(Categorie.class);
	}// end constructeur vide GestionCategorieDAO

	
	//==================================================================================================
	//============================= Méthodes propres à la classe Catégorie =============================
	//==================================================================================================
	
	/**
	  * Méthode getAll Catégorie copié à partir de AbstractFacade
	  */
	
	@Transactional(readOnly=true)
	public List<Categorie> getAllCategorie(){
		
		List<Categorie> liste=sf.getCurrentSession().createQuery("FROM categorie c").getResultList();
		
		
		for(Categorie p:liste) {
			p.setPictureCat("data:image/png;base64,"+Base64.encodeBase64String(p.getPhoto()));
		}
		
		return liste;		
		
		
		
	}
	
}
