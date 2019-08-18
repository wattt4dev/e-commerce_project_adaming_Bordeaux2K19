package fr.adaming.service;

import fr.adaming.entity.Categorie;
import fr.adaming.entity.Role;
import fr.adaming.entity.User;

public interface IAdminCategorieService {
	
	public void ajouterCategorie(Categorie categorie);
	public void supprimerCategorie(int idCategorie);
	public void modifierCategorie(Categorie categorie);
	public void ajouterUser(User user);
	public void attribueRole(Role role, int idUser);

}
