package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.AbstractFacade;
import fr.adaming.dao.GestionCategorieDAO;
import fr.adaming.entity.Categorie;
import fr.adaming.entity.Role;
import fr.adaming.entity.User;

@Service //Déclaration Bean dans Spring
public class BoutiqueServiceImpl implements ICategorieService {
	
	//Déclaration de la relation avec DAO
	@Autowired //Injection par type du DAO de Categorie
	private GestionCategorieDAO categorieDAO;
	
	
	//====================================================================
	//----------------------- Méthode de Catégorie -----------------------
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
		categorieDAO.update(categorie);;

	}

	@Override
	public void ajouterUser(User user) {
		

	}

	@Override
	public void attribueRole(Role role, int idUser) {
		// TODO Auto-generated method stub

	}
	
	//Méthodes propres à Categorie
	public Categorie getCategorieById(Long idCategorie) {
		return categorieDAO.findById(idCategorie);
	}
	
	public List<Categorie> getAllCategorie(){
		return categorieDAO.getAllCategorie();
	}
}
