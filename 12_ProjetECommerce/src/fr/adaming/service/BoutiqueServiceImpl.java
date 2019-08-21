package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.AbstractFacade;
import fr.adaming.dao.CategorieFacade;
import fr.adaming.dao.ProduitFacade;
import fr.adaming.dao.RoleFacade;
import fr.adaming.dao.UserFacade;
import fr.adaming.entity.Categorie;
import fr.adaming.entity.Client;
import fr.adaming.entity.Commande;
import fr.adaming.entity.GestionPanier;
import fr.adaming.entity.Produit;
import fr.adaming.entity.Role;
import fr.adaming.entity.User;

@Service // Déclaration Bean dans Spring
public class BoutiqueServiceImpl implements IAdminCategorieService {

	// Déclaration de la relation avec DAO
	@Autowired // Injection par type du DAO de Categorie
	private CategorieFacade categorieDAO;

	@Autowired
	private UserFacade userDAO;

	@Autowired
	private RoleFacade roleDAO;

	@Autowired
	private ProduitFacade produitDAO;

	// ====================================================================
	// ----------------------- Méthode de Catégorie -----------------------
	// ====================================================================

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

	public Categorie getCategorieById(Long idCategorie) {
		return categorieDAO.findById(idCategorie);
	}

	public List<Categorie> getAllCategorie() {
		return categorieDAO.getAllCategorie();
	}

	// ====================================================================
	// ------------------------- Méthode de User --------------------------
	// ====================================================================

	@Override
	public void ajouterUser(User user) {
		userDAO.add(user);

	}

	@Override
	public void attribuerRole(Role role, Long idUser) {
		role.setUser(userDAO.findById(idUser));
		roleDAO.add(role);
	}

	// ====================================================================
	// ------------------------- Méthode de Role --------------------------
	// ====================================================================

	@Override
	public void ajouterRole(Role role) {
		roleDAO.add(role);
	}

	
	
	
	// ====================================================================
	// ------------------------ Méthode de Produit ------------------------
	// ====================================================================

	@Override
	public Long addProduit(Produit p, Long idCat) {
		Categorie c1 = categorieDAO.findById(idCat);
		p.setCategorie(c1);
		produitDAO.add(p);

		return null;
	}

	@Override
	public void deleteProduitService(Long idP) {
		produitDAO.delete(idP);
	}

	@Override
	public void updateProduitService(Produit p) {
		produitDAO.update(p);
	}

	@Override
	public void addProduitService(Produit p) {
		produitDAO.add(p);
	}

	@Override
	public List<Produit> getAllProduitService() {
		return produitDAO.getAll();
	}

	@Override
	public Produit findProduitByIdService(Long i) {
		return produitDAO.findById(i);
	}

	@Override
	public List<Produit> getAllProduitByMotCleService(String mc) {
		return produitDAO.getAllByMotCle(mc);
	}

	@Override
	public List<Produit> getAllProduitByCategorieService(Long idCat) {
		return produitDAO.getAllByCategorie(idCat);
	}

	@Override
	public List<Produit> getAllProduitSelection() {
		return produitDAO.getAllSelection();
	}

	@Override
	public Commande enregistrerCommande(GestionPanier p, Client c) {
		
		return null;
	}
}
