package fr.adaming.service;

import fr.adaming.dao.AbstractFacade;
import fr.adaming.dao.GestionCategorieDAO;
import fr.adaming.entity.Categorie;
import fr.adaming.entity.Role;
import fr.adaming.entity.User;

public class BoutiqueServiceImpl implements ICategorieService {
	
	//D�claration de la relation avec DAO
	private GestionCategorieDAO categorieDAO;
	
	
	//====================================================================
	//----------------------- M�thode de Cat�gorie -----------------------
	//====================================================================

	@Override
	public void ajouterCategorie(Categorie categorie) {
		categorieDAO.add(categorie);

	}

	@Override
	public void supprimerCategorie(Long idCategorie) {
		categorieDAO.delete(idCategorie);

	}

	@Override
	public void modifierCategorie(Categorie categorie) {
		categorieDAO.update(categorie);

	}

	@Override
	public void ajouterUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void attribueRole(Role role, int idUser) {
		// TODO Auto-generated method stub

	}
	
	//M�thodes propres � Categorie
	public Categorie getCategorieById(Long idCategorie) {
		return categorieDAO.findById(idCategorie);
	}
}
