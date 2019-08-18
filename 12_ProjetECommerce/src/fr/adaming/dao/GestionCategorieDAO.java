package fr.adaming.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.entity.Categorie;

/**
 * Facade pour la classe Catégorie à partir de la classe astraite AbstractFacade
 * 
 * @author IN-BR-006
 *
 */

public class GestionCategorieDAO extends AbstractFacade<Categorie> {

	// Déclaration d'une SessionFactory
	private SessionFactory sf;
	
	// Getter et setter de la SessionFactory
	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf= sf;
	}

	// Constructeur vide
	public GestionCategorieDAO() {
		super(Categorie.class);
	}// end constructeur vide GestionCategorieDAO

	// Méthodes propres à la classe Catégorie

	/**
	  * Méthode getAll Catégorie copié à partir de AbstractFacade
	  */
	
	@Transactional(readOnly=true)
	public List<Categorie> getAllCategorie(){
		return sf.getCurrentSession().createQuery("FROM categorie").getResultList();			
		
	}
	
}
