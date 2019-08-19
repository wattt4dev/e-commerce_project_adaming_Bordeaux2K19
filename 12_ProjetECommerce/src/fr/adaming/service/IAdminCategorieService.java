package fr.adaming.service;

import java.util.List;

import fr.adaming.entity.Categorie;
import fr.adaming.entity.Role;
import fr.adaming.entity.User;

public interface IAdminCategorieService extends IAdminProduitMetier{
	
	public void ajouterCategorie(Categorie categorie);
	public void supprimerCategorie(Long idCategorie);
	public void modifierCategorie(Categorie categorie);
	public void ajouterUser(User user);
	public void attribuerRole(Role role, Long idUser);
	
	
	//Méthodes User/Role
	public void ajouterRole (Role role);

}
