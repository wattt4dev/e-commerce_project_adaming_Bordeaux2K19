package fr.adaming.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import fr.adaming.entity.Categorie;
import fr.adaming.entity.Produit;
import fr.adaming.service.IAdminCategorieService;
import fr.adaming.service.IAdminProduitMetier;

/**
 *  implementation d'un controleur spring mvc pour le produit
 * @author IN-BR-009
 *
 */

@Controller
public class AdminProduitsController {
	
	@Autowired
	private IAdminProduitMetier iapm;

	//Getters et setters pour injection Spring
	public IAdminProduitMetier getIapm() {
		return iapm;
	}

	public void setIapm(IAdminProduitMetier iapm) {
		this.iapm = iapm;
	}
	
	@Autowired
	private IAdminCategorieService iacs;

	// Getter et setter du Bean IAdminCategorieService pour accès Spring
	public IAdminCategorieService getIacs() {
		return iacs;
	}// end getter

	public void setIacs(IAdminCategorieService iacs) {
		this.iacs = iacs;
	}// end setter
	
	//==================================================================//
	//================Méthode permettant de lister les produits=========//
	//==================================================================//
	
	@RequestMapping(value = "adminProduit/liste_produits", method = RequestMethod.GET)
	public String listerProduitsBdd(ModelMap modeleDonnees) {
		
		//1 - récup des données de la bdd
		List<Produit> listeProduits = iapm.getAllProduitService();
		String message = "Gestion des Produits";
		Date toDay = new Date();
		
		//2 - encapsulation dans le model map
		modeleDonnees.addAttribute("att_listeProduits", listeProduits );
		modeleDonnees.addAttribute("attribut_message", message);
		modeleDonnees.addAttribute("attribut_date", toDay);
		//3 - Nom logique de la vue
		String nomVue = "liste_produits";
		
		return nomVue;
	}
	
	//=====================================================================//
	//================Méthode permettant de supprimer les produits=========//
	//=====================================================================//

	@RequestMapping(value =  "adminProduit/produit/delete/{pProduitId}", method = RequestMethod.GET)
	public String deleteProduit(@PathVariable("pProduitId") Long aProduitId, ModelMap modeleDonnees) {
		Produit produit=iapm.findProduitByIdService(aProduitId);
		produit.setCategorie(null);
		iapm.updateProduitService(produit);
		iapm.deleteProduitService((long)aProduitId);
		
		List<Produit> listeProduits = iapm.getAllProduitService();
		
		modeleDonnees.addAttribute("att_listeProduits", listeProduits );

		return "redirect:/adminProduit/liste_produits";
		
	}
	
	//=======================================================================//
	//================Méthode permettant  Affichage formulaire Ajout=========//
	//=======================================================================//
	
	@RequestMapping(value = "/adminProduit/addProduit", method = RequestMethod.GET)
	public ModelAndView setUpFormulaireAjout() {
		
		// 1 - definition des donnes a retourner vers la servlet
		Map<String, Object> data = new HashMap<>();
		
		// 1.1 définition des objets de commande (objet fonctionnaire vide)
		Produit produit = new Produit();
		Categorie categorie = new Categorie();
		List<Categorie> listeCategories = iapm.getAllCategorie();
		
		produit.setCategorie(categorie);
		// 1.2 Association
		data.put("produitCommande",produit);
		//data.put("categorieCommande",categorie);
		data.put("attribut_categories", listeCategories);
		
		// 2. nom logique de la vue
		String viewName = "ajouter_produit";
		
		// 3- renvoi
		return new ModelAndView(viewName, data);
		
	}
	
		
	//================================================================//
	//================Méthode permettant d'ajouter un produit=========//
	//================================================================//

	@RequestMapping(value = "adminProduit/produit/add", method = RequestMethod.POST)
	public String addProduitBDD(@ModelAttribute("produitCommande") Produit pProduit,ModelMap modeleDonnees, MultipartFile file) throws IOException {
		
		if (!file.isEmpty()) {
			pProduit.setPhoto(file.getBytes());
		}else {
			pProduit.setPhoto(new byte[0]);
		}
		long idCat=pProduit.getIdCat();	

		iapm.addProduit(pProduit, idCat);
		
		//iapm.addProduitService(pProduit);
		List<Produit> listeProduits = iapm.getAllProduitService();
		
		modeleDonnees.addAttribute("att_listeProduits", listeProduits );
		
		return "redirect:/adminProduit/liste_produits";
	}//end addProduit


	//==================================================================//
	//================Méthode permettant de modifier un produit=========//
	//==================================================================//

	@RequestMapping(value="adminProduit/produit/updateform", method=RequestMethod.GET)
	public ModelAndView setUpFormulaireUpdate(@RequestParam("produitId") Long pIdProduit) {
			//1. recup du fonctionnaire à modifier via son id
		Map<String, Object> data = new HashMap<>();
		
		Produit produitUp = iapm.findProduitByIdService(pIdProduit);
		
		List<Categorie> listeCategories = iapm.getAllCategorie();
		
		data.put("attribut_categories", listeCategories);
		data.put("produitUpCommand", produitUp );
		

		//return new ModelAndView("updateProduit", "produitUpCommand", produitUp );
		return new ModelAndView("updateProduit", data ); 

	}//end setUpFormulaireUpdate
	
	@RequestMapping(value= "/adminProduit/produit/update", method=RequestMethod.POST)
	public String updateProduitBdd(@ModelAttribute("produitUpCommand") Produit produitToUpdate, ModelMap modelDOnnees, MultipartFile file) throws IOException {
		
		if (!file.isEmpty()) {
			produitToUpdate.setPhoto(file.getBytes());
		}else {
			produitToUpdate.setPhoto(new byte[0]);
		}
		
		//1. Modif du fonctionnaire das la bdd via le service
		iapm.updateProduitService(produitToUpdate);
		
		//2.recup de la liste des fonct dans la bdd + redirection vers la liste_fonctionnaires.jsp
		modelDOnnees.addAttribute("att_listeProduits",iapm.getAllProduitService() );
		
		return "redirect:/adminProduit/liste_produits";
	}
	
	
}//end controller
