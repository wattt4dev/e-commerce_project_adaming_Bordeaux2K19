package fr.adaming.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.entity.Categorie;

/**
 * Facade pour la classe Cat�gorie � partir de la classe astraite AbstractFacade
 * 
 * @author IN-BR-006
 *
 */
@Repository
public class GestionCategorieDAO extends AbstractFacade<Categorie> {

	// D�claration d'une SessionFactory
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
	public GestionCategorieDAO() {
		super(Categorie.class);
	}// end constructeur vide GestionCategorieDAO

	
	//==================================================================================================
	//============================= M�thodes propres � la classe Cat�gorie =============================
	//==================================================================================================
	
	/**
	  * M�thode getAll Cat�gorie copi� � partir de AbstractFacade
	  */
	
	@Transactional(readOnly=true)
	public List<Categorie> getAllCategorie(){
		return sf.getCurrentSession().createQuery("FROM categorie c").getResultList();			
		
	}
	
}
