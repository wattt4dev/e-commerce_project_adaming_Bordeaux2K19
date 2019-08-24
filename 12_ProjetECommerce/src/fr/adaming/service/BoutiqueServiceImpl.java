package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.AbstractFacade;
import fr.adaming.dao.CategorieFacade;
import fr.adaming.dao.CommandeDAO;
import fr.adaming.dao.GestionPanierDao;
import fr.adaming.dao.LigneCommandeDAO;
import fr.adaming.dao.ProduitFacade;
import fr.adaming.dao.RoleFacade;
import fr.adaming.dao.UserFacade;
import fr.adaming.entity.Categorie;
import fr.adaming.entity.Client;
import fr.adaming.entity.Commande;
import fr.adaming.entity.LigneCommande;
import fr.adaming.entity.Panier;
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
	
	@Autowired
	private GestionPanierDao gpDao;
	
	@Autowired
    LigneCommandeDAO lcDAO;
	
	@Autowired
	CommandeDAO cDAO;

	public GestionPanierDao getGpDao() {
		return gpDao;
	}

	public void setGpDao(GestionPanierDao gpDao) {
		this.gpDao = gpDao;
	}


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

	@Override
	public List<User> getAllUser() {
		return userDAO.getAllUser();
	}

	@Override
	public User getUserById(Long idUser) {
		return userDAO.findById(idUser);
	}
	
	@Override
	public void supprimerUser(Long idUser) {
		userDAO.delete(idUser);
	}

	@Override
	public void modifierUser(User user) {
		userDAO.update(user);
	}

	// ====================================================================
	// ------------------------- Méthode de Role --------------------------
	// ====================================================================

	@Override
	public void ajouterRole(Role role) {
		roleDAO.add(role);
	}
	
	@Override
	public List<Role> getAllRole() {
		return roleDAO.getAllRole();
	}

	@Override
	public Role getRoleById(int idRole) {
		return roleDAO.findById((long) idRole);
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
	public Commande enregistrerCommande(Panier p, Client c) {
		
		return null;
	}

	
	public void ajouterProduitPanier(Produit produit, int quantite) {
		
	}
	
	// ====================================================================
	// ------------------------ Méthode de LigneCommande ------------------------
	// ====================================================================


	//Méthodes du crude
	

	public int addLigneCommandeService(LigneCommande pLigneCommande) {

		pLigneCommande.setPrix(pLigneCommande.getQuantite()*pLigneCommande.getProduit().getPrix());

		return lcDAO.addLigneCommandeDao(pLigneCommande);

	}


	public void updateLigneCommandeService(LigneCommande pLigneCommande) {

		lcDAO.updateLigneCommandeDao(pLigneCommande);		

	}


	public void deleteLigneCommandeService(int pIdLigneCommande) {

		lcDAO.deleteLigneCommandeDao(pIdLigneCommande);;

	
	}


	public LigneCommande getLigneCommandeService(int pIdLigneCommande) {

		
		return lcDAO.getLigneCommandeDao(pIdLigneCommande);

	}



	public List<LigneCommande> getAllLigneCommandeService() {
		
		return lcDAO.getAllLigneCommandeDao();

	}


	public void ajouterLigneCommandeDansCommandeBDD(LigneCommande pLigneCommande, Commande pCommande) {

	
		pLigneCommande.setCommande(pCommande);

		lcDAO.updateLigneCommandeDao(pLigneCommande);

		pCommande=cDAO.getCommandeDao(pCommande.getIdCommande());

		List<LigneCommande> listeLigneCommande= pCommande.getListeLigneCommande();

		
		Double total = 0.0;
	

		for(LigneCommande ligneCommande : listeLigneCommande) {

			System.out.println("> Prix de la ligne:"+ligneCommande.getPrix());

			total = total + ligneCommande.getPrix();

		}

		

		System.out.println("tolal="+ total);

		pCommande.setTotal(total);

		cDAO.updateCommandeDao(pCommande);

	}
	
	// ====================================================================
	// ------------------------ Méthode de Panier ------------------------
	// ====================================================================

	
	public int addPanierService(Panier pPanier) {

		return gpDao.addPanierDao(pPanier);

	}


	public void updatePanierService(Panier pPanier) {

		gpDao.updatePanierDao(pPanier);

	}


	public void deletePanierService(int pIdPanier) {

		gpDao.deletePanierDao(pIdPanier);

	}


	public Panier getPanierService(int pIdPanier) {

		return gpDao.getPanierDao(pIdPanier);

	}


	public List<Panier> getAllPanierService() {
	
		return gpDao.getAllPanierDao();

	}

	// ====================================================================
	// ------------------------ Méthode de Commande ------------------------
	// ====================================================================


	
	public int addCommandeService(Commande pCommande) {
	
		return cDAO.addCommandeDao(pCommande);

	}


	public void updateCommandeService(Commande pCommande) {

		cDAO.updateCommandeDao(pCommande);	

	}


	public void deleteCommandeService(int pIdCommande) {

		cDAO.deleteCommandeDao(pIdCommande);

	
	}



	public Commande getCommandeService(int pIdCommande) {
		

		return cDAO.getCommandeDao(pIdCommande);

	}



	public List<Commande> getAllCommandeService() {

	
		return cDAO.getAllCommandeDao();

	}

}
