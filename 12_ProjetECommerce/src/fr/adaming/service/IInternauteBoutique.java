package fr.adaming.service;

import java.util.List;

import fr.adaming.entity.Categorie;
import fr.adaming.entity.Produit;

public interface IInternauteBoutique {

	public List<Produit> getAllService();

	public Produit findByIdService(Long i);

	public List<Produit> getAllByMotCleService(String mc);

	public List<Produit> getAllByCategorieService(Long idCat);

	public List<Produit> getAllSelection();

	// Méthodes propres à catégorie
	public Categorie getCategorieById(Long idCategorie);

	public List<Categorie> getAllCategorie();

}
